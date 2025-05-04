package com.listener.yadrophoneapp.domain.repository

import com.listener.yadrophoneapp.domain.model.Contact
import com.listener.yadrophoneapp.utils.Result
import kotlinx.coroutines.flow.Flow

interface ContactsRepository {

    fun getAllContacts(): Flow<Result<List<Contact>>>
}