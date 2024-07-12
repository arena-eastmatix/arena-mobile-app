package com.arena.ui.activity.auth.login

import UserRepository
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arena.R
import com.arena.data.source.local.SharedPreferencesManager
import com.arena.data.source.remote.RetrofitClient
import com.arena.databinding.FragmentAuthLoginBinding
import com.arena.ui.activity.user.UserActivity
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var _binding: FragmentAuthLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var userRepository: UserRepository
    private lateinit var prefs: SharedPreferencesManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs = SharedPreferencesManager(requireContext())
        userRepository = UserRepository(RetrofitClient.instance, prefs)

        binding.loginButton.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "All fields are required", Toast.LENGTH_SHORT).show()
            } else {
                lifecycleScope.launch {
                    val result = userRepository.loginUser(email, password)
                    if (result.isSuccess) {
                        userRepository.saveToken(result.getOrNull()!!.token)
                        val intent = Intent(activity, UserActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    } else {
                        Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.registerPrompt.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
