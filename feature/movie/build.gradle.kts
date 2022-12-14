import Dependencies.DI
import Dependencies.Coroutines
import Dependencies.Test
import Dependencies.View
import Dependencies.AndroidX


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
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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

    buildFeatures {
        viewBinding  = true
    }
}

dependencies {

    implementAll(Coroutines.components)
    implementAll(View.components)
    implementAll(AndroidX.components)

    implementation(project(ProjectLib.data))
    implementation(project(ProjectLib.model))

    implementation(DI.daggerHiltAndroid)
    kapt(DI.AnnotationProcessor.daggerHilt)

    testImplementation(Test.turbine)
    testImplementation(Test.junit)
    testImplementation(Test.truth)
    testImplementation(Test.coroutinesTest)
    testImplementation(Test.kotlinDateTime)
}
