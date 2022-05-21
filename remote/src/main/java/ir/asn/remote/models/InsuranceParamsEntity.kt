package ir.asn.remote.models

data class InsuranceParamsEntity(
    val driverDiscountID: Int,
    val installment: Boolean,
    val marketer: Boolean,
    val oldCompanyID: Int,
    val oldInsureExpireDate: String,
    val oldInsureStartDate: String,
    val oldInsureUsed: Boolean,
    val sanhabInquiryID: Int?,
    val thirdDiscountID: Int,
    val vehicleBrandID: Int,
    val vehicleChangedOwner: Int,
    val vehicleColorTitle: String,
    val vehicleConstructionYear: Int,
    val vehicleModelID: Long,
    val vehicleTypeID: Int,
    val vehicleUsageID: Int,
    val withoutInsure: Boolean,
    val zeroKilometer: Boolean
)