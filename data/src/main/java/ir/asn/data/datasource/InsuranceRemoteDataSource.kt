package ir.asn.data.datasource

import ir.asn.data.models.InsuranceItemEntity
import ir.asn.data.repository.InsuranceDataSource
import ir.asn.data.repository.InsuranceRemote
import ir.asn.domain.models.InsuranceParams
import javax.inject.Inject

class InsuranceRemoteDataSource @Inject constructor(
    private val insuranceRemote: InsuranceRemote
) : InsuranceDataSource {
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
    ): List<InsuranceItemEntity> {
        return insuranceRemote.getInsurances(
            driverDiscountID = driverDiscountID,
            installment = installment,
            marketer = marketer,
            oldCompanyID = oldCompanyID,
            oldInsureExpireDate = oldInsureExpireDate,
            oldInsureStartDate= oldInsureStartDate,
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
        )
    }
}