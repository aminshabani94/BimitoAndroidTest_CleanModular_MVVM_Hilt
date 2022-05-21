package ir.asn.bimitoandroidtest.ui

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import ir.asn.bimitoandroidtest.BimitoTestApplication
import ir.asn.bimitoandroidtest.R
import ir.asn.bimitoandroidtest.base.MyBaseAdapter
import ir.asn.bimitoandroidtest.databinding.ItemInsuranceBinding
import ir.asn.bimitoandroidtest.extensions.applyDiscount
import ir.asn.bimitoandroidtest.extensions.roundToTwoDigitAfterDecimal
import ir.asn.bimitoandroidtest.extensions.seperateDigits
import ir.asn.domain.models.InsuranceItem
import javax.inject.Inject
import kotlin.random.Random

class InsuranceAdapter @Inject constructor(
    private val glide: RequestManager,
    private val app: BimitoTestApplication
) : MyBaseAdapter<InsuranceItem>() {

    private lateinit var context: Context

    private val diffCallback = object : DiffUtil.ItemCallback<InsuranceItem>() {
        override fun areItemsTheSame(oldItem: InsuranceItem, newItem: InsuranceItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: InsuranceItem, newItem: InsuranceItem): Boolean =
            oldItem.hashCode() == newItem.hashCode()

    }

    override val differ: AsyncListDiffer<InsuranceItem> = AsyncListDiffer(this, diffCallback)

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemInsuranceBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_insurance,
            parent,
            false
        )
        //
        context = parent.context
        //
        return InsuranceViewHolder(binding)
    }

    inner class InsuranceViewHolder(private val binding: ItemInsuranceBinding) :
        RecyclerView.ViewHolder(binding.root), Binder<InsuranceItem> {
        override fun bind(item: InsuranceItem) {
            with(binding) {
                setFonts()
                //
                glide.setDefaultRequestOptions(RequestOptions().placeholder(null))
                    .load(item.icon)
                    .into(itemImage)
                //
                itemName.text = "شرکت بیمه ی ${item.title}"
                price.text = item.prices[0].price.seperateDigits()
                price.paintFlags = price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                discountedPrice.text = item.prices[0].price.applyDiscount().seperateDigits()
                rateText.text = Random.nextDouble(4.0, 5.0).roundToTwoDigitAfterDecimal()
                numberOfCommentsText.text = context.resources.getString(
                    R.string.number_of_comments_text,
                    5,
                    Random.nextInt(200, 300)
                )
            }
        }

        private fun setFonts() {
            with(binding) {
                itemName.typeface = app.typefaceMedium
                discountText.typeface = app.typeface
                price.typeface = app.typeface
                discountedPrice.typeface = app.typefaceMedium
                priceUnitText.typeface = app.typeface
                rateText.typeface = app.typeface
                numberOfCommentsText.typeface = app.typeface
                showAndOrderTitle.typeface = app.typeface
            }
        }
    }
}