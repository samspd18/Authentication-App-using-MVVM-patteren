package com.example.authenticationapp.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.authenticationapp.util.AuthListener

class MainViewModel : ViewModel() {

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    var email : String ? = null
    var password : String? = null

    var signupName : String? = null
    var signupEmail : String? = null
    var signupPassword : String? = null

    var authListener : AuthListener? = null

    fun onLoginClick(view: View) {
        authListener?.onStarted()
        //in case email or password is empty
        if(!(email!!matches(emailPattern.toRegex()))|| password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return
        }
        //Authenticated
        authListener?.onSuccess()

    }

    fun onSignUpClick(view: View) {
        authListener?.onStarted()
        //in case one of the field is empty
        if(signupName.isNullOrEmpty() || signupEmail.isNullOrEmpty() || signupPassword.isNullOrEmpty()) {
            authListener?.onFailure("Invalid name , email or password")
            return
        }
        //Authenticated
        authListener?.onSuccess()
    }

}