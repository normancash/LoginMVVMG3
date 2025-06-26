package com.uam.incrementovm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class User(val apellido: String,
                val email: String,
                val id: Int,
                val nombre: String) : Parcelable
