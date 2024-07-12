package com.arena.ui.activity.auth.registerverification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arena.R
import com.arena.databinding.FragmentAuthRegisterVerificationBinding
import com.arena.ui.util.NavOptionsUtil

class VerificationFragment : Fragment() {

    private var _binding: FragmentAuthRegisterVerificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthRegisterVerificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_loginFragment,null, NavOptionsUtil.defaultNavOptions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
