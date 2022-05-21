package ir.asn.data.mappers

import ir.asn.data.models.PriceEntity
import ir.asn.domain.models.Price
import javax.inject.Inject

class PriceMapper @Inject constructor(
    private val featureMapper: FeatureMapper
) : Mapper<PriceEntity, Price> {
    override fun mapFromEntity(type: PriceEntity): Price {
        return Price(
            coverAmount = type.coverAmount,
            coverID = type.coverID,
            discountedPrice = type.discountedPrice,
            durationID = type.durationID,
            durationTitle = type.durationTitle,
            features = type.features.map { featureMapper.mapFromEntity(it) },
            installmentPrice = type.installmentPrice,
            penaltyAmount = type.penaltyAmount,
            penaltyDays = type.penaltyDays,
            price = type.price,
            totalPenalty = type.totalPenalty
        )
    }

    override fun mapToEntity(type: Price): PriceEntity {
        return PriceEntity(
            coverAmount = type.coverAmount,
            coverID = type.coverID,
            discountedPrice = type.discountedPrice,
            durationID = type.durationID,
            durationTitle = type.durationTitle,
            features = type.features.map { featureMapper.mapToEntity(it) },
            installmentPrice = type.installmentPrice,
            penaltyAmount = type.penaltyAmount,
            penaltyDays = type.penaltyDays,
            price = type.price,
            totalPenalty = type.totalPenalty
        )
    }
}