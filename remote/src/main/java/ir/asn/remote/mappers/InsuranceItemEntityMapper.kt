package ir.asn.remote.mappers

import ir.asn.data.models.InsuranceItemEntity
import ir.asn.remote.models.InsuranceItemModel
import javax.inject.Inject

class InsuranceItemEntityMapper @Inject constructor(
    private val priceEntityMapper: PriceEntityMapper
) : EntityMapper<InsuranceItemModel, InsuranceItemEntity> {
    override fun mapFromModel(model: InsuranceItemModel): InsuranceItemEntity {
        return InsuranceItemEntity(
            title = model.title,
            icon = model.icon,
            description = model.description,
            branchNumber = model.branchNumber,
            complaintResponseTime = model.complaintResponseTime,
            discountTitle = model.discountTitle,
            giftTitle = model.giftTitle,
            hasGift = model.hasGift,
            id = model.id,
            installments = model.installments,
            prices = model.prices.map { priceEntityMapper.mapFromModel(it) },
            satisfaction = model.satisfaction,
            wealthLevel = model.wealthLevel
        )
    }
}