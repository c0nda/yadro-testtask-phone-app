package com.listener.yadrophoneapp.di

import android.content.Context
import com.listener.yadrophoneapp.di.viewmodel.BaseViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DataModule::class,
        UseCaseModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface AppComponent {

    fun viewModelFactory(): BaseViewModelFactory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun appContext(context: Context): Builder

        fun build(): AppComponent
    }
}