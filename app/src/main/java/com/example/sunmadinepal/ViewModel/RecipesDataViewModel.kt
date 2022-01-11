package com.example.sunmadinepal.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sunmadinepal.R
import com.example.sunmadinepal.model.RecipesData

class RecipesDataViewModel : ViewModel {


    var itemImage: Int = 0
    var itemName =""
    var itemDescription = ""

    constructor() : super()
    constructor(recipesData: RecipesData) : super() {
        //this.itemImage =recipesData.itemImage
        this.itemName = recipesData.itemName
        this.itemDescription = recipesData.itemDescription
    }

    var arraylistmutablelivedata = MutableLiveData<ArrayList<RecipesDataViewModel>>()
    var arrayList = ArrayList<RecipesDataViewModel>()




    fun  getArrayList() :MutableLiveData<ArrayList<RecipesDataViewModel>>{


       // val cat1 = RecipesData(R.drawable.app_how_to_make_litto,"How to prepare nutritional flour:","hdjhfdjfhdjf ")

       // val caviewmodle1 : RecipesDataViewModel = RecipesDataViewModel(cat1)
       // arrayList.add(caviewmodle1)
        arraylistmutablelivedata.value = arrayList
        return arraylistmutablelivedata
    }

}