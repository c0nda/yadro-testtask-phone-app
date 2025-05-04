package com.listener.yadrophoneapp.domain.usecase

import com.listener.yadrophoneapp.domain.repository.ContactsRepository
import javax.inject.Inject

class GetContactsListUseCase @Inject constructor(private val contactsRepository: ContactsRepository) {

    fun execute() = contactsRepository.getAllContacts()
}