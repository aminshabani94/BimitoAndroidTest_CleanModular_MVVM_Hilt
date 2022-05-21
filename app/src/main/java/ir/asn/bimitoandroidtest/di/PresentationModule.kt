package ir.asn.bimitoandroidtest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.asn.presentation.utils.CoroutineContextProvider
import ir.asn.presentation.utils.CoroutineContextProviderImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Singleton
    @Provides
    fun provideCoroutineContextProvider(
        coroutineContextProviderImp: CoroutineContextProviderImp
    ): CoroutineContextProvider = coroutineContextProviderImp
}