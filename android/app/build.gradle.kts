import com.thomaskioko.tvmaniac.extensions.TvManiacBuildType

plugins {
  alias(libs.plugins.tvmaniac.application)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.thomaskioko.tvmaniac"

  defaultConfig {
    applicationId = "com.thomaskioko.tvmaniac"
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes { debug { applicationIdSuffix = TvManiacBuildType.DEBUG.applicationIdSuffix } }

  packaging {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
      excludes.add("/META-INF/versions/9/previous-compilation-data.bin")
    }
  }
}

dependencies {
  implementation(projects.android.designsystem)
  implementation(projects.android.ui.discover)
  implementation(projects.android.ui.library)
  implementation(projects.android.ui.moreShows)
  implementation(projects.android.ui.search)
  implementation(projects.android.ui.seasonDetails)
  implementation(projects.android.ui.settings)
  implementation(projects.android.ui.showDetails)
  implementation(projects.android.ui.trailers)
  implementation(projects.shared)
  implementation(projects.core.base)
  implementation(projects.core.util)
  implementation(projects.traktAuth.api)
  implementation(projects.traktAuth.implementation)
  implementation(projects.navigation.api)
  implementation(projects.navigation.implementation)
  implementation(projects.core.logger)
  implementation(projects.core.networkUtil)
  implementation(projects.data.cast.api)
  implementation(projects.data.cast.implementation)
  implementation(projects.data.episodes.api)
  implementation(projects.data.episodes.implementation)
  implementation(projects.data.featuredshows.api)
  implementation(projects.data.featuredshows.implementation)
  implementation(projects.data.library.api)
  implementation(projects.data.library.implementation)
  implementation(projects.data.popularshows.api)
  implementation(projects.data.popularshows.implementation)
  implementation(projects.data.recommendedshows.api)
  implementation(projects.data.recommendedshows.implementation)
  implementation(projects.data.requestManager.api)
  implementation(projects.data.requestManager.api)
  implementation(projects.data.requestManager.implementation)
  implementation(projects.data.seasondetails.api)
  implementation(projects.data.seasondetails.implementation)
  implementation(projects.data.seasons.api)
  implementation(projects.data.seasons.implementation)
  implementation(projects.data.showdetails.api)
  implementation(projects.data.showdetails.implementation)
  implementation(projects.data.shows.api)
  implementation(projects.data.shows.implementation)
  implementation(projects.data.similar.api)
  implementation(projects.data.similar.implementation)
  implementation(projects.data.topratedshows.api)
  implementation(projects.data.topratedshows.implementation)
  implementation(projects.data.trailers.api)
  implementation(projects.data.trailers.implementation)
  implementation(projects.data.trendingshows.api)
  implementation(projects.data.trendingshows.implementation)
  implementation(projects.data.upcomingshows.api)
  implementation(projects.data.upcomingshows.implementation)
  implementation(projects.data.watchproviders.api)
  implementation(projects.data.watchproviders.implementation)
  implementation(projects.database)
  implementation(projects.datastore.api)
  implementation(projects.datastore.implementation)
  implementation(projects.presentation.discover)
  implementation(projects.presentation.library)
  implementation(projects.presentation.home)
  implementation(projects.presentation.moreShows)
  implementation(projects.presentation.search)
  implementation(projects.presentation.seasondetails)
  implementation(projects.presentation.settings)
  implementation(projects.presentation.showDetails)
  implementation(projects.presentation.trailers)
  implementation(projects.tmdbApi.api)
  implementation(projects.tmdbApi.implementation)

  implementation(libs.androidx.compose.activity)
  implementation(libs.androidx.core.core)
  implementation(libs.androidx.core.splashscreen)
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.material.icons)
  implementation(libs.appauth)

  implementation(libs.decompose.decompose)
  implementation(libs.decompose.extensions.compose)
  implementation(libs.kotlinInject.runtime)
  ksp(libs.kotlinInject.compiler)

  implementation(libs.androidx.datastore.core)
  implementation(libs.androidx.savedstate)
  implementation(libs.sqldelight.runtime)
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.androidx.compose.foundation)
  implementation(libs.androidx.compose.runtime)
  implementation(libs.androidx.compose.ui.ui)
  implementation(libs.coroutines.core)
  implementation(libs.ktor.core)
}

ksp { arg("me.tatarka.inject.generateCompanionExtensions", "true") }
