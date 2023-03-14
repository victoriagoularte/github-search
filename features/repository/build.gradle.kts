plugins {
    id("com.viclab.feature")
}

android {
    namespace = "com.viclab.features.repository"
}

dependencies {
    implementation(project(":core"))
    with(libs.androidx) {
        implementation(core.ktx)
    }
}