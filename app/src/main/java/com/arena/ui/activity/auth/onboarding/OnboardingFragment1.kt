package com.arena.ui.activity.auth.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arena.R
import com.arena.databinding.FragmentAuthOnboarding1Binding
import com.arena.ui.util.NavOptionsUtil

class OnboardingFragment1 : Fragment() {

    private var _binding: FragmentAuthOnboarding1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthOnboarding1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment1_to_onboardingFragment2, null, NavOptionsUtil.defaultNavOptions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
