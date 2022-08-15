package com.example.quartaaulaandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*



class SaudacaoActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // Abre uma nova conexão com o banco
        val db = DataBaseManager(this, "saudacoes")
        // Lista as saudacões e guarda na variável cursor
        val cursor = db.listaSaudacao()

        // Inicializando as variáveis
        var nome = ""
        var tratamento = ""

        // Varifica se o cursor é maior que 0
        if (cursor.count > 0){
            // Move para o primeiro valor do cursor
            cursor.moveToFirst()
            // Adiciona os valores que vieram do cursor nas variáveis nome e tratamento
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }

        // Verifica se possui tratamento e exibe na tela as informações através da edição na propriedade
        // text do textView
        if(tratamento == "Sem tratamento"){
            lbsaudacao.text = nome
        }
        else{
            val saudacao = "$tratamento $nome"
            lbsaudacao.text = saudacao
        }
    }

}