plugins {
  id("plugin.tvmaniac.kotlin.android")
  id("plugin.tvmaniac.multiplatform")
  alias(libs.plugins.sqldelight)
  alias(libs.plugins.ksp)
}

kotlin {
  sourceSets {
    androidMain { dependencies { implementation(libs.sqldelight.driver.android) } }

    commonMain {
      dependencies {
        implementation(projects.core.base)
        implementation(libs.sqldelight.primitive.adapters)
        implementation(libs.kotlinInject.runtime)
        implementation(libs.kotlinx.datetime)
      }
    }

    androidUnitTest {
      dependencies {
        implementation(kotlin("test"))
        implementation(libs.sqldelight.driver.jvm)
      }
    }

    commonTest {
      dependencies {
        implementation(kotlin("test"))
        implementation(libs.kotest.assertions)
      }
    }

    iosMain {
      dependencies {
        implementation(libs.sqldelight.driver.native)

        // See https://github.com/cashapp/sqldelight/issues/4357
        implementation("co.touchlab:stately-common:2.0.6")
        implementation("co.touchlab:stately-isolate:2.0.6")
        implementation("co.touchlab:stately-iso-collections:2.0.7")
      }
    }

    jvmTest { dependencies { implementation(libs.sqldelight.driver.jvm) } }
  }
}

dependencies {
  add("kspAndroid", libs.kotlinInject.compiler)
  add("kspIosX64", libs.kotlinInject.compiler)
  add("kspIosArm64", libs.kotlinInject.compiler)
}

android { namespace = "com.thomaskioko.tvmaniac.db" }

sqldelight {
  databases { create("TvManiacDatabase") { packageName.set("com.thomaskioko.tvmaniac.core.db") } }
  linkSqlite.set(true)
}
