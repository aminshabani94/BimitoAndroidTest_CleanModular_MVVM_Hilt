package ir.asn.domain.usecases

import ir.asn.domain.models.InsuranceItem
import ir.asn.domain.models.InsuranceParams
import ir.asn.domain.repository.InsuranceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetInsuranceListUseCase @Inject constructor(
    private val insuranceRepository: InsuranceRepository
) : BaseUseCase<InsuranceParams, Flow<List<InsuranceItem>>> {
    override suspend fun invoke(params: InsuranceParams): Flow<List<InsuranceItem>> =
        insuranceRepository.getInsurances(
            marketer = params.marketer,
            driverDiscountID = params.driverDiscountID,
            installment = params.installment,
            oldCompanyID = params.oldCompanyID,
            oldInsureExpireDate = params.oldInsureExpireDate,
            oldInsureStartDate = params.oldInsureStartDate,
            oldInsureUsed = params.oldInsureUsed,
            sanhabInquiryID = params.sanhabInquiryID,
            thirdDiscountID = params.thirdDiscountID,
            vehicleBrandID = params.vehicleBrandID,
            vehicleChangedOwner = params.vehicleChangedOwner,
            vehicleColorTitle = params.vehicleColorTitle,
            vehicleConstructionYear = params.vehicleConstructionYear,
            vehicleModelID = params.vehicleModelID,
            vehicleTypeID = params.vehicleTypeID,
            vehicleUsageID = params.vehicleUsageID,
            withoutInsure = params.withoutInsure,
            zeroKilometer = params.zeroKilometer
        )
}