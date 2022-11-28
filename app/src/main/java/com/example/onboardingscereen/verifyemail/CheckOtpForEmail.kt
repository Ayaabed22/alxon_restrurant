package com.example.onboardingscereen.verifyemail

import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.chaos.view.PinView
import com.example.onboardingscereen.R
import com.example.onboardingscereen.checkoutotp.OtpResponse
import com.example.onboardingscereen.network.RetrofitClient
import com.example.onboardingscereen.signin.LoginResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CheckOtpForEmail : Fragment() {
    var buttonContinue:Button?=null
    var pinView: PinView?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verviy_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pinView=view.findViewById(R.id.firstPinView)
        buttonContinue=view.findViewById(R.id.button_Continue)

        pinView?.setHideLineWhenFilled(false)
        pinView?.setPasswordHidden(false)
     // var otp= pinView?.setTransformationMethod(PasswordTransformationMethod())
        buttonContinue?.setOnClickListener {
            val sharedPreferences: SharedPreferences? = requireContext().getSharedPreferences("app_name",Context.MODE_PRIVATE)

                RetrofitClient.getClient().checkOtpEmail( 1234, sharedPreferences!!.getString("token","")!!).enqueue(object : Callback<checkEmailOtpResponse>{
                        override fun onResponse(
                            call: Call<checkEmailOtpResponse>,
                            response: Response<checkEmailOtpResponse>
                        ) {
                            if (response.isSuccessful) {
                                Log.i(TAG, "onResponseshared: "+sharedPreferences?.getString("token","")!!)
                                Log.i(TAG, "onResponse: "+response.body().toString())
                                view.findNavController().navigate(R.id.action_checkOtpForEmail_to_restPasswordFragment)
                            } else{
                                Log.i(TAG, "onResponse: "+response.errorBody())
                            }
                        }

                        override fun onFailure(call: Call<checkEmailOtpResponse>, t: Throwable) {
                            Log.i(TAG, "onFailure: "+t.message)
                            Log.i(TAG, "onFailure: "+t.localizedMessage)
                        }

                    })
                }
            }
        }

