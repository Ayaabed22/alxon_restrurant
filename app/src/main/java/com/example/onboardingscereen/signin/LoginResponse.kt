package com.example.onboardingscereen.signin

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Int? = null,
    @SerializedName("token")
    val token: String? = null,
    @SerializedName("user")
    val user: User? = null

)


data class User(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("email_verified_at")
    val emailVerifiedAt: Any? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("otp")
    val otp: String? = null,
    @SerializedName("profile")
    val profile: Profile? = null,
    @SerializedName("telephone")
    val telephone: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
)
data class Profile(
    @SerializedName("avatar")
    val avatar: String? = null,
    @SerializedName("created_at")
    val createdAt: Any? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("telephone")
    val telephone: String? = null,
    @SerializedName("updated_at")
    val updatedAt: Any? = null,
    @SerializedName("user_id")
    val userId: Int? = null
)