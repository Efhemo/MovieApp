import Dependencies.DI

plugins {
    kotlinLibrary
    kotlin(kotlinKapt)
}

dependencies {
    implementation(DI.hiltCore)
    kapt(DI.AnnotationProcessor.daggerHilt)
}