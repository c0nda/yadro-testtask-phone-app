package com.listener.yadrophoneapp.data.local.internal

import android.content.Context
import android.provider.ContactsContract
import com.listener.yadrophoneapp.data.local.LocalDataSource
import com.listener.yadrophoneapp.domain.model.Contact
import com.listener.yadrophoneapp.utils.Result
import com.listener.yadrophoneapp.utils.ResultUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class InternalStorage @Inject constructor(private val context: Context) : LocalDataSource {

    override suspend fun getAllContactsFromDevice(): Flow<Result<List<Contact>>> = ResultUtils.requestFlow {
        val contacts = mutableListOf<Contact>()

        val projection = arrayOf(
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI
        )

        val sortOrder = "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} ASC"

        val cursor = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            null,
            null,
            sortOrder
        )

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndexOrThrow(projection[0]))
                val displayName = cursor.getString(cursor.getColumnIndexOrThrow(projection[1]))
                val phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow(projection[2]))
                val photo = cursor.getString(cursor.getColumnIndexOrThrow(projection[2]))

                contacts.add(
                    Contact(
                        id = id,
                        displayName = displayName,
                        phoneNumber = phoneNumber,
                        photo = photo
                    )
                )

            } while (cursor.moveToNext())
        }

        cursor?.close()

        contacts.toList()
    }.flowOn(Dispatchers.IO)
}