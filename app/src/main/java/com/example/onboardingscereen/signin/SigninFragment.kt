package com.example.onboardingscereen.signin

import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.onboardingscereen.R
import com.example.onboardingscereen.network.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SigninFragment : Fragment() {

    var textViewSignUp: TextView? = null
    var buttonSignin: Button? = null
    var textViewForgetPassword: TextView? = null
    var editTextEmail: EditText? = null
    var editTextPassword: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textViewSignUp = view.findViewById(R.id.textViewSignUp)
        buttonSignin = view.findViewById(R.id.buttonSignin)
        textViewForgetPassword = view.findViewById(R.id.textViewForgetPassword)
        editTextEmail = view.findViewById(R.id.edittext_email)
        editTextPassword = view.findViewById(R.id.edittext_password)

        textViewForgetPassword?.setOnClickListener {
            view.findNavController().navigate(R.id.action_signinFragment_to_checkEmail)
        }
        buttonSignin?.setOnClickListener {
            var email = editTextEmail?.text.toString()
            var password = editTextPassword?.text.toString()
            checkEnteredData(email, password)
        }
        textViewSignUp?.setOnClickListener {
            view.findNavController().navigate(R.id.action_signinFragment_to_signupFragment)
        }


    }

    private fun checkEnteredData(email: String, password: String) {
        RetrofitClient.getClient().login(LoginRequest(email, password)).enqueue(object :
            Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val sharedPreferences = context!!.getSharedPreferences("app_name", Context.MODE_PRIVATE)
                    sharedPreferences?.edit()?.putString("token","Bearer ${response.body()!!.token.toString()}")?.apply()

                    Log.i(TAG, "onResponse: "+sharedPreferences.edit().putString("token","Bearer ${response.body()!!.token.toString()}")?.apply())

                    view?.findNavController()?.navigate(R.id.action_signinFragment_to_homeFragment)
                } else {
                    Log.i(TAG, "onResponse: "+ response.errorBody())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.i(TAG, "onFailure: ")
                Log.i(TAG, "onFailure:  " + t.localizedMessage)
            }

        })
    }



}