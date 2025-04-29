package manager

object RegionManager {
    enum class Region(val nameStr: String, val lang: String) {
        US("US", "en-US"),
        CN("CN", "zh-CN"),
        HK("HK", "zh-HK"),
        JP("JP", "ja-JP"),
        KR("KR", "ko-KR")
    }

    fun regionDollar(region: Region): String {
        val dollar: String = when (region) {
            Region.US -> "$"
            Region.CN -> "¥"
            Region.HK -> "$"
            Region.JP -> "¥"
            Region.KR -> "₩"
        }
        return dollar
    }
}