package com.example.onboardingscereen.utlis

import android.text.TextUtils
import android.util.Patterns


object Utlis {

    fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}