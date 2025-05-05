package com.listener.yadrophoneapp.di

import androidx.lifecycle.ViewModel
import com.listener.yadrophoneapp.di.viewmodel.ViewModelKey
import com.listener.yadrophoneapp.presentation.contacts.ContactsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactsViewModel::class)
    abstract fun bindContactsViewModel(viewModel: ContactsViewModel): ViewModel
}