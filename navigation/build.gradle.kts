plugins {
  id("plugin.tvmaniac.kotlin.android")
  id("plugin.tvmaniac.multiplatform")
  alias(libs.plugins.serialization)
}

kotlin {
  sourceSets {
    androidMain.dependencies {
      implementation(projects.android.designsystem)
      implementation(projects.android.resources)

      implementation(projects.android.feature.discover)
      implementation(projects.android.feature.library)
      implementation(projects.android.feature.moreShows)
      implementation(projects.android.feature.search)
      implementation(projects.android.feature.seasonDetails)
      implementation(projects.android.feature.settings)
      implementation(projects.android.feature.showDetails)
      implementation(projects.android.feature.trailers)

      implementation(libs.androidx.compose.material3)
      implementation(libs.decompose.extensions.compose)
    }

    commonMain.dependencies {
      implementation(projects.core.base)
      implementation(projects.core.traktAuth.api)
      implementation(projects.core.util)

      implementation(projects.presentation.discover)
      implementation(projects.presentation.library)
      implementation(projects.presentation.moreShows)
      implementation(projects.presentation.search)
      implementation(projects.presentation.seasondetails)
      implementation(projects.presentation.settings)
      implementation(projects.presentation.showDetails)
      implementation(projects.presentation.trailers)

      implementation(libs.kotlinInject.runtime)

      api(libs.decompose.decompose)
      api(libs.essenty.lifecycle)
    }

    commonTest.dependencies {
      implementation(kotlin("test"))
      implementation(projects.core.datastore.testing)
      implementation(projects.core.traktAuth.testing)
      implementation(projects.data.cast.testing)
      implementation(projects.data.featuredshows.testing)
      implementation(projects.data.library.testing)
      implementation(projects.data.popularshows.testing)
      implementation(projects.data.recommendedshows.testing)
      implementation(projects.data.seasons.testing)
      implementation(projects.data.seasondetails.testing)
      implementation(projects.data.showdetails.testing)
      implementation(projects.data.similar.testing)
      implementation(projects.data.topratedshows.testing)
      implementation(projects.data.trailers.testing)
      implementation(projects.data.trendingshows.testing)
      implementation(projects.data.upcomingshows.testing)
      implementation(projects.data.watchproviders.testing)

      implementation(libs.bundles.unittest)
    }
  }
}

android {
  namespace = "com.thomaskioko.tvmaniac.navigation"

  buildFeatures { compose = true }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  composeOptions { kotlinCompilerExtensionVersion = libs.versions.composecompiler.get() }
}
