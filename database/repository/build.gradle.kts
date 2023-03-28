plugins {
    id("com.viclab.library")
    id("com.viclab.hilt")
}

android {
    namespace = "com.viclab.database.repository"
}

dependencies {
    implementation(project(":core"))

    with(libs.androidx) {
        implementation(core.ktx)
    }

    testImplementation(libs.bundles.test)
}