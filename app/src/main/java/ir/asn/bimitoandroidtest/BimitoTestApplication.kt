package ir.asn.bimitoandroidtest

import android.app.Application
import android.graphics.Typeface
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BimitoTestApplication : Application() {
    lateinit var typeface: Typeface
    lateinit var typefaceLight: Typeface
    lateinit var typefaceBold: Typeface
    lateinit var typefaceMedium: Typeface

    override fun onCreate() {
        super.onCreate()
        //
        initFonts()
    }

    private fun initFonts() {
        typeface = Typeface.createFromAsset(assets, "fonts/IRANSansMobile(FaNum).ttf")
        typefaceLight = Typeface.createFromAsset(assets, "fonts/IRANSansMobile(FaNum)_Light.ttf")
        typefaceBold = Typeface.createFromAsset(assets, "fonts/IRANSansMobile(FaNum)_Bold.ttf")
        typefaceMedium = Typeface.createFromAsset(assets, "fonts/IRANSansMobile(FaNum)_Medium.ttf")
    }

}