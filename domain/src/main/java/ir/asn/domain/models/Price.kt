package ir.asn.domain.models

data class Price(
    val coverAmount: Int,
    val coverID: Int,
    val discountedPrice: Int,
    val durationID: Int,
    val durationTitle: String,
    val features: List<Feature>,
    val installmentPrice: Int,
    val penaltyAmount: Int,
    val penaltyDays: Int,
    val price: Int,
    val totalPenalty: Int
)