package ir.asn.bimitoandroidtest.extensions

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt

fun Int.applyDiscount(): Int {
    return (this - this * 0.1).roundToInt()
}

fun Double.roundToTwoDigitAfterDecimal(): String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.DOWN
    return df.format(this)
}

fun Int.seperateDigits(): String {
    val df = DecimalFormat("#,###")
    df.roundingMode = RoundingMode.DOWN
    return df.format(this)
}