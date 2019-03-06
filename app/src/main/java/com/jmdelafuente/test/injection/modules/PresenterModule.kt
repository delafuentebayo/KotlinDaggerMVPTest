package com.beclocked.paco.di.module


import com.jmdelafuente.test.injection.scope.PerActivity
import com.jmdelafuente.test.ui.MainContract
import com.jmdelafuente.test.ui.MainPresenter
import dagger.Module
import dagger.Provides


@Module
class PresenterModule {

    @Provides
    @PerActivity
    internal fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter {
        return presenter
    }
}