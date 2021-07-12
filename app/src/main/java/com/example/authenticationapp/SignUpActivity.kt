package com.example.authenticationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationapp.databinding.ActivitySignUpBinding
import com.example.authenticationapp.util.AuthListener
import com.example.authenticationapp.util.toast
import com.example.authenticationapp.viewModel.MainViewModel

class SignUpActivity : AppCompatActivity() , AuthListener {

    private var _binding : ActivitySignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.authListener = this

        binding.signUpProgressbar.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStarted() {
        binding.signUpProgressbar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        binding.signUpProgressbar.visibility = View.GONE
        toast("Sign up Successfully")
    }

    override fun onFailure(message: String) {
        binding.signUpProgressbar.visibility = View.GONE
        toast(message)
    }
}