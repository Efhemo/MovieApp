import Dependencies.Cache
import Dependencies.DI
import Dependencies.Coroutines

plugins {
    androidLibrary
    kotlin(kotlinAndroid)
    kotlin(kotlinKapt)
    daggerHilt
}

android {
    compileSdk = Config.Version.compileSdkVersion
    defaultConfig {
        minSdk = Config.Version.minSdkVersion
        targetSdk = Config.Version.targetSdkVersion

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += Pair("room.incremental", "true")
            }
        }
        buildConfigField("int", "databaseVersion", 1.toString())
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        named(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }
    }
}

dependencies {

    implementation(DI.daggerHiltAndroid)
    implementation(Cache.room)
    implementAll(Coroutines.components)

    kapt(Cache.AnnotationProcessor.room)
    kapt(DI.AnnotationProcessor.daggerHilt)
}
