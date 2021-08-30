package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLive : ViewModel() {
    var number = 0
    val currentNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}