package com.example.quartaaulaandroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // Arquivo de preferências compartilhadas com o nome saudacao
        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

        // Atribui os valores das preferências nas variáveis
        val nome = saudacaoPersistencia.getString("nome","")
        val tratamento = saudacaoPersistencia.getString("tratamento","")

        // Verifica se está sem tratamento e altera o textView da saudação, caso possua altera o
        // txetView com o tratamento e o nome
        if(tratamento.equals("Sem tratamento")){
            lbsaudacao.text = nome
        }
        else{
            val saudacao = "$tratamento $nome"
            lbsaudacao.text = saudacao
        }
    }
}