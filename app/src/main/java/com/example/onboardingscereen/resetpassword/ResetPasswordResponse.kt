package com.example.onboardingscereen.resetpassword


import com.google.gson.annotations.SerializedName

data class ResetPasswordResponse(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Int? = null,

)