package com.udacity.shoestore.screens.shoeDetail;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.databinding.ShoeListingFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoeListing.ShoeListingViewModel

public class ShoeDetailFragment : Fragment() {
    private lateinit var binding: ShoeDetailFragmentBinding
    private lateinit var ViewModel: ShoeListingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_detail_fragment,
            container,
            false
        )
        ViewModel = ViewModelProvider(requireActivity()).get(ShoeListingViewModel::class.java)
        binding.shoeListingViewModel = ViewModel
        binding.shoe = Shoe("", 0.0, "", "")

        ViewModel.shoeAdded.observe(viewLifecycleOwner, Observer { shoesAdded ->
            if (shoesAdded){
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
                ViewModel.listCompiled()
            }
        })

        return binding.root
    }

}
