package com.example.studyandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var _name: MutableLiveData<String> = MutableLiveData()
    val name: LiveData<String> get() = _name
}