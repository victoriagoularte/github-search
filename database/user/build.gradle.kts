plugins {
    id("com.viclab.library")
    id("com.viclab.hilt")
}

android {
    namespace = "com.viclab.database.user"
}

dependencies {
    implementation(project(":core"))

    with(libs.androidx) {
        implementation(core.ktx)
    }

    testImplementation(libs.bundles.test)
}