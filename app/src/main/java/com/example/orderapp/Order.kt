package com.example.orderapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Order(val dish: String, val client: String) : Parcelable