package com.example.onboardingscereen.verifyemail

import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.chaos.view.PinView
import com.example.onboardingscereen.R
import com.example.onboardingscereen.checkoutotp.OtpResponse
import com.example.onboardingscereen.network.RetrofitClient
import com.example.onboardingscereen.resendotp.ResendOtp
import com.example.onboardingscereen.signin.LoginResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CheckOtpForEmail : Fragment() {

    var buttonContinue: Button? = null
    var pinView: PinView? = null
    var pinValue: String? = null
    var textViewResend: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_verviy_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pinView = view.findViewById(R.id.firstPinView)
        buttonContinue = view.findViewById(R.id.button_Continue)
        textViewResend = view.findViewById(R.id.textView_resend)



        pinView?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(value: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pinValue = value!!.toString()

            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        buttonContinue?.setOnClickListener {
            sendEmailOtp()
        }
        textViewResend?.setOnClickListener {
            resendOtp()
        }
    }

    private fun resendOtp() {
        var sharedPreference: SharedPreferences =
            requireContext().getSharedPreferences("app_name", Context.MODE_PRIVATE)
        var email = arguments?.getString("email")
        RetrofitClient.getClient().ResendOtp(email!!, sharedPreference!!.getString("token", "")!!)
            .enqueue(object : Callback<ResendOtp> {
                override fun onResponse(call: Call<ResendOtp>, response: Response<ResendOtp>) {
                    if (response.isSuccessful) {
                        Log.i(TAG, "onResponse: " + response.body())
                    } else {
                        Log.i(TAG, "onResponse: " + response.errorBody())
                    }
                }

                override fun onFailure(call: Call<ResendOtp>, t: Throwable) {
                    Log.i(TAG, "onFailure: " + t.localizedMessage)
                }

            })

    }

    private fun sendEmailOtp() {
        val sharedPreference =
            requireContext().getSharedPreferences("app_name", Context.MODE_PRIVATE)

        RetrofitClient.getClient()
            .checkOtpEmail(pinValue!!.toInt(), sharedPreference!!.getString("token", "")!!)
            .enqueue(object : Callback<checkEmailOtpResponse> {
                override fun onResponse(
                    call: Call<checkEmailOtpResponse>,
                    response: Response<checkEmailOtpResponse>
                ) {
                    if (response.isSuccessful) {

                        Log.i(TAG, "onResponse: " + response.body().toString())
                        view?.findNavController()!!
                            .navigate(R.id.action_checkOtpForEmail_to_restPasswordFragment)
                    } else {
                        Log.i(TAG, "onResponse: " + response.errorBody())
                    }
                }

                override fun onFailure(call: Call<checkEmailOtpResponse>, t: Throwable) {
                    Log.i(TAG, "onFailure: " + t.message)
                    Log.i(TAG, "onFailure: " + t.localizedMessage)
                }

            })

    }
}


