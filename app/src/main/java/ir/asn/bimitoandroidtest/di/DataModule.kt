package ir.asn.bimitoandroidtest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.asn.data.InsuranceRepositoryImpl
import ir.asn.domain.repository.InsuranceRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideInsuranceRepository(
        insuranceRepositoryImpl: InsuranceRepositoryImpl
    ): InsuranceRepository = insuranceRepositoryImpl

}