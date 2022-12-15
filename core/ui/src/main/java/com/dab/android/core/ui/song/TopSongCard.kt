package com.dab.android.core.ui.song

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dab.android.core.designsystem.icon.DabIcons
import com.dab.android.core.designsystem.theme.DabTheme
import com.dab.android.core.model.Album
import com.dab.android.core.ui.album.AlbumImage

@Composable
fun TopSongCard (album: Album) {
    Card(
        shape = DabTheme.shapes.smallRoundCornerShape,
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = DabTheme.colors.surfaceVariantColor),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .width(280.dp)
            .padding(3.dp)
            .clickable(onClick = {

            })
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(3.dp),
                text = album.id.toString(),
                style = DabTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            AlbumImage(modifier = Modifier
                .size(55.dp)
                .padding(5.dp),
                imageUrl = album.imageUrl
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = album.song,
                    style = DabTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = album.artist,
                    style = DabTheme.typography.labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(
                modifier = Modifier.weight(0.3f),
                onClick = { }) {
                Icon(
                    imageVector = DabIcons.Play,
                    contentDescription = "",
                    tint = DabTheme.colors.surfaceOppositeColor
                )
            }
        }
    }
}
