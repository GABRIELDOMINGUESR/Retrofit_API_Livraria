package com.example.retrofit_api_livraria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class Cadastro_Categoria : AppCompatActivity() {

    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_categoria)

        // CONECTA APOSERVICE COM API REST ATRAVES DA CLASSE RetrofitHelper
        // E SEU MÉTODO getInstance()
        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        // RECUPERA O COMPONENTE GRÁFICO DE EditText
        val txtCategorian= findViewById<EditText>(R.id.txtCategoria)

        // TRATA A AÇÃO DE CLICK OU TOQUE NO BOTÃO CADASTRAR
        findViewById<Button>(R.id.btnCadastrarCategoria).setOnClickListener{

            //Recuperar o dado digitado pelo usuario
            val nomeCategoria = txtCategorian.text



            //enviar a requisição de cadrastro para a api

            createCategory(nomeCategoria.toString())
        }

    }//FIM DO METODO onCreate


   //implementação do metodo creatCategory
    private fun createCategory(nome_categoria: String){
    lifecycleScope.launch {

        //montagen do corpo de daods em json
        val body = JsonObject().apply {
            addProperty("nome_categoria", nome_categoria)
        }

        //envio da requisição de cadastro de categoria
        val result = apiService.createCategory(body)


        //verificar a requisição da Requisição
        if (result.isSuccessful){
            val msg = result.body()?.get("mensagemStatus")
            Log.e("CREAT-CATEGORY", "STATUS: ${msg}")


        }else{
            Log.e("CREAT-CATEGORY", "ERROR: ${result.message()}")
        }

        }
    }

}//Fim da classe