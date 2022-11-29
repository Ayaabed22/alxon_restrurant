package com.example.onboardingscereen.signup

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
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.onboardingscereen.R
import com.example.onboardingscereen.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignupFragment : Fragment() {
    var editTextFullName: EditText? = null
    var editTextEmail: EditText? = null
    var editTextTelephoneNumber: EditText? = null
    var editTextPassword: EditText? = null
    var textViewSignIn: TextView? = null
    var buttonSignUp: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewSignIn = view.findViewById(R.id.textViewSignIn)
        buttonSignUp = view.findViewById(R.id.buttonSignUp)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextFullName = view.findViewById(R.id.edittext_fullName)
        editTextTelephoneNumber = view.findViewById(R.id.editTextTelephoneNumber)
        editTextPassword = view.findViewById(R.id.edittext_password)

        textViewSignIn?.setOnClickListener {
            view.findNavController().navigate(R.id.action_signupFragment_to_signinFragment)
        }
        buttonSignUp?.setOnClickListener {
            var password = editTextPassword?.text.toString()
            var confirmPassword = editTextPassword?.text.toString()


            var email = editTextEmail?.text.toString()

            var telephone = editTextTelephoneNumber?.text.toString()
            var name = editTextFullName?.text.toString()

            RetrofitClient.getClient()
                .signUp(email, password, name, telephone, confirmPassword)
                .enqueue(object : Callback<SignUpResponse> {
                    override fun onResponse(
                        call: Call<SignUpResponse>,
                        response: Response<SignUpResponse>
                    ) {
                        if (response.isSuccessful) {
                            Log.e(TAG, "onResponse: " + response.body())
                             val sharedPreferences = context!!.getSharedPreferences("app_name", Context.MODE_PRIVATE)
                            sharedPreferences.edit().putString("token", "bearer ${response.body()!!.token}").apply()
                            Log.i(TAG, "onResponse: "+ sharedPreferences.edit().putString("token", "bearer ${response.body()!!.token}").apply())


                            view.findNavController().navigate(R.id.action_signupFragment_to_otpAuthentication)

                        } else {
                            Log.e(TAG, "onResponse: " + response.errorBody())
                        }

                    }

                    override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                        Log.i(TAG, "onFailure:  " + t.localizedMessage)
                    }

                })

        }

             }
        }


