package com.dab.android.core.ui.song

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dab.android.core.designsystem.theme.DabTheme
import com.dab.android.core.model.Album
import com.dab.android.core.ui.album.AlbumImage

@Composable
fun TopSongCard (album: Album) {
    Card(
        elevation = 0.dp,
        backgroundColor = DabTheme.colors.surfaceVariantColor,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .width(280.dp)
            .padding(3.dp)
            .clickable(onClick = {

            })
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
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
            Column {
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

        }
    }
}