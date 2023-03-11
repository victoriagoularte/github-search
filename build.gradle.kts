// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    with(libs.plugins) {
        alias(android.application) apply false
        alias(android.library) apply false
        alias(hilt) apply false
        alias(kotlin.jvm) apply false
        alias(kotlin.android) apply false
        alias(kotlin.serialization) apply false
        alias(libs.plugins.secrets) apply false
    }
}