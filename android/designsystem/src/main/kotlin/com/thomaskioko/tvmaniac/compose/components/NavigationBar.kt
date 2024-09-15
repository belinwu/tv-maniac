package com.thomaskioko.tvmaniac.compose.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thomaskioko.tvmaniac.compose.theme.TvManiacTheme
import com.thomaskioko.tvmaniac.resources.R

@Composable
fun TvManiacNavigationBar(
  modifier: Modifier = Modifier,
  content: @Composable RowScope.() -> Unit,
) {
  NavigationBar(
    modifier = modifier,
    containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    contentColor = NavigationDefaultColors.navigationContentColor(),
    tonalElevation = 8.dp,
    content = content,
  )
}

@Composable
fun RowScope.TvManiacBottomNavigationItem(
  imageVector: ImageVector,
  title: String,
  selected: Boolean,
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
) {
  NavigationBarItem(
    modifier = modifier,
    icon = {
      Icon(
        imageVector = imageVector,
        contentDescription = title,
      )
    },
    label = { Text(title) },
    selected = selected,
    alwaysShowLabel = true,
    colors =
      NavigationBarItemDefaults.colors(
        selectedIconColor = NavigationDefaultColors.navigationSelectedItemColor(),
        unselectedIconColor = NavigationDefaultColors.navigationContentColor(),
        selectedTextColor = NavigationDefaultColors.navigationSelectedItemColor(),
        unselectedTextColor = NavigationDefaultColors.navigationContentColor(),
        indicatorColor = Color.Transparent,
      ),
    onClick = onClick,
  )
}

object NavigationDefaultColors {
  @Composable fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

  @Composable fun navigationSelectedItemColor() = MaterialTheme.colorScheme.secondary
}

@ThemePreviews
@Composable
private fun TvManiacTvManiacNavigationBarPreviewPreview() {
  TvManiacTheme {
    Surface {
      TvManiacNavigationBar  {
        TvManiacBottomNavigationItem(
          imageVector = Icons.Outlined.Movie,
          title = stringResource(id = R.string.menu_item_discover),
          selected = true,
          onClick = {  },
        )

        TvManiacBottomNavigationItem(
          imageVector = Icons.Outlined.Search,
          title = stringResource(id = R.string.menu_item_search),
          selected = false,
          onClick = {  },
        )

        TvManiacBottomNavigationItem(
          imageVector = Icons.Outlined.VideoLibrary,
          title = stringResource(id = R.string.menu_item_library),
           selected = false,
          onClick = {  },
        )

        TvManiacBottomNavigationItem(
          imageVector = Icons.Outlined.Settings,
          title = stringResource(id = R.string.menu_item_settings),
           selected = false,
          onClick = {  },
        )
      }
    }
  }
}
