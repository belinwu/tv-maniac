plugins {
  id("plugin.tvmaniac.multiplatform")
  alias(libs.plugins.ksp)
}

kotlin {
  sourceSets {
    commonMain {
      dependencies {
        implementation(projects.core.base)
        implementation(projects.core.database)
        implementation(projects.data.cast.api)

        implementation(libs.kotlinInject.runtime)
        implementation(libs.sqldelight.extensions)
        implementation(libs.kotlinx.atomicfu)
        implementation(libs.store5)
      }
    }

    commonMain {
      dependencies {
        implementation(kotlin("test"))
        implementation(libs.turbine)
        implementation(libs.kotest.assertions)
      }
    }
  }
}

dependencies {
  add("kspIosX64", libs.kotlinInject.compiler)
  add("kspIosArm64", libs.kotlinInject.compiler)
}
