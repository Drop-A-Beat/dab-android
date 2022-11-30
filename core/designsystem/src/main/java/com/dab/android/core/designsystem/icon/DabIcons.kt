package com.dab.android.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.dab.android.core.designsystem.R

object DabIcons {
    val Home = Icons.Rounded.Home
    val PlayList = R.drawable.ic_playlist
    val Search = Icons.Rounded.Search
    val Info = Icons.Rounded.Person

}
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}