package com.jmdelafuente.test.injection.modules

import android.app.Application
import android.content.Context
import dagger.Module
import javax.inject.Singleton
import dagger.Provides


@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }
}