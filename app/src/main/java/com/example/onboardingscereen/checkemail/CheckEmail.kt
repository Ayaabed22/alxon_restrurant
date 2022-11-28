package com.example.onboardingscereen.checkemail

import android.content.ContentValues.TAG
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


class CheckEmail : Fragment() {
    var buttonSendEmail:Button?=null
    var editTextEmail:EditText?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forget_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSendEmail=view.findViewById(R.id.buttonSendEmail)
        editTextEmail=view.findViewById(R.id.edittextEmail)



        buttonSendEmail?.setOnClickListener {
            var email =editTextEmail?.text.toString()
            RetrofitClient.getClient().checkEmail(email).enqueue(object :Callback<checkEmailResponse>{
                override fun onResponse(
                    call: Call<checkEmailResponse>,
                    response: Response<checkEmailResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i(TAG, "onResponse: "+email)
                        Log.i(TAG, "onResponse: "+response.body())
                        Log.i(TAG, "onResponse: "+response.body()!!.message)
                        view.findNavController().navigate(R.id.action_checkEmail_to_checkOtpForEmail)
                    }
                    else{
                        Log.i(TAG, "onResponse: "+response.errorBody())
                    }
                }

                override fun onFailure(call: Call<checkEmailResponse>, t: Throwable) {
                    Log.i(TAG, "onFailure: "+t.localizedMessage)
                }

            })

        }
    }
}