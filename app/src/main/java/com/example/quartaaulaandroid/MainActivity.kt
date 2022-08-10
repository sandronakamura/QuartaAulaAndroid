package com.example.quartaaulaandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bloco de código é executado após o clique no botão
        btnSalvar.setOnClickListener(View.OnClickListener{
            // Arquivo de preferências compartilhadas com o nome saudacao
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
            // Inicia uma variável com a edição
            val editor = saudacaoPersistencia.edit()

            // Adiciona o conteúdo do textView e ListView como prefenrências
            editor.putString("nome", txtNome.text.toString())
            editor.putString("tratamento", listTratamento.selectedItem.toString())
            editor.apply()

            // Abre um pop-up simples informando que foi salvo com sucesso
            Toast.makeText(this,"Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        })

        // Bloco de código é executado após o clique no botão
        btnExibir.setOnClickListener(View.OnClickListener {
            // Adiciona a intenção de iniciar o SaudaçãoActivity após o click no botão exibir
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })




    }
}