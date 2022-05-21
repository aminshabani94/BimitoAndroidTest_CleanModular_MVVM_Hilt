package ir.asn.remote.models

data class PriceModel(
    val coverAmount: Int,
    val coverID: Int,
    val discountedPrice: Int,
    val durationID: Int,
    val durationTitle: String,
    val features: List<FeatureModel>,
    val installmentPrice: Int,
    val penaltyAmount: Int,
    val penaltyDays: Int,
    val price: Int,
    val totalPenalty: Int
)