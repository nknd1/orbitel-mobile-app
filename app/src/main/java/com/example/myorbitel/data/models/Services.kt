package com.example.myorbitel.data.models

import com.google.gson.annotations.SerializedName

data class Services(
    @SerializedName("service_id")
    val service_id: Int,
    @SerializedName("feature")
    val feature: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("service_name")
    val service_name: String,
)
