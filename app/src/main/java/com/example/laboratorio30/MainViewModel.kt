package com.example.laboratorio30

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val comparadorResultado =  MutableLiveData<Boolean>()
    fun comparadorTexto(texto1: String, texto2: String) {
        comparadorResultado.value = texto1 == texto2

    }
}





