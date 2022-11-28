package com.example.onboardingscereen.resendotp


import com.google.gson.annotations.SerializedName

data class ResendOtp(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Int? = null
)