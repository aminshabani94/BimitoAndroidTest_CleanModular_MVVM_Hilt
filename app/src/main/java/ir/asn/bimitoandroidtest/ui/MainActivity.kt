package ir.asn.bimitoandroidtest.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ir.asn.bimitoandroidtest.BimitoTestApplication
import ir.asn.bimitoandroidtest.R
import ir.asn.bimitoandroidtest.databinding.ActivityMainBinding
import ir.asn.bimitoandroidtest.extensions.observe
import ir.asn.domain.models.InsuranceParams
import ir.asn.domain.models.InsuranceUIModel
import ir.asn.presentation.viewmodel.InsuranceListViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var insuranceAdapter: InsuranceAdapter

    private val viewModel: InsuranceListViewModel by viewModels()
    private lateinit var application: BimitoTestApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //
        application = applicationContext as BimitoTestApplication
        //
        setFonts()
        getInsurances()
    }

    private fun setFonts() {
        with(binding) {
            toolbarLayout.toolbarTitle.typeface = application.typefaceBold
            toolbarLayout.discountCodeTitle.typeface = application.typeface
            filtersTitle.typeface = application.typeface
            sortTitle.typeface = application.typeface
            coverTitle.typeface = application.typeface
        }
    }

    private fun getInsurances() {
        val params = InsuranceParams(
            6, false,
            false, 7,
            "2021-05-20", "2020-07-03",
            false, null,
            6, 84,
            0, "red",
            1399, 806662,
            6, 1,
            false, false,
        )
        viewModel.getInsuranceList(params)
        observe(viewModel.insuranceList, ::onViewStateChange)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = insuranceAdapter
            layoutManager = GridLayoutManager(
                this@MainActivity,
                1,
                RecyclerView.VERTICAL,
                false
            )
            isFocusable = false
            isNestedScrollingEnabled = false
        }

        insuranceAdapter.setItemClickListener { character ->

        }
    }

    private fun onViewStateChange(event: InsuranceUIModel) {
        if (event.isRedelivered) return
        when (event) {
            is InsuranceUIModel.Loading -> {
                handleLoading(true)
            }
            is InsuranceUIModel.Success -> {
                handleLoading(false)
                insuranceAdapter.list = event.data
            }
            is InsuranceUIModel.Error -> {
                Toast.makeText(this, event.error, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun handleLoading(isLoading: Boolean) {
        with(binding) {
            if (isLoading) {
                progressbar.visibility = View.VISIBLE
                mainLayout.visibility = View.GONE
            } else {
                progressbar.visibility = View.GONE
                mainLayout.visibility = View.VISIBLE
            }
        }
    }
}