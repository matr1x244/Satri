package com.example.satri.domain.lastest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LatestAll (val latest: List<Latest>): Parcelable
