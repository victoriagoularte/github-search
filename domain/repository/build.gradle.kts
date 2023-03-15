plugins {
    id("com.viclab.library")
    id("com.viclab.hilt")
}

android {
    namespace = "com.viclab.domain"
}

dependencies {
    implementation(project(":model"))
    implementation(project(":data:repository"))

    testImplementation(libs.bundles.test)
}