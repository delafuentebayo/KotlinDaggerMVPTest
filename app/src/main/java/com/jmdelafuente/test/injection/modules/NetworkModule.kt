package com.jmdelafuente.test.injection.modules
import com.jmdelafuente.test.network.NetworkController
import com.jmdelafuente.test.interfaces.INetwork
import dagger.Module
import javax.inject.Singleton
import dagger.Provides


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideNetwork(): INetwork {
        return NetworkController()
    }

}