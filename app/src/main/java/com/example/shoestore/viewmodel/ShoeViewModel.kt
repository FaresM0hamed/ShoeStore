package com.example.shoestore.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.ShoeModel

class ShoeViewModel:ViewModel() {
    private val shoeList= mutableListOf<ShoeModel>()

    var shoeName =""
    var shoeSize =""
    var shoeCompany =""
    var shoeDescription = ""

    private val _shoeList =MutableLiveData<List<ShoeModel>>()
    val ShoeList :LiveData<List<ShoeModel>>
    get() = _shoeList

    //this fun to add a new shoe in ShoeListFragment
    fun addShoeToList(){
        val shoe =ShoeModel(shoeName,shoeSize,shoeCompany,shoeDescription)
        shoeList.add(shoe)
        _shoeList.value =shoeList


    }




}