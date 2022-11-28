package com.example.onboardingscereen.verifyemail


import com.google.gson.annotations.SerializedName

data class checkEmailOtpResponse(
    @SerializedName("message")
    val message: String? = null,

    @SerializedName("status")
    val status: Int? = null

)