package manager

actual val AppRandomID: String = "an.google.${android.os.Build.VERSION.SDK_INT}"

actual fun getPlatform(): String {
    return "Android"
}

actual class PlatformModel {
    actual val year: Int = 2010

    actual fun desc(): String {
        return "Desc from An - year:$year"
    }
}

actual object DeviceManager {}

actual interface PlatformInterface {
    actual val id: Int
}

actual enum class KitEnum {
    Activity,
    Compose,
    Rx
}