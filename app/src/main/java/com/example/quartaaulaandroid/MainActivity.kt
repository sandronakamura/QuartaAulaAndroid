package com.example.quartaaulaandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Abre conexão com o banco
        val db = DataBaseManager(this, "saudacoes")

        // Adiciona um listener que ao clicar no botão Salvar executa o bloco de código
        btnSalvar.setOnClickListener(View.OnClickListener {
            // Aciona a função para remover a saudação
            db.removeSaudacao()
            // Aciona a função adicionar uma nova saudação passando os dados do TextView Nome e ListView de tratamento
            // por parâmetro
            db.insereSaudacao(1, txtNome.text.toString(), listTratamento.selectedItem.toString())
            // Mostra um pop up na tala informando que foi Salvo com sucesso
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        })


        // Adiciona um listener que ao clicar no botão Exibir executa o bloco de código
        btnExibir.setOnClickListener(View.OnClickListener {
            // Intenção de abrir uma nova tela SaudacaoActivity quandon clicado no botão
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }


}