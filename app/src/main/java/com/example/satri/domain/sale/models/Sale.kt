package com.example.satri.domain.sale.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sale(
    val flash_sale: List<FlashSale>
): Parcelable