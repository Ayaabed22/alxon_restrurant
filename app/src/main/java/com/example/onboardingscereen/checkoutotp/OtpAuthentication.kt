package com.example.onboardingscereen.checkoutotp

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.onboardingscereen.R
import com.example.onboardingscereen.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtpAuthentication : Fragment() {
    var buttonContinue: Button? = null
    var editTextOtpOne: EditText? = null
    var editTextOtpTwo: EditText? = null
    var editTextOtpThree: EditText? = null
    var editTextOtpFour: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otp_authentication, container, false)
        editTextOtpOne = view?.findViewById(R.id.editTextOtpOne)
        editTextOtpTwo = view?.findViewById(R.id.editTextOtpTwo)
        editTextOtpThree = view?.findViewById(R.id.editTextOtpThree)
        editTextOtpFour = view?.findViewById(R.id.editTextOtpFour)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonContinue = view.findViewById(R.id.button_Continue)

        buttonContinue?.setOnClickListener {

            var otpOne = editTextOtpOne?.text.toString()
            var otpTwo = editTextOtpTwo?.text.toString()
            var otpThree = editTextOtpThree?.text.toString()
            var otpFour = editTextOtpFour?.text.toString()
            var sharedPreferences = requireContext().getSharedPreferences("app name", Context.MODE_PRIVATE)

                RetrofitClient.getClient().checkOtp(1234, sharedPreferences.getString("token","")!!).enqueue(object : Callback<OtpResponse> { override fun onResponse(call: Call<OtpResponse>, response: Response<OtpResponse>) {

                        if (response.isSuccessful) {

                            view.findNavController().navigate(R.id.action_otpAuthentication_to_homeFragment)

                            Log.i(TAG, "onResponse: " + response.body())
                            Log.i(TAG, "onResponse: " + response.code())
                            Log.i(TAG, "onResponse: " + response.body()?.message)
                        }
                    }

                    override fun onFailure(call: Call<OtpResponse>, t: Throwable) {
                        Log.i(TAG, "onOtpFailure: " + t.localizedMessage)
                    }

                })
            }
        }
    }
