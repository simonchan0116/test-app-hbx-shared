package manager

// property
expect val AppRandomID: String

// func
expect fun getPlatform(): String

// class (beta)
expect class PlatformModel {
    val year: Int

    fun desc(): String
}

// singleton (beta)
expect object DeviceManager {}

// interface (beta)
expect interface PlatformInterface {
    val id: Int
}

// enum (beta)
expect enum class KitEnum