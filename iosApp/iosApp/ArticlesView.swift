//
//  ArticlesView.swift
//  iosApp
//
//  Created by Carlos Andres Martinez Suarez on 25/09/25.
//

import SwiftUI
import Shared

struct ArticlesView: View {
    @StateObject private var viewModel = ArticlesViewModelObserver()

    var body: some View {
        NavigationView {
            VStack {
                if viewModel.isLoading {
                    ProgressView("Cargando...")
                        .padding()
                } else if let error = viewModel.error {
                    Text("Error: \(error)")
                        .foregroundColor(.red)
                        .padding()
                } else {
                    ScrollView {
                        LazyVStack(spacing: 10) {
                            ForEach(viewModel.articles, id: \.self) { article in
                                ArticlesItemView(article:article)
                            }
                        }
                    }
                }
            }
            .navigationTitle("Artículos")
        }
    }
}

struct ArticlesItemView: View {
    var article: ArticleEntity
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string:article.imageUrl)) { phase in
                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error == nil {
                    Text("Image Loading Error")
                } else {
                    ProgressView()
                }
            }
            
            Text(article.name)
                .font(.title)
                .fontWeight(.bold)
            
            Text(article.description_)
        }
    }
}

#Preview {
    ArticlesView()
}
