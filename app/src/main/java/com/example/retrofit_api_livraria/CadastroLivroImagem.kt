package com.example.retrofit_api_livraria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CadastroLivroImagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_livro_imagem)


        //TESTE DO RECEBIMENTO DO JSON
        val bodyJSON = intent.getStringExtra("BODY-JSON")
        Log.e("Teste-Json", bodyJSON.toString())

    }
}