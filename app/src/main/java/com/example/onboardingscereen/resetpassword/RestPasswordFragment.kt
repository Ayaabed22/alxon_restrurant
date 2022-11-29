package com.example.onboardingscereen.resetpassword

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.onboardingscereen.R
import com.example.onboardingscereen.checkoutotp.OtpResponse
import com.example.onboardingscereen.network.RetrofitClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestPasswordFragment : Fragment() {
    var buttonSave: Button? = null
    var editTextPassword: EditText? = null
    var editTextNewPassword: EditText? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rest_password, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSave = view.findViewById(R.id.buttonSave)
        editTextPassword = view.findViewById(R.id.edittext_password)
        editTextNewPassword = view.findViewById(R.id.edittext_NewPassword)


        var sharedPreferences =
            requireContext().getSharedPreferences("app_name", Context.MODE_PRIVATE)


        buttonSave?.setOnClickListener {

            var password = editTextPassword?.text.toString().trim()
            var newPassword = editTextNewPassword?.text.toString()

            RetrofitClient.getClient()
                .resetPassword(password, newPassword, sharedPreferences.getString("token", "")!!)

                .enqueue(object : Callback<OtpResponse> {
                    override fun onResponse(
                        call: Call<OtpResponse>,
                        response: Response<OtpResponse>
                    ) {
                        if (response.isSuccessful) {
                            Log.i(TAG, "onResponse: " + response.body()!!.message)
                            Log.i(TAG, "onResponseresetPassword: " + response.body().toString())
                            view.findNavController()
                                .navigate(R.id.action_restPasswordFragment_to_signinFragment)

                        } else {
                            Log.i(TAG, "onResponsepassword: " + response.errorBody())

                        }
                    }

                    override fun onFailure(call: Call<OtpResponse>, t: Throwable) {
                        Log.i(TAG, "onFailure: " + t.localizedMessage)
                    }

                })
        }

    }
}

