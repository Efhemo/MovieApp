const val kotlinAndroid: String = "android"
const val kotlinAndroidExtension: String = "android.extensions"
const val kotlinKapt: String = "kapt"
const val ktLintVersion: String = "0.36.0"
const val kotlinVersion = "1.7.0"


object Config {
    object Version {
        const val minSdkVersion: Int = 21
        const val compileSdkVersion: Int = 33
        const val targetSdkVersion: Int = 33
        const val versionName: String = "1.0"
        const val versionCode: Int = 1
    }

    const val isMultiDexEnabled: Boolean = true

    object Android {
        const val applicationId: String = "com.efhem.moviegalore"
        const val testInstrumentationRunner: String = "androidx.test.runner.AndroidJUnitRunner"
    }
}

interface Libraries {
    val components: List<String>
}

object Dependencies {
    object AndroidX : Libraries {
        object Version {
            const val coreKtx: String = "1.7.0"
            const val navigation: String = "2.5.0"
            const val multidex: String = "2.0.1"
            const val lifeCycle: String = "2.5.0"
            const val activity: String = "1.5.0"
        }

        private const val coreKtx: String = "androidx.core:core-ktx:${Version.coreKtx}"
        private const val navigationFragmentKtx: String =
            "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        private const val navigationUiKtx: String =
            "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
        private const val multiDex: String = "androidx.multidex:multidex:${Version.multidex}"
        private const val activity: String = "androidx.activity:activity:${Version.activity}"
        private const val lifeCycleCommon: String =
            "androidx.lifecycle:lifecycle-common-java8:${Version.lifeCycle}"
        private const val viewModel: String =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifeCycle}"
        private const val livedata: String =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifeCycle}"


        override val components: List<String>
            get() = listOf(
                coreKtx, navigationFragmentKtx, navigationUiKtx, multiDex, activity,
                lifeCycleCommon, viewModel, livedata
            )
    }

    object View : Libraries {
        object Version {
            const val materialComponent: String = "1.4.0"
            const val shimmerLayout: String = "0.5.0"
            const val appCompat: String = "1.4.2"
            const val constraintLayout: String = "2.0.0"
            const val fragment: String = "1.5.0"
            const val cardView: String = "1.0.0"
            const val recyclerView: String = "1.2.1"
            const val glide = "4.11.0"
        }

        const val appCompat: String = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val fragment: String = "androidx.fragment:fragment-ktx:${Version.fragment}"
        const val cardView: String = "androidx.cardview:cardview:${Version.cardView}"
        const val materialComponent: String =
            "com.google.android.material:material:${Version.materialComponent}"
        const val shimmerLayout: String =
            "com.facebook.shimmer:shimmer:${Version.shimmerLayout}"
        const val constraintLayout: String =
            "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
        const val recyclerView: String =
            "androidx.recyclerview:recyclerview:${Version.recyclerView}"
        private const val glide = "com.github.bumptech.glide:glide:${Version.glide}"

        override val components: List<String> = listOf(appCompat, fragment, constraintLayout, recyclerView, materialComponent, glide)
    }

    object DI {
        object Version {
            const val daggerHilt: String = "2.42"
        }

        object AnnotationProcessor {
            const val daggerHilt: String =
                "com.google.dagger:hilt-compiler:${Version.daggerHilt}"
        }

        const val daggerHiltAndroid: String =
            "com.google.dagger:hilt-android:${Version.daggerHilt}"
        const val hiltTesting: String =
            "com.google.dagger:hilt-android-testing:${Version.daggerHilt}"
        const val hiltCore: String = "com.google.dagger:hilt-core:${Version.daggerHilt}"
    }

    object Cache {
        object Version {
            const val room: String = "2.5.0-alpha01"
        }

        object AnnotationProcessor {
            const val room: String = "androidx.room:room-compiler:${Version.room}"
        }

        const val room: String = "androidx.room:room-ktx:${Version.room}"
    }

    object Coroutines : Libraries {
        object Version {
            const val coroutines: String = "1.6.3"
            const val dateTime: String = "0.4.0"
        }

        const val core: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val android: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"

        override val components: List<String> = listOf(core, android)
    }


    object Network : Libraries {
        object Version {
            const val okhttp: String = "5.0.0-alpha.2"
            const val retrofit: String = "2.9.0"
            const val moshi: String = "1.9.2"
            const val kotlinSerialization: String = "1.3.2"
        }

        object AnnotationProcessor {
            const val moshi: String = "com.squareup.moshi:moshi-kotlin-codegen:${Version.moshi}"
        }

        private const val okhttp: String = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
        private const val loggingInterceptor: String =
            "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
        const val retrofit: String = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val retrofitMoshi: String =
            "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
        const val moshi: String = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"

        override val components: List<String> = listOf(
            okhttp,
            loggingInterceptor,
            retrofit,
            retrofitMoshi,
            moshi
        )
    }

    object Test {
        object Version {
            const val junit: String = "4.13"
            const val runner: String = "1.3.0"
            const val rules: String = "1.3.0"
            const val testExt: String = "1.1.2"
            const val truth: String = "1.0.1"
            const val archCoreTest: String = "1.1.1"
            const val mockWebServer: String = "4.9.2"
            const val composeTest: String = "1.0.1"
            const val turbine: String = "0.8.0"

        }

        const val junit: String = "junit:junit:${Version.junit}"
        const val runner: String = "androidx.test:runner:${Version.runner}"
        const val rules: String = "androidx.test:rules:${Version.rules}"
        const val androidXTest: String = "androidx.test.ext:junit:${Version.testExt}"
        const val archCoreTest: String = "android.arch.core:core-testing:${Version.archCoreTest}"
        const val truth: String = "com.google.truth:truth:${Version.truth}"
        const val coroutinesTest: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Coroutines.Version.coroutines}"
        const val kotlinDateTime: String =
            "org.jetbrains.kotlinx:kotlinx-datetime:${Coroutines.Version.dateTime}"
        const val mockWebServer: String =
            "com.squareup.okhttp3:mockwebserver:${Version.mockWebServer}"
        const val composeUITests: String =
            "androidx.compose.ui:ui-test-junit4:${Version.composeTest}"
        const val composeUIManifestTests: String =
            "androidx.compose.ui:ui-test-manifest:${Version.composeTest}"
        const val turbine: String =
            "app.cash.turbine:turbine:${Version.turbine}"
    }
}

object ProjectLib {
    const val local: String = ":core:local"
    const val network: String = ":core:network"
    const val data: String = ":core:data"
    const val model: String = ":core:model"
    const val featureMovie: String = ":feature:movie"

}
