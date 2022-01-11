package com.example.sunmadinepal

import android.app.Application
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import com.google.android.datatransport.runtime.dagger.Component
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import javax.inject.Named

import javax.inject.Singleton


@Module
class ContextModule {
    @Singleton
    @Provides
    @Named("AppContext")
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }





}


