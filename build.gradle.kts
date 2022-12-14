import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories.applyDefault()
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

allprojects {
    repositories.applyDefault()
    configurations.all {
        resolutionStrategy.eachDependency {
            if (requested.group == "org.jetbrains.kotlin") {
                useVersion(kotlinVersion)
            }
        }
    }
}

subprojects {
    tasks.withType<KotlinCompile>().configureEach {
        with(kotlinOptions) {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            freeCompilerArgs += "-Xuse-experimental=" +
                    "kotlin.Experimental," +
                    "kotlinx.coroutines.ExperimentalCoroutinesApi," +
                    "kotlinx.coroutines.InternalCoroutinesApi," +
                    "kotlinx.coroutines.ObsoleteCoroutinesApi," +
                    "kotlinx.coroutines.FlowPreview"
            freeCompilerArgs += "-Xopt-in=kotlin.ExperimentalStdlibApi"
        }
    }
}