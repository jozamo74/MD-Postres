package com.example.mdpostres

/****
 * Project: MD Postres
 * From: com.example.mdpostres
 * Created by José Zambrano Moya on 31/8/22 at 9:54
 * More info: zambranomoya74@gmail.com
 ****/
data class Product(
    val name: String,
    val url: String,
    var isSelected: Boolean = false
    )
