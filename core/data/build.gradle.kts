import Dependencies.DI
import Dependencies.Coroutines
import Dependencies.Test


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

    implementAll(Coroutines.components)

    implementation(project(ProjectLib.model))
    implementation(project(ProjectLib.network))
    implementation(project(ProjectLib.local))

    implementation(DI.daggerHiltAndroid)
    kapt(DI.AnnotationProcessor.daggerHilt)

    testImplementation(Test.junit)
    testImplementation(Test.truth)
    testImplementation(Test.coroutinesTest)
}
