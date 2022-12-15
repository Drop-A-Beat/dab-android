package com.dab.android.app.navigation

import com.dab.android.core.designsystem.icon.DabIcon
import com.dab.android.core.designsystem.icon.DabIcons.Home
import com.dab.android.core.designsystem.icon.DabIcons.Info
import com.dab.android.core.designsystem.icon.DabIcons.PlayList
import com.dab.android.core.designsystem.icon.DabIcons.Search


enum class TopLevelDestination(
    val icon: DabIcon,
    val iconTextId: String
) {
    DAB_HOME (
        icon = DabIcon.ImageVectorIcon(Home),
        iconTextId = "Home"
    ),
    DAB_PLAY_LIST (
        icon = DabIcon.DrawableResourceIcon(PlayList),
        iconTextId = "Play List"
    ),
    DAB_SEARCH (
        icon = DabIcon.ImageVectorIcon(Search),
        iconTextId = "Search"
    ),
    DAB_INFO (
        icon = DabIcon.ImageVectorIcon(Info),
        iconTextId = "Info"
    )
}