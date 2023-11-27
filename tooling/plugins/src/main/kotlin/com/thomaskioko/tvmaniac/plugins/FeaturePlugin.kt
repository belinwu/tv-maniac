package com.thomaskioko.tvmaniac.plugins
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("plugin.tvmaniac.compose.library")
                apply("com.google.devtools.ksp")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    manifestPlaceholders["appAuthRedirectScheme"] = "empty"
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("api", project(":android-core:designsystem"))
                add("api", project(":core:util"))

                add("implementation", project(":android-core:resources"))

                add("implementation", libs.findLibrary("androidx.compose.foundation").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtime.compose").get())
                add("implementation", libs.findLibrary("coroutines.core").get())
                add("implementation", libs.findLibrary("kotlinInject.runtime").get())

                add("ksp", libs.findLibrary("kotlinInject.compiler").get())
                add("runtimeOnly", libs.findLibrary("coroutines.android").get())
            }
        }
    }
}
