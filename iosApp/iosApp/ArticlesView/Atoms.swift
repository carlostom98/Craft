//
//  Atoms.swift
//  iosApp
//
//  Created by Carlos Andres Martinez Suarez on 2/09/25.
//

import SwiftUI

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage: View {
    var message: String
    var body: some View {
        Text(message)
            .font(.title)
    }
}

#Preview {
    Loader()
}
