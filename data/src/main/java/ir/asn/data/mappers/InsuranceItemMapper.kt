package ir.asn.data.mappers

import ir.asn.data.models.InsuranceItemEntity
import ir.asn.domain.models.InsuranceItem
import javax.inject.Inject

class InsuranceItemMapper @Inject constructor(
    private val priceMapper: PriceMapper
) : Mapper<InsuranceItemEntity, InsuranceItem> {
    override fun mapFromEntity(type: InsuranceItemEntity): InsuranceItem {
        return InsuranceItem(
            title = type.title,
            icon = type.icon,
            description = type.description,
            branchNumber = type.branchNumber,
            complaintResponseTime = type.complaintResponseTime,
            discountTitle = type.discountTitle,
            giftTitle = type.giftTitle,
            hasGift = type.hasGift,
            id = type.id,
            installments = type.installments,
            prices = type.prices.map { priceMapper.mapFromEntity(it) },
            satisfaction = type.satisfaction,
            wealthLevel = type.wealthLevel
        )
    }

    override fun mapToEntity(type: InsuranceItem): InsuranceItemEntity {
        return InsuranceItemEntity(
            title = type.title,
            icon = type.icon,
            description = type.description,
            branchNumber = type.branchNumber,
            complaintResponseTime = type.complaintResponseTime,
            discountTitle = type.discountTitle,
            giftTitle = type.giftTitle,
            hasGift = type.hasGift,
            id = type.id,
            installments = type.installments,
            prices = type.prices.map { priceMapper.mapToEntity(it) },
            satisfaction = type.satisfaction,
            wealthLevel = type.wealthLevel
        )
    }
}