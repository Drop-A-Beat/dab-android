package com.dab.android.core.ui.album

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dab.android.core.designsystem.theme.DabTheme
import com.dab.android.core.model.Album
import com.dab.android.core.ui.R

@Composable
fun AlbumCard(album: Album) {
    Column( modifier =
    Modifier
        .padding(8.dp)
        .width(120.dp)
        .clickable(
            onClick = {

            })
    ) {
        AlbumImage(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp),
            album.imageUrl
        )
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


@Composable
internal fun AlbumImage(modifier: Modifier, imageUrl: String) {
    Card(modifier = modifier) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            placeholder = painterResource(id = R.drawable.ic_playlist),
            contentScale = ContentScale.Crop,
            model = imageUrl,
            contentDescription = null
        )
    }

}

@Preview
@Composable
private fun PreviewAlbumCard() {
    val album = remember {
            Album (
                id = 1,
                genre = "",
                artist = "Taylor Swift",
                song = "Anti-Hero",
                descriptions = "",
                imageUrl = "https://charts-static.billboard.com/img/2022/10/taylor-swift-824-antihero-fgo-180x180.jpg"
            )
    }
    AlbumCard(album)
}
