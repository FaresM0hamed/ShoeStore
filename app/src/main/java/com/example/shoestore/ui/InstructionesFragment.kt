package com.example.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentInstructionesBinding


class InstructionesFragment : Fragment() {
    private var _binding : FragmentInstructionesBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding  = DataBindingUtil.inflate(layoutInflater ,
            R.layout.fragment_instructiones, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_instructionesFragment_to_shoeListFragment)
        }
    }


    //avoiding leek memory
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}