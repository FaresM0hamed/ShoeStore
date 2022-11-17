package com.example.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailsBinding
import com.example.shoestore.view.ShoeViewModel


class ShoeDetailsFragment : Fragment() {
    private var _binding : FragmentShoeDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel:ShoeViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding  = DataBindingUtil.inflate(layoutInflater ,
            R.layout.fragment_shoe_details, container, false)
        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }

        binding.save.setOnClickListener {
            viewModel.addShoeToList()
            findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }
    }


}