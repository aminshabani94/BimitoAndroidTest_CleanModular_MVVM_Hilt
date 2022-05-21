package ir.asn.remote.models

data class InsuranceItemModel(
    val branchNumber: Int,
    val complaintResponseTime: Double,
    val description: String,
    val discountTitle: String,
    val giftTitle: String,
    val hasGift: Boolean,
    val icon: String,
    val id: Int,
    val installments: List<Any>,
    val prices: List<PriceModel>,
    val satisfaction: Double,
    val title: String,
    val wealthLevel: Double
)