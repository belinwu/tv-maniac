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
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}

rootProject.name = "tv-maniac"

include(
  ":android:app",
  ":android:designsystem",
  ":android:feature:discover",
  ":android:feature:library",
  ":android:feature:more-shows",
  ":android:feature:search",
  ":android:feature:season-details",
  ":android:feature:settings",
  ":android:feature:show-details",
  ":android:feature:trailers",
  ":android:resources",
  ":core:database",
  ":core:datastore:api",
  ":core:datastore:implementation",
  ":core:datastore:testing",
  ":core:base",
  ":core:logger",
  ":core:tmdb-api:api",
  ":core:tmdb-api:implementation",
  ":core:trakt-api:api",
  ":core:trakt-api:implementation",
  ":core:trakt-auth:api",
  ":core:trakt-auth:implementation",
  ":core:trakt-auth:testing",
  ":core:util",
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
  ":navigation",
  ":presentation:discover",
  ":presentation:library",
  ":presentation:more-shows",
  ":presentation:search",
  ":presentation:seasondetails",
  ":presentation:settings",
  ":presentation:show-details",
  ":presentation:trailers",
  ":shared",
)
