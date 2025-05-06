package com.listener.yadrophoneapp.presentation.contacts.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LetterItem(
    letter: String
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.tertiary,
            thickness = 1.dp
        )
        Text(
            text = letter.toString(),
            fontWeight = FontWeight.Bold
        )
        HorizontalDivider(
            color = MaterialTheme.colorScheme.tertiary,
            thickness = 1.dp
        )
    }
}