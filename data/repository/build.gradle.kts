plugins {
    id("com.viclab.library")
    id("com.viclab.hilt")
}

android {
    namespace = "com.viclab.data.repository"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":model"))
    implementation(libs.bundles.network)

    with(libs.androidx) {
        implementation(core.ktx)
        implementation(paging.common)
    }

    testImplementation(libs.bundles.test)
}