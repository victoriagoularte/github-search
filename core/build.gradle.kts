plugins {
    id("com.viclab.library")
    id("com.viclab.hilt")
    id("com.viclab.compose")
}

android {
    namespace = "com.viclab.core"
}

dependencies {
    with(libs.androidx) {
        implementation(core.ktx)
        implementation(lifecycle.viewmodel)
        implementation(lifecycle.viewmodel.ktx)
    }
}