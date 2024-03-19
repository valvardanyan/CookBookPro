package com.example.cookbookpro.ui.fragmentContainers.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "InsertValue"
    }
    val text: LiveData<String> = _text
}