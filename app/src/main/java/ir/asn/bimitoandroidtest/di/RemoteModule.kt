package ir.asn.bimitoandroidtest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.asn.bimitoandroidtest.BuildConfig
import ir.asn.bimitoandroidtest.Constants
import ir.asn.data.repository.InsuranceRemote
import ir.asn.remote.InsuranceRemoteImpl
import ir.asn.remote.api.BimitoService
import ir.asn.remote.api.ServiceFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideCharacterService(): BimitoService =
        ServiceFactory.create(BuildConfig.DEBUG, Constants.BASE_URL)

    @Singleton
    @Provides
    fun provideCharacterRemote(insuranceRemoteImpl: InsuranceRemoteImpl): InsuranceRemote =
        insuranceRemoteImpl
}