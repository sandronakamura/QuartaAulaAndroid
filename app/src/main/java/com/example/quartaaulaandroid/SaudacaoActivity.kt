package com.example.quartaaulaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // Aciona a função recuperaDadoArquivo chamando pelo nome saudacao
        val data = recuperaDadoArquivo("saudacao")
        // Converte os dados recebidos para String
        val tokenizer = StringTokenizer(data, ":")
        // Valida se o que foi recebido tem nome e tratamento e exibe na tela
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem nome"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem tratamento"
        if(tratamento.equals("Sem tratamento")){
            lbsaudacao.text = nome
        }
        else{
            val saudacao = "$tratamento $nome"
            lbsaudacao.text = saudacao
        }
    }
    fun recuperaDadoArquivo(filename: String): String{
        // Bloco try catch
        try {
            // Abre o arquivo com o nome recebido
            val fi = openFileInput(filename)
            // Atribui a uma variável os dados vindos do arquivo
            val data = fi.readBytes()
            // Fecha conexão com o arquivo
            fi.close()
            // Converte dados para String
            data.toString()
            // Retorna as informações como String
            return data.toString(Charset.defaultCharset())
        } catch (e: FileNotFoundException) {
            return ""
        } catch (e: IOException) {
            return ""
        }
    }
}