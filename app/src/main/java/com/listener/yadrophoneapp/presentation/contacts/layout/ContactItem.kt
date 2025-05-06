package com.listener.yadrophoneapp.presentation.contacts.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.listener.yadrophoneapp.domain.model.Contact
import androidx.core.net.toUri

@Composable
fun ContactItem(
    contact: Contact,
    modifier: Modifier = Modifier,
    onClickContact: () -> Unit
) {
    Card(
        onClick = onClickContact,
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(
                    data = contact.photo.toUri()
                ),
                modifier = modifier
                    .size(50.dp)
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(percent = 50)),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = contact.displayName,
                )
                Text(
                    text = contact.phoneNumber
                )
            }
        }
    }
}