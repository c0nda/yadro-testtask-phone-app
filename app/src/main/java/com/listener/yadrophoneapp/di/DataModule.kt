package com.listener.yadrophoneapp.di

import com.listener.yadrophoneapp.data.local.LocalDataSource
import com.listener.yadrophoneapp.data.local.internal.InternalStorage
import com.listener.yadrophoneapp.data.repository.ContactsRepositoryImpl
import com.listener.yadrophoneapp.domain.repository.ContactsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindLocalDataSource(internalStorage: InternalStorage): LocalDataSource

    @Binds
    abstract fun bindContactsRepository(contactsRepositoryImpl: ContactsRepositoryImpl): ContactsRepository
}