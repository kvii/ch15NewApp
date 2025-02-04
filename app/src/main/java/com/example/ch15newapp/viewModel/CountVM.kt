package com.example.ch15newapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ch15newapp.repository.CountRepo
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.ch15newapp.App

class CountVM(private val repo: CountRepo) : ViewModel() {
    private val _count = MutableLiveData(repo.getCount())

    val count: LiveData<Int> get() = _count

    fun increment() {
        val newCount = _count.value!! + 1
        repo.saveCount(newCount)
        _count.value = newCount
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = (this[APPLICATION_KEY] as App)
                CountVM(app.countRepo)
            }
        }
    }
}