package com.beclocked.paco.di.module

import android.support.v7.app.AppCompatActivity
import com.jmdelafuente.test.injection.scope.PerActivity
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private var activity: AppCompatActivity) {

    @Provides
    @PerActivity
    fun provideActivity(): AppCompatActivity {
        return activity
    }
}