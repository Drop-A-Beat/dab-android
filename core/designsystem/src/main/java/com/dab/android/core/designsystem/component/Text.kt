package com.dab.android.core.designsystem.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dab.android.core.designsystem.theme.DabTheme

@Composable
fun MainTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = DabTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold),
        modifier = Modifier
            .padding(start = 8.dp, bottom = 5.dp, top = 5.dp)
            .semantics { heading() }
            .then(modifier)
    )
}