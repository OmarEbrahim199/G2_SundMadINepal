package com.example.sunmadinepal.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Profile Fragment"




    }
    val text: LiveData<String> = _text


    private val _New_activity = MutableLiveData<String>().apply {
        value = "This is Profile Fragment"

    }
    val newactivity: LiveData<String> = _New_activity



}

