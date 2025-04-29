package manager

import platform.UIKit.UIDevice

actual val AppRandomID: String = "ios.apple.${UIDevice.currentDevice.systemVersion}"

actual fun getPlatform(): String {
    return "iOS"
}

actual class PlatformModel {
    actual val year: Int = 2025

    actual fun desc(): String {
        return "Desc from iOS - year:$year"
    }
}

actual object DeviceManager {}

actual interface PlatformInterface {
    actual val id: Int
    val iOSVer: Int
}

actual enum class KitEnum {
    SwiftUI,
    ApplePay,
    Combine
}