package com.listener.yadrophoneapp.presentation.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.listener.yadrophoneapp.domain.model.Contact
import com.listener.yadrophoneapp.domain.usecase.GetContactsListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.listener.yadrophoneapp.utils.Result

class ContactsViewModel @Inject constructor(
    private val getContactsListUseCase: GetContactsListUseCase
): ViewModel() {

    private val _contacts: MutableStateFlow<Result<List<Contact>>> = MutableStateFlow(Result.Loading())
    val contacts = _contacts.asStateFlow()

    init {
        viewModelScope.launch {
            getContactsListUseCase.execute().collect { result ->
                _contacts.value = result
            }
        }
    }
}