object Versions {
    internal const val compose = "1.3.0-alpha01"
    internal const val retrofit = "2.9.0"
    internal const val coroutines = "1.6.3"
    internal const val RETROFIT_KOTLIN_SERIALIZATION = "0.8.0"
    internal const val KOTLIN_SERIALIZATION_JSON = "1.3.2"
    const val COMPOSE_COMPILER = "1.3.0"
}

object Dependencies {
    // core
    const val ktxCore = "androidx.core:core-ktx:1.8.0"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.0"
    const val appCombat = "androidx.appcompat:appcompat:1.5.0"

    // compose
    const val activityCompose = "androidx.activity:activity-compose:1.5.0"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiTest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    const val composeNavigation = "androidx.navigation:navigation-compose:2.5.0"

    // dagger - hilt
    const val hilt = "com.google.dagger:hilt-android:2.42"
    const val hiltLifecycleViewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:2.42"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"

    // json
    const val kotlinSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLIN_SERIALIZATION_JSON}"

    // ui
    const val accompanist = "com.google.accompanist:accompanist-systemuicontroller:0.17.0"

    // viewmodel
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0"
    const val viewmodelLifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"

    // Coroutines & Coroutine Lifecycle Scopes
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"


    // test
    const val coreTest = "androidx.test:core-ktx:1.4.0"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val jUnit = "junit:junit:4.13.2"
    const val expressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    const val androidxJunit = "androidx.test.ext:junit:1.1.3"
    const val googleTruth = "com.google.truth:truth:1.1.3"
    const val mockk = "io.mockk:mockk:1.12.4"
    const val androidMockk = "io.mockk:mockk-android:1.12.7"
    const val composeUiTestJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val turbine = "app.cash.turbine:turbine:0.9.0"
}