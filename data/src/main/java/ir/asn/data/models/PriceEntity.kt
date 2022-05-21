package ir.asn.data.models

data class PriceEntity(
    val coverAmount: Int,
    val coverID: Int,
    val discountedPrice: Int,
    val durationID: Int,
    val durationTitle: String,
    val features: List<FeatureEntity>,
    val installmentPrice: Int,
    val penaltyAmount: Int,
    val penaltyDays: Int,
    val price: Int,
    val totalPenalty: Int
)