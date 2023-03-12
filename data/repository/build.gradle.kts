plugins {
    id("com.viclab.library")
    id("com.viclab.hilt")
}

android {
    namespace = "com.viclab.data.repository"
}

dependencies {
    implementation(project(":core"))
    implementation(libs.bundles.network)

    with(libs.androidx) {
        implementation(core.ktx)
        implementation(lifecycle.viewmodel)
        implementation(lifecycle.viewmodel.ktx)
    }

    testImplementation(libs.bundles.test)
}