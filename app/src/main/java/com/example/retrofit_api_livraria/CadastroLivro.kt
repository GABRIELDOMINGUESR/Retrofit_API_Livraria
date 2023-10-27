package com.example.retrofit_api_livraria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.gson.JsonObject

class CadastroLivro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_livro)


        //Declarando e recuperando os objetos de view
        val txtTitulo = findViewById<EditText>(R.id.txtTitulo)
        val txtPreco = findViewById<EditText>(R.id.txtPreco)
        val txtCategoria = findViewById<EditText>(R.id.txtCategoria)
        val txtDescricao = findViewById<EditText>(R.id.txtLivroDescricao)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrarLivro)


        //TRATAMENTO DA AÇÃO DE CLICK
        btnCadastrar.setOnClickListener {
         //ENTRADA DOS DADOS
            val titulo = txtTitulo.text.toString()
            val preco = txtPreco.text.toString()
            val categoria = txtCategoria.text.toString()
            val descricao = txtDescricao.text.toString()

         //MONTAGEM DO CORPO JSON DOS DADOS DO LIVRO

            val body = JsonObject().apply {
                addProperty("titulo", titulo)
                addProperty("preco", preco)
                addProperty("categoria", categoria)
                addProperty("descricao", descricao)


            }
            Log.e("Body-Jdon", body.toString())

            //NAVEGAÇÃO PARA TELAS DE IMAGEM DE LIVRO
            val intent = Intent(
                   this,
                                    CadastroLivroImagem::class.java).apply {
                                        putExtra("BODY-JSON", body.toString())
                                    }
            startActivity(intent)

        }

    }
}