package com.example.mdpostres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/****
 * Project: MD Postres
 * From: com.example.mdpostres
 * Created by José Zambrano Moya on 31/8/22 at 9:54
 * More info: zambranomoya74@gmail.com
 ****/

@Parcelize
data class Product(
    val name: String,
    val url: String,
    val price: Float,
    var isSelected: Boolean = false
    ): Parcelable
