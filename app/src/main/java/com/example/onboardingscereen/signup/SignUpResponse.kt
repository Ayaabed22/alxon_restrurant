package com.example.onboardingscereen.signup


import com.google.gson.annotations.SerializedName

data class SignUpResponse(

    @SerializedName("errors")
    val errors: Errors? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Int? = null,
    val token:String? = null
)

data class Errors(
    @SerializedName("email")
    val email: List<String?>? = null,
    @SerializedName("telephone")
    val telephone: List<String?>? = null
)