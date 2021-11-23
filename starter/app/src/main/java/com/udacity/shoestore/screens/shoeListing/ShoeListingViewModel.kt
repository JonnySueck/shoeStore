package com.udacity.shoestore.screens.shoeListing;

import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe as Shoe


public class ShoeListingViewModel : ViewModel() {

    val shoeList = ArrayList<Shoe>()

    // the current shoes in the inventory (private live data)
    private val _currentShoes = MutableLiveData<MutableList<Shoe>>()
    // public live data
    val currentShoes: LiveData<MutableList<Shoe>>
        get() = _currentShoes

    private val _shoeAdded = MutableLiveData<Boolean>()
    val shoeAdded: LiveData<Boolean>
        get() = _shoeAdded

    fun listCompiled() {
        _shoeAdded.value = false
    }
    init {
        showShoes()
        _shoeAdded.value = false
    }
//    }
    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        _currentShoes.value = shoeList
    }

    fun showShoes() {
        //Select and remove a word from the list
        _currentShoes.value = ArrayList<Shoe>()
    }
    override fun onCleared() {
        super.onCleared()
    }


        // 1. create an onClickListener when the continue button is pressed
        // 2. Retrieve the data that was submitted (name, size(type: double), company, description)
        // 3. access the shoe model and add create a new instance of shoe
//    }
}
