import org.gradle.api.artifacts.dsl.DependencyHandler

const val kotlinVersion = "1.5.10"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.2.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
}

object AndroidSdk {
    const val min = 21
    const val target = 31
}

fun DependencyHandler.roomDb() {
    add("implementation", Libraries.roomDb)
    add("implementation", Libraries.roomGuava)
    add("implementation", Libraries.roomKtx)
    add("kapt", Libraries.roomCompiler)
    add("testImplementation", Libraries.roomTesting)
}

fun DependencyHandler.koin() {
    add("implementation", Libraries.koin)
//    add("implementation", Libraries.koinViewModel)
    add("implementation", Libraries.koinTest)
}

fun DependencyHandler.lifecycleLibs() {
    add("kapt", Libraries.lifecycleCommon)
    add("implementation", Libraries.lifecycleExtensions)
    add("implementation", Libraries.lifecycleViewModel)
}

fun DependencyHandler.navigation() {
    add("implementation", Libraries.navigationFragmentKtx)
    add("implementation", Libraries.navigationFragmentUiKtx)
}

fun DependencyHandler.appCenter() {
    add("implementation", Libraries.appCenterAnalytics)
    add("implementation", Libraries.appCenterCrashes)
}

fun DependencyHandler.retrofit(configurationType: ConfigurationType = ConfigurationType.Implementation) {
    add(configurationType.value, Libraries.retrofit)
    add(configurationType.value, Libraries.retrofitConverterGson)
}

fun DependencyHandler.paging(configurationType: ConfigurationType = ConfigurationType.Implementation) {
    add(configurationType.value, Libraries.paging2)
//    add(configurationType.value, Libraries.pagingRuntime)
//    add(configurationType.value, Libraries.pagingGuava)
}

fun DependencyHandler.firebase(
    configurationType: ConfigurationType = ConfigurationType.Implementation,
    withAuth: Boolean = false
) {
    add(configurationType.value, "com.google.firebase:firebase-core:20.0.2")
    add(configurationType.value, "com.google.firebase:firebase-messaging:23.0.0")
    add(configurationType.value, "com.google.firebase:firebase-storage:20.0.0")
    if (withAuth) {
        add(configurationType.value, Libraries.firebaseAuth)
        add(configurationType.value, Libraries.firebaseAuthSignInGoogle)
    }
//    add("implementation", "com.google.firebase:firebase-ml-vision:24.1.0")
}

fun DependencyHandler.hilt(configurationType: ConfigurationType, withCompose: Boolean = false) {
    add(configurationType.value, Libraries.hiltAndroid)
    if (withCompose) {
        add(configurationType.value, Libraries.hiltCompose)
    }
//    add(configurationType.value, Libraries.hiltAndroidGoogle)
    add("kapt", Libraries.hiltAndroidCompiler)
//    add("kapt", Libraries.hiltAndroidXCompiler)
}

enum class ConfigurationType(val value: String) {
    Implementation("implementation"), Api("api")
}