package com.example.onboardingscereen.checkoutotp


import com.google.gson.annotations.SerializedName

data class OtpResponse(
    @SerializedName("message")
    val message: String?=null,
    @SerializedName("status")
    val status: Int?=null
)