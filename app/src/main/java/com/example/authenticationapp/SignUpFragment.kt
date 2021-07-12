package com.example.authenticationapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.authenticationapp.databinding.FragmentSignUpBinding
import com.example.authenticationapp.util.AuthListener
import com.example.authenticationapp.viewModel.MainViewModel

class SignUpFragmentFragment : Fragment(),AuthListener {

    private var _binding : FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentSignUpBinding.inflate(inflater, container, false)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.authListener = this

        binding.alreadyWithUs.setOnClickListener {
            val nav = findNavController()
            nav.navigate(R.id.loginFragment)
        }

        return binding.root
    }

    override fun onStarted() {
        binding.signUpProgressbar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        binding.signUpProgressbar.visibility = View.GONE
        Toast.makeText(requireActivity(), "Sign up Successfully", Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(message: String) {
        binding.signUpProgressbar.visibility = View.GONE
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}