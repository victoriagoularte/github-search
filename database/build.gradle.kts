plugins {
    id("com.viclab.library")
    id("com.viclab.hilt")
}

android {
    namespace = "com.viclab.database"
}

dependencies {
    implementation(project(":core"))
    implementation("com.google.firebase:firebase-firestore-ktx:24.4.2")

    with(libs.androidx) {
        implementation(core.ktx)
        implementation(room.compiler)
        implementation(room.runtime)
    }

    testImplementation(libs.bundles.test)
}