package com.listener.yadrophoneapp

import android.app.Application
import com.listener.yadrophoneapp.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        DI.appComponent = DaggerAppComponent
            .builder()
            .appContext(this)
            .build()
    }
}