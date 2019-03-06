package com.jmdelafuente.test

import android.app.Application
import com.jmdelafuente.test.injection.components.AppComponent
import com.jmdelafuente.test.injection.components.DaggerAppComponent
import com.jmdelafuente.test.injection.modules.AppModule

class TestApp:Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }
    fun component(): AppComponent {
        return component
    }

}