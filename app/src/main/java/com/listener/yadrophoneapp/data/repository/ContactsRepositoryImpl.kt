package com.listener.yadrophoneapp.data.repository

import com.listener.yadrophoneapp.data.local.LocalDataSource
import com.listener.yadrophoneapp.domain.model.Contact
import com.listener.yadrophoneapp.domain.repository.ContactsRepository
import com.listener.yadrophoneapp.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContactsRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : ContactsRepository {

    override suspend fun getAllContacts(): Flow<Result<List<Contact>>> {
        return localDataSource.getAllContactsFromDevice()
    }
}