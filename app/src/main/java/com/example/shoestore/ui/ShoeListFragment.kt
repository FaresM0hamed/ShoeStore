package com.example.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.CardShoeItemBinding
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.view.ShoeViewModel


class ShoeListFragment : Fragment() {

    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)
        binding.lifecycleOwner = this


        viewModel.ShoeList.observe(viewLifecycleOwner) { shoeList ->
            shoeList.forEach { shoe ->
                val shoeItem = CardShoeItemBinding.inflate(layoutInflater)
                shoeItem.shoe = shoe
                binding.linear.addView(shoeItem.root)
            }
        }
        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addShoeDetail.setOnClickListener {

            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }


    }

    //avoiding leek memory
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_menu -> findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)

        }
        return super.onOptionsItemSelected(item)
    }


}

