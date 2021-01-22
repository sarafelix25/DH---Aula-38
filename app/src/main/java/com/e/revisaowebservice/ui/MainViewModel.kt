package com.e.revisaowebservice.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.revisaowebservice.entities.Aluno
import com.e.revisaowebservice.service.Service
import com.e.revisaowebservice.service.service
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainViewModel(val service: Service) : ViewModel() {

    var listaResult = MutableLiveData<ArrayList<String>>()

    fun getListRepo() {
        viewModelScope.launch {
            Log.i("DEU CERTO", service.getResultsRepo().toString())
        }
    }
}