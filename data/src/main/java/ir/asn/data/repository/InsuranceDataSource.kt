package ir.asn.data.repository

import ir.asn.data.models.InsuranceItemEntity
import ir.asn.domain.models.InsuranceItem
import ir.asn.domain.models.InsuranceParams
import kotlinx.coroutines.flow.Flow

interface InsuranceDataSource {
    // Remote
    suspend fun getInsurances(
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
    ): List<InsuranceItemEntity>
}