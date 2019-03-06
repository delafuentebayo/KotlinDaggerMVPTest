package com.jmdelafuente.test.injection.components

import android.content.Context
import com.jmdelafuente.test.injection.modules.AppModule
import com.jmdelafuente.test.injection.modules.NetworkModule
import com.jmdelafuente.test.interfaces.INetwork
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun networkController(): INetwork

    fun context(): Context

}