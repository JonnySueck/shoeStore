package com.udacity.shoestore.screens.shoeListing;

import android.util.EventLog
import android.util.Log
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListingFragmentBinding
import timber.log.Timber
import kotlin.math.log
import com.udacity.shoestore.models.Shoe as Shoe


public class ShoeListingViewModel : ViewModel() {

    private var binding: ShoeListingFragmentBinding? = null


    // the current shoes in the inventory (private live data)
    private val _currentShoes = MutableLiveData<MutableList<Shoe>>()
    // public live data
    val currentShoes: LiveData<MutableList<Shoe>>
        get() = _currentShoes

    private val _shoeAdded = MutableLiveData<Boolean>()
    val shoeAdded: LiveData<Boolean>
        get() = _shoeAdded

    // flag if the list needs re-compiled
    fun listCompiled() {
        _shoeAdded.value = false
    }

    // initialize the list of shoes
    init {
        showShoes()
        _shoeAdded.value = false
    }

    // add a shoe to the mutable variable, then flag the observer variable
    fun addShoe(shoe: Shoe) {
        _currentShoes.value?.add(shoe)
        _shoeAdded.value = true
    }

    // flag the observer to go back
    fun cancel(){
        _shoeAdded.value = true
    }

    // show the shoes in the mutable live data variable
    fun showShoes() {
        _currentShoes.value = ArrayList<Shoe>()
    }

    override fun onCleared() {
        super.onCleared()
    }

}
