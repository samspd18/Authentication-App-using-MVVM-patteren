package com.example.authenticationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.authenticationapp.databinding.FragmentLoginBinding
import com.example.authenticationapp.util.AuthListener
import com.example.authenticationapp.viewModel.MainViewModel

class LoginFragment : Fragment() , AuthListener{

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.authListener = this

        binding.newAccount.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

        return binding.root
    }

    override fun onStarted() {
        binding.loginProgressBar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        Toast.makeText(requireActivity(), "Login Successful", Toast.LENGTH_SHORT).show()
        binding.loginProgressBar.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
        binding.loginProgressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}