package com.listener.yadrophoneapp.di

import com.listener.yadrophoneapp.domain.repository.ContactsRepository
import com.listener.yadrophoneapp.domain.usecase.GetContactsListUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetContactsListUseCase(contactsRepository: ContactsRepository) =
        GetContactsListUseCase(contactsRepository)
}