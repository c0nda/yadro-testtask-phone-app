package com.listener.yadrophoneapp.data.local

import com.listener.yadrophoneapp.domain.model.Contact
import com.listener.yadrophoneapp.utils.Result
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllContactsFromDevice(): Flow<Result<List<Contact>>>
}