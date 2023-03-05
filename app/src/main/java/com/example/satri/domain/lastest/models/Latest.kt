package com.example.satri.domain.lastest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Latest(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
) : Parcelable