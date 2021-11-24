package com.udacity.shoestore.screens.shoeListing;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.databinding.ShoeListingFragmentBinding

public class ShoeListingFragment : Fragment() {

    private lateinit var ViewModel: ShoeListingViewModel

    private lateinit var binding: ShoeListingFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_listing_fragment, container, false)

        // Get the viewModel
        ViewModel = ViewModelProvider(requireActivity()).get(ShoeListingViewModel::class.java)

        binding.shoeListingViewModel = ViewModel

        /** Setting up LiveData observation relationship **/
        ViewModel.currentShoes.observe(viewLifecycleOwner, Observer { newShoes ->
//            val textView = TextView(this)
//            val lineaerLayout: LinearLayout = binding.shoeListLayout
            for(shoe in newShoes) {
//                textView = shoe
//                binding.shoeListLayout.addView(textView)
                // Change this to create a linear layout, then add the shoe into the layout as text views.
                val itemBinding = ShoeDetailFragmentBinding.inflate(layoutInflater, null, false)
                itemBinding.shoe = shoe
                binding.shoeListLayout.addView(itemBinding.root)
            }
        })

//      // navigate to the shoe detail screen when the floating action button is tapped
        binding.fab.setOnClickListener{
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

            return binding.root
        }
    }
