package com.example.quartaaulaandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileNotFoundException
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adiciona um listener que fica aguardando o clique no botão para executar o bloco de código
        btnSalvar.setOnClickListener(View.OnClickListener {
            // Gera uma variável data com as informações escolhidas e envia para a funcao gravaDadoArquivo
            val data = txtNome.text.toString() + ":" + listTratamento.selectedItem.toString()
            gravaDadoArquivo("saudacao", data)
            // Mostra uma mensagem na tela informando que foi salvo com sucesso
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        })

        // Adiciona um listener que fica aguardando o clique no botão para executar o bloco de código
        btnExibir.setOnClickListener(View.OnClickListener {
            // Mostra a intenção de abrir a SaudacaoActivity quando for acionado o botão
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }

    // Função para gravar dados no arquivo que recebe dois parâmetros do tipo String
    fun gravaDadoArquivo(filename: String, data: String) {
        // Bloco try catch
        try {
            // Cria variável que recebe o arquivo com o nome do arquivo e o contexto
            val fs = openFileOutput(filename, Context.MODE_PRIVATE)
            // Escreve no arquivo com os dados recebidos
            fs.write(data.toByteArray())
            // Fecha conexão com o arquivo
            fs.close()
        } catch (e: FileNotFoundException) {
            // Caso o arquivo não seja encontrado envia um log descritivo
            Log.i("gravaDadoArquivo", "FileNotFoundException")
        } catch (e: IOException) {
            // Caso seja um problea de entrada ou saida de dados envia um log descritivo
            Log.i("gravaDadoArquivo", "IOException")
        }


    }
}