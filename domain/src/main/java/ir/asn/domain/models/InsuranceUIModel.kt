package ir.asn.domain.models

sealed class InsuranceUIModel :UiAwareModel(){
    object Loading : InsuranceUIModel()
    data class Success(val data: List<InsuranceItem>) : InsuranceUIModel()
    data class Error(var error: String) : InsuranceUIModel()
}
