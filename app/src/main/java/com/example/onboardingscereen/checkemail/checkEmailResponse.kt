package com.example.onboardingscereen.checkemail


import com.google.gson.annotations.SerializedName

data class checkEmailResponse(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Int? = null
)