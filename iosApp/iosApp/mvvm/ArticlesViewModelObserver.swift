//
//  ArticlesViewModelObserver.swift
//  iosApp
//
//  Created by Carlos Andres Martinez Suarez on 25/09/25.
//

import Foundation
import Shared

class ArticlesViewModelObserver: ObservableObject {
    private let articlesVm = ArticlesViewModel()
    private var subscription: Close?
    
    @Published var articles: [ArticleEntity] = []
    @Published var isLoading: Bool = false
    @Published var error: String? = nil
    
    init() {
        getAllArticles()
        startObserving()
    }
    
    private func startObserving() {
        subscription = articlesVm.articlesState.watch(
            onEmit: { [weak self] state in
            guard let self = self else { return }
                DispatchQueue.main.async {
                    self.articles = state?.articles ?? []
                }
        })
    }
    
    private func getAllArticles() {
        articlesVm.getArticles()
    }
    
    deinit {
        subscription?.close()
    }
}
