package com.example.kotlingb.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlingb.model.Repository
import com.example.kotlingb.ui.MainViewState

class MainViewModel: ViewModel() {

    private val TAG = "KotlinGbMainViewModel"


    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        Log.d(TAG, "init")
        viewStateLiveData.value = MainViewState(Repository.getNotes())
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData
}