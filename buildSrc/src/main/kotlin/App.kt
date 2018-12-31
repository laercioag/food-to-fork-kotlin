object App {
    val applicationId = "com.laercioag.foodtofork"
    val apiKey = "f55e3137c4d7ad4828c3e97cd0247296"
    val apiUrl = "https://www.food2fork.com/api/"

    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0

    val versionCode = versionMajor * 1000 + versionMinor * 100 + versionPatch
    val versionName = "$versionMajor.$versionMinor.$versionPatch"
}