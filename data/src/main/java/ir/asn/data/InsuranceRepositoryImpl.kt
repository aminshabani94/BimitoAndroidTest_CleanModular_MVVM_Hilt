package ir.asn.data

import ir.asn.data.datasource.InsuranceRemoteDataSource
import ir.asn.data.mappers.InsuranceItemMapper
import ir.asn.domain.models.InsuranceItem
import ir.asn.domain.models.InsuranceParams
import ir.asn.domain.repository.InsuranceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsuranceRepositoryImpl @Inject constructor(
    private val insuranceRemoteDataSource: InsuranceRemoteDataSource,
    private val insuranceItemMapper: InsuranceItemMapper
) : InsuranceRepository {
    override suspend fun getInsurances(
        driverDiscountID: Int,
        installment: Boolean,
        marketer: Boolean,
        oldCompanyID: Int,
        oldInsureExpireDate: String,
        oldInsureStartDate: String,
        oldInsureUsed: Boolean,
        sanhabInquiryID: Int?,
        thirdDiscountID: Int,
        vehicleBrandID: Int,
        vehicleChangedOwner: Int,
        vehicleColorTitle: String,
        vehicleConstructionYear: Int,
        vehicleModelID: Long,
        vehicleTypeID: Int,
        vehicleUsageID: Int,
        withoutInsure: Boolean,
        zeroKilometer: Boolean
    ): Flow<List<InsuranceItem>> = flow {
        val insuranceList =
            insuranceRemoteDataSource.getInsurances(
                driverDiscountID = driverDiscountID,
                installment = installment,
                marketer = marketer,
                oldCompanyID = oldCompanyID,
                oldInsureExpireDate = oldInsureExpireDate,
                oldInsureStartDate = oldInsureStartDate,
                oldInsureUsed = oldInsureUsed,
                sanhabInquiryID = sanhabInquiryID,
                thirdDiscountID = thirdDiscountID,
                vehicleBrandID = vehicleBrandID,
                vehicleChangedOwner = vehicleChangedOwner,
                vehicleColorTitle = vehicleColorTitle,
                vehicleConstructionYear = vehicleConstructionYear,
                vehicleModelID = vehicleModelID,
                vehicleTypeID = vehicleTypeID,
                vehicleUsageID = vehicleUsageID,
                withoutInsure = withoutInsure,
                zeroKilometer = zeroKilometer
            ).map { insuranceItemEntity ->
                insuranceItemMapper.mapFromEntity(insuranceItemEntity)
            }
        emit(insuranceList)
    }
}