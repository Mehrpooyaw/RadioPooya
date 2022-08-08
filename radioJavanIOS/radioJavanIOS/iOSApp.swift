import SwiftUI
import radioJavanShared
@main
struct iOSApp: App {
    init(){
        AppModuleKt.doInitKoin()
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
