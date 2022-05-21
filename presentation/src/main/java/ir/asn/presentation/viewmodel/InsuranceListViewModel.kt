package ir.asn.presentation.viewmodel

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.asn.domain.models.InsuranceParams
import ir.asn.domain.models.InsuranceUIModel
import ir.asn.domain.usecases.GetInsuranceListUseCase
import ir.asn.presentation.utils.CoroutineContextProvider
import ir.asn.presentation.utils.UiAwareLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class InsuranceListViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val getInsuranceListUseCase: GetInsuranceListUseCase
) : BaseViewModel(contextProvider) {

    private val _insuranceList = UiAwareLiveData<InsuranceUIModel>()
    val insuranceList: LiveData<InsuranceUIModel> = _insuranceList

    override val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            _insuranceList.postValue(InsuranceUIModel.Error(exception.message ?: "Error"))
        }

    fun getInsuranceList(params: InsuranceParams) {
        _insuranceList.postValue(InsuranceUIModel.Loading)
        launchCoroutineIO {
            loadInsuranceList(params)
        }
    }

    private suspend fun loadInsuranceList(params: InsuranceParams) {
        getInsuranceListUseCase(params).collect {
            _insuranceList.postValue(InsuranceUIModel.Success(it))
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}