object Versions {
    const val koin_version= "3.2.2"
    const val koin_android_version= "3.2.2"
    const val koin_android_compose_version= "3.2.1"
    const val koin_ktor= "3.2.2"
}

object Deps {
    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin_version}"
        const val test = "io.insert-koin:koin-test:${Versions.koin_version}"
        const val android = "io.insert-koin:koin-android:${Versions.koin_version}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin_android_compose_version}"
    }
}