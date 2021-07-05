package com.orbitalsonic.viewmodellivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>()
    var counterNumber: LiveData<Int> = Transformations.map(_counter) { it }

    fun setCounter(mCount: Int) {
        _counter.value = mCount
    }

}