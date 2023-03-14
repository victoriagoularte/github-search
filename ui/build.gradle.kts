plugins {
    id("com.viclab.library")
    id("com.viclab.hilt")
    id("com.viclab.compose")
}

android {
    namespace = "com.viclab.ui"
}

dependencies {
    implementation(project(":model"))
    with(libs.androidx) {
        implementation(core.ktx)
    }
}