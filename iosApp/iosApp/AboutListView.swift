//
//  AboutListView.swift
//  iosApp
//
//  Created by Carlos Andres Martinez Suarez on 28/08/25.
//

import SwiftUI
import Shared

struct AboutListView: View {
    private struct RowItem: Hashable {
        let title: String
        let subtitle: String
    }
    
    
    private let items: [RowItem] = {
        let platform = Platform()
        
        var result: [RowItem] = [
            .init(title: "Operative System",
                  subtitle: "\(platform.osName) \(platform.osVersion)"),
            .init(title: "Device",
                  subtitle: platform.deviceModel),
            .init(title: "Operative System",
                  subtitle: String(platform.density))
        ]
        
        return result
    }()
    
    var body: some View {
        List {
            ForEach (items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
            }
        }
    }
}

#Preview {
    AboutListView()
}
