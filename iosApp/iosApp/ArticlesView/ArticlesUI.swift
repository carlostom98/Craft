//
//  ArticlesUI.swift
//  iosApp
//
//  Created by Carlos Andres Martinez Suarez on 2/09/25.
//

import SwiftUI
import Shared


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
