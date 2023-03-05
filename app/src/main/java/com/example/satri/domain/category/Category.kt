package com.example.satri.domain.category

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class Category(
    val idCategory: Int,
    val imageCategory: Int,
    val nameCategory: String,
) : Parcelable