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

    fun set(row: Int, column: Int, user: Int) {
        initialCage[row-1][column-1] = user
        _cagesState.value = initialCage
    }

    private fun isMatching(c1: List<Int>, c2: List<Int>, c3: List<Int>): Int {
        val matchCondition1 = initialCage[c1[0]-1][c1[1]-1] == initialCage[c2[0]-1][c2[1]-1]
        val matchCondition2 =  initialCage[c2[0]-1][c2[1]-1] == initialCage[c3[0]-1][c3[1]-1]
        return if (matchCondition1 && matchCondition2 && initialCage[c1[0]-1][c1[1]-1] != 0) {
            initialCage[c1[0]-1][c1[1]-1]
        } else {
            0
        }
    }
    fun winListener(): Int {
        var win = 0
        val winCondition1 = isMatching(listOf(1,1), listOf(1,2), listOf(1,3))
        val winCondition2 = isMatching(listOf(2,1), listOf(2,2), listOf(2,3))
        val winCondition3 = isMatching(listOf(3,1), listOf(3,2), listOf(3,3))
        val winCondition4 = isMatching(listOf(1,1), listOf(2,1), listOf(3,1))
        val winCondition5 = isMatching(listOf(1,2), listOf(2,2), listOf(3,2))
        val winCondition6 = isMatching(listOf(1,3), listOf(2,3), listOf(3,3))
        val winCondition7 = isMatching(listOf(1,1), listOf(2,2), listOf(3,3))
        val winCondition8 = isMatching(listOf(1,3), listOf(2,2), listOf(3,1))
        val winConditions = listOf(winCondition1, winCondition2, winCondition3, winCondition4,
                                    winCondition5, winCondition6, winCondition7, winCondition8)

        winConditions.forEach { winCondition ->
            if (winCondition != 0) {
                win = winCondition
            }
        }
        return win
    }
}