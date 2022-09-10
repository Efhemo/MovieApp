import Dependencies.DI
import Dependencies.Test
import Dependencies.Network

plugins {
    kotlinLibrary
    kotlin(kotlinKapt)
}

dependencies {
    implementAll(Network.components)
    implementation(DI.hiltCore)
    kapt(DI.AnnotationProcessor.daggerHilt)

    testImplementation(Test.turbine)
    testImplementation(Test.mockWebServer)
    testImplementation(Test.junit)
    testImplementation(Test.truth)
    testImplementation(Test.coroutinesTest)
}

