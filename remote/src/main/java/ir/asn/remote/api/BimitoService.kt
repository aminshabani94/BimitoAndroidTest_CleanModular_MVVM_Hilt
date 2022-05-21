package ir.asn.remote.api

import ir.asn.remote.models.InsuranceItemModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BimitoService {

    @Headers("deviceID: 2")
    @GET("product/third/prices")
    suspend fun getInsurances(
        @Query("marketer") marketer: Boolean,
        @Query("vehicleConstructionYear") vehicleConstructionYear: Int,
        @Query("vehicleColorTitle") vehicleColorTitle: String,
        @Query("vehicleChangedOwner") vehicleChangedOwner: Int,
        @Query("vehicleTypeID") vehicleTypeID: Int,
        @Query("vehicleUsageID") vehicleUsageID: Int,
        @Query("vehicleBrandID") vehicleBrandID: Int,
        @Query("vehicleModelID") vehicleModelID: Long,
        @Query("zeroKilometer") zeroKilometer: Boolean,
        @Query("withoutInsure") withoutInsure: Boolean,
        @Query("installment") installment: Boolean,
        @Query("sanhabInquiryID") sanhabInquiryID: Int? = null,
        @Query("oldCompanyID") oldCompanyID: Int,
        @Query("thirdDiscountID") thirdDiscountID: Int,
        @Query("driverDiscountID") driverDiscountID: Int,
        @Query("oldInsureUsed") oldInsureUsed: Boolean,
        @Query("oldInsureStartDate") oldInsureStartDate: String,
        @Query("oldInsureExpireDate") oldInsureExpireDate: String,

    ): List<InsuranceItemModel>

}