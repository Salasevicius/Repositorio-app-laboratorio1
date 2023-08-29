package com.example.laboratorio30

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.laboratorio30.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.button.setOnClickListener {
            val texto1 = binding.editText1.text.toString()
            val texto2 = binding.editText2.text.toString()
            mainViewModel.comparadorTexto(texto1, texto2)

        }

        mainViewModel.comparadorResultado.observe(this) {
            binding.textViewResultado.text = if (it)"Las cadenas de caracteres ingresadas son iguales"
            else "Las cadenas de caracteres ingresadas son diferentes"
        }

    }
}
