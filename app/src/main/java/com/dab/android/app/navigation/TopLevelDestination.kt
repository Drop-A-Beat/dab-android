package com.dab.android.app.navigation

import com.dab.android.core.designsystem.icon.DabIcons.Home
import com.dab.android.core.designsystem.icon.DabIcons.Info
import com.dab.android.core.designsystem.icon.DabIcons.PlayList
import com.dab.android.core.designsystem.icon.DabIcons.Search
import com.dab.android.core.designsystem.icon.Icon


enum class TopLevelDestination(
    val icon: Icon,
    val iconTextId: String
) {
    DAB_HOME (
        icon = Icon.ImageVectorIcon(Home),
        iconTextId = "Home"
    ),
    DAB_PLAY_LIST (
        icon = Icon.DrawableResourceIcon(PlayList),
        iconTextId = "Play List"
    ),
    DAB_SEARCH (
        icon = Icon.ImageVectorIcon(Search),
        iconTextId = "Search"
    ),
    DAB_INFO (
        icon = Icon.ImageVectorIcon(Info),
        iconTextId = "Info"
    )
}