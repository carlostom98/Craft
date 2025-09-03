//
//  ArticlesViewModel.swift
//  iosApp
//
//  Created by Carlos Andres Martinez Suarez on 16/09/25.
//

import Foundation
import Shared


extension ArticlesUI {
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticlesViewModel
        @Published var articlesState: ArticleState
        
        init() {
            articlesViewModel = ArticlesViewModel()
            articlesState = articlesViewModel.articlesState
        }
        
    
        func startObserving() {
            
        }
    }
}
