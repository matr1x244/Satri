package com.example.satri.domain.sale.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlashSale(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
): Parcelable