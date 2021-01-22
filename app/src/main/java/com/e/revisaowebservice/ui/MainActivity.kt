package com.e.revisaowebservice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.revisaowebservice.R
import com.e.revisaowebservice.adapter.AdapterResult
import com.e.revisaowebservice.service.service
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //instancia do mainViewModel sem utilizar paramentros por enquanto
    //isso pq ainda não estamos usando repositorio e não precisamos passar parametros
    //val viewModel: MainViewModel by viewModels()

    //passando com parametros
    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }

        }
    }


    lateinit var adapterResult: AdapterResult
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        rvResult.layoutManager = linearLayoutManager

        viewModel.listaResult.observe(this, {
            adapterResult = AdapterResult(it)
            rvResult.adapter = adapterResult
        })

        viewModel.getListRepo()


    }

}