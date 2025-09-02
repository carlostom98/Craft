//
//  ArticlesUI.swift
//  iosApp
//
//  Created by Carlos Andres Martinez Suarez on 2/09/25.
//

import SwiftUI
import Shared

extension ArticlesUI {
    


struct ArticlesUI: View {
    
    
    var body: some View {
        VStack {
            AppBar()
            
            if viewModel.articlesState.isLoading {
                Loader()
            }
            
            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }
            
            let articles = viewModel.articlesState.articles
            
            if(!articles.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(articles, id: \.self) { article in
                            ArticleItemView(article: <#T##ArticleEntity#>)
                        }
                    }
                }
            }
        }
    }.onAppear {
        self.viewModel.startObserving()
    }
}

struct AppBar: View {
    var body: some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct ArticleItemView: View {
    var article: ArticleEntity
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.imageUrl)) { phase in
                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }
            
            Text(article.name)
                .font(.title)
                .fontWeight(.bold)
            
            Text(article.description)
        }
        .padding(16)
    }
}
