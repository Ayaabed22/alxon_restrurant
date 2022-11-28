package com.example.onboardingscereen.network

import com.example.onboardingscereen.checkemail.checkEmailResponse
import com.example.onboardingscereen.checkoutotp.OtpResponse
import com.example.onboardingscereen.resendotp.ResendOtp
import com.example.onboardingscereen.resetpassword.ResetPasswordResponse
import com.example.onboardingscereen.signin.LoginRequest
import com.example.onboardingscereen.signin.LoginResponse
import com.example.onboardingscereen.signup.SignUpResponse
import com.example.onboardingscereen.verifyemail.checkEmailOtpResponse
import retrofit2.Call
import retrofit2.http.*

interface ServicesBuilder {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    fun signUp(@Field ("email")email:String,
               @Field ("password")password:String,
               @Field ("name")name:String,
               @Field ("telephone")telephone:String,
               @Field("confirm_password")confirmPassword:String): Call<SignUpResponse>

    @FormUrlEncoded
    @POST("check-otp")
    fun checkOtp(@Field("otp") otp: Int, @Header ("Authorization") token:String):Call<OtpResponse>

    @FormUrlEncoded
    @POST("check-email")
    fun checkEmail(@Field("email") email :String):Call<checkEmailResponse>

    @FormUrlEncoded
    @POST("check-otp-for-email")
    fun checkOtpEmail(@Field("otp") otp: Int, @Header ("Authorization") token:String ) :Call<checkEmailOtpResponse>

    @FormUrlEncoded
    @POST("reset-password")
    fun resetPassword(@Field("password") password:String,
                      @Field("password_confirmation")newPassword:String,@Header ("Authorization") token:String ) :Call<OtpResponse>

    @FormUrlEncoded
    @POST("resend-otp")
    fun ResendOtp(@Field("email") email: String ,@Header ("Authorization") token: String):Call<ResendOtp>
}
