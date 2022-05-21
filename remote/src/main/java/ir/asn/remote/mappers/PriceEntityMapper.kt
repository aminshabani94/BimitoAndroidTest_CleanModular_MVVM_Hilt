package ir.asn.remote.mappers

import ir.asn.data.models.PriceEntity
import ir.asn.remote.models.PriceModel
import javax.inject.Inject

class PriceEntityMapper @Inject constructor(
    private val featureEntityMapper: FeatureEntityMapper
) : EntityMapper<PriceModel, PriceEntity> {
    override fun mapFromModel(model: PriceModel): PriceEntity {
        return PriceEntity(
            coverAmount = model.coverAmount,
            coverID = model.coverID,
            discountedPrice = model.discountedPrice,
            durationID = model.durationID,
            durationTitle = model.durationTitle,
            features = model.features.map { featureEntityMapper.mapFromModel(it) },
            installmentPrice = model.installmentPrice,
            penaltyAmount = model.penaltyAmount,
            penaltyDays = model.penaltyDays,
            price = model.price,
            totalPenalty = model.totalPenalty
        )
    }
}