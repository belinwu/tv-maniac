enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
  includeBuild("tooling")

  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}

dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "tv-maniac"

include(
  ":android:app",
  ":android:designsystem",
  ":android:ui:discover",
  ":android:ui:library",
  ":android:ui:more-shows",
  ":android:screenshot-tests",
  ":android:ui:search",
  ":android:ui:season-details",
  ":android:ui:settings",
  ":android:ui:show-details",
  ":android:ui:trailers",
  ":android:resources",
  ":core:base",
  ":core:logger",
  ":core:network-util",
  ":core:paging",
  ":core:util",
  ":database",
  ":database:test",
  ":datastore:api",
  ":datastore:implementation",
  ":datastore:testing",
  ":data:cast:api",
  ":data:cast:implementation",
  ":data:cast:testing",
  ":data:episodes:api",
  ":data:episodes:implementation",
  ":data:episodes:testing",
  ":data:featuredshows:api",
  ":data:featuredshows:implementation",
  ":data:featuredshows:testing",
  ":data:library:api",
  ":data:library:implementation",
  ":data:library:testing",
  ":data:popularshows:api",
  ":data:popularshows:implementation",
  ":data:popularshows:testing",
  ":data:request-manager:api",
  ":data:request-manager:implementation",
  ":data:recommendedshows:api",
  ":data:recommendedshows:implementation",
  ":data:recommendedshows:testing",
  ":data:seasondetails:api",
  ":data:seasondetails:implementation",
  ":data:seasondetails:testing",
  ":data:seasons:api",
  ":data:seasons:implementation",
  ":data:seasons:testing",
  ":data:shows:api",
  ":data:shows:implementation",
  ":data:showdetails:api",
  ":data:showdetails:implementation",
  ":data:showdetails:testing",
  ":data:similar:api",
  ":data:similar:implementation",
  ":data:similar:testing",
  ":data:trendingshows:api",
  ":data:trendingshows:implementation",
  ":data:trendingshows:testing",
  ":data:topratedshows:api",
  ":data:topratedshows:implementation",
  ":data:topratedshows:testing",
  ":data:trailers:api",
  ":data:trailers:implementation",
  ":data:trailers:testing",
  ":data:upcomingshows:api",
  ":data:upcomingshows:implementation",
  ":data:upcomingshows:testing",
  ":data:watchproviders:api",
  ":data:watchproviders:implementation",
  ":data:watchproviders:testing",
  ":navigation:api",
  ":navigation:implementation",
  ":presentation:discover",
  ":presentation:home",
  ":presentation:library",
  ":presentation:more-shows",
  ":presentation:search",
  ":presentation:seasondetails",
  ":presentation:settings",
  ":presentation:show-details",
  ":presentation:trailers",
  ":shared",
  ":tmdb-api:api",
  ":tmdb-api:implementation",
  ":trakt-api:api",
  ":trakt-api:implementation",
  ":trakt-auth:api",
  ":trakt-auth:implementation",
  ":trakt-auth:testing",
)
