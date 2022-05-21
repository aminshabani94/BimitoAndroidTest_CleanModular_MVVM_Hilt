package ir.asn.remote

import ir.asn.data.models.InsuranceItemEntity
import ir.asn.data.repository.InsuranceRemote
import ir.asn.remote.api.BimitoService
import ir.asn.remote.mappers.InsuranceItemEntityMapper
import ir.asn.remote.models.InsuranceParamsEntity
import javax.inject.Inject

class InsuranceRemoteImpl @Inject constructor(
    private val bimitoService: BimitoService,
    private val insuranceItemMapper: InsuranceItemEntityMapper
) : InsuranceRemote {
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
        return bimitoService.getInsurances(
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
        ).map {
            insuranceItemMapper.mapFromModel(it)
        }
    }
}