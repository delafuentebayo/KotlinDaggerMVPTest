package com.jmdelafuente.test.injection.components
import com.beclocked.paco.di.module.ActivityModule
import com.beclocked.paco.di.module.PresenterModule
import com.jmdelafuente.test.injection.scope.PerActivity
import com.jmdelafuente.test.ui.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class, PresenterModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
   }