package com.example.tictactoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    private val initialCage = mutableListOf(mutableListOf(0, 0, 0),
                                            mutableListOf(0, 0, 0),
                                            mutableListOf(0, 0, 0)
    )
    private val _cagesState = MutableLiveData<MutableList<MutableList<Int>>>(initialCage)

    val cages: LiveData<MutableList<MutableList<Int>>>
    get() = _cagesState

    fun set(row: Int, column: Int) {
        initialCage[row-1][column-1] = 1
        _cagesState.value = initialCage
    }
}