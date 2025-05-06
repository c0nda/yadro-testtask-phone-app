package com.listener.yadrophoneapp.presentation.contacts.layout

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.listener.yadrophoneapp.R
import com.listener.yadrophoneapp.domain.model.Contact
import com.listener.yadrophoneapp.presentation.contacts.ContactsViewModel
import com.listener.yadrophoneapp.utils.Result
import androidx.core.net.toUri

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ContactsListScreen(
    contactsViewModel: ContactsViewModel
) {
    val contactsState = contactsViewModel.contacts.collectAsState()
    val context = LocalContext.current

    when (contactsState.value) {
        is Result.Success -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(start = 8.dp, end = 8.dp, top = 32.dp, bottom = 8.dp)
            ) {
                val contacts = (contactsState.value as Result.Success<List<Contact>>).data.groupBy { contact ->
                    contact.displayName.first().toString().uppercase()
                }
                contacts.map { entry ->
                    stickyHeader {
                        LetterItem(entry.key)
                    }
                    items(entry.value.size) { index ->
                        ContactItem(entry.value[index]) {
                            val intent = Intent(
                                Intent.ACTION_CALL,
                                ("tel:" + entry.value[index].phoneNumber).toUri()
                            )
                            context.startActivity(intent)
                        }
                    }
                }
            }
        }

        is Result.Error -> {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.try_later)
                )
            }
        }

        is Result.Loading -> {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

