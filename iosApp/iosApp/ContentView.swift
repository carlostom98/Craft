import SwiftUI
import Shared

struct ContentView: View {
    @State private var showContent = false
    var body: some View {
        VStack {
            ArticlesUI(viewModel: .init())
        }
    }
}

#Preview {
    ContentView()
}
       
