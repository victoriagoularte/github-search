plugins {
    id("com.viclab.feature")
}

android {
    namespace = "com.viclab.features.repository"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":model"))
    implementation(project(":domain:repository"))
    with(libs.androidx) {
        implementation(core.ktx)
        implementation(paging.compose)
        implementation(paging.runtime)
        implementation(paging.common)
    }

    testImplementation(libs.bundles.test)
}