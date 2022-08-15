package com.example.quartaaulaandroid

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseManager(context: Context, name: String) : SQLiteOpenHelper(context, name, null, 1) {

    // Criar tabela SAUDACAO no banco com os atributos ID_SAUDACAO(PK), NOME, TRAMENTO
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tTRATAMENTO VARCHAR(20), \n" +
                "\tPRIMARY KEY (ID_SAUDACAO)\n" +
                "\t);")

    }

    // Deleta a tabela SAUDACAO se ela já existir e depois recria ela com os ID_SAUDACAO(PK), NOME, TRAMENTO
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS SAUDACAO")
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tTRATAMENTO VARCHAR(20), \n" +
                "\tPRIMARY KEY (ID_SAUDACAO)\n" +
                "\t);")
    }

    // Função para inserir dados no banco, recebe 3 parâmetros: id, nome e tratamento
    fun insereSaudacao(id: Int, nome: String, tratamento: String){
        // Abre conexão com o banco
        val db = this.writableDatabase
        // Cria uma variável para receber os campos e dados
        val cv = ContentValues()
        cv.put("ID_SAUDACAO", id)
        cv.put("NOME", nome)
        cv.put("TRATAMENTO", tratamento)

        // Insere os dados vindos do cv para a tabela SAUDACAO
        db.insert("SAUDACAO", "ID_SAUDACAO", cv)
    }

    // Função para listar saudacoes
    fun listaSaudacao(): Cursor {
        // Abre conexão com o banco
        val db = this.readableDatabase
        // retorna os valores nome, tratamento da tabela saudacao
        return db.rawQuery("select nome, tratamento from saudacao", null)
    }

    // Funcão para remover saudação
    fun removeSaudacao(){
        // Abre conexão com o banco
        val db = this.writableDatabase
        // Remove o dado com ID_SAUDACAO=1 da tabela SAUDACAO
        db.delete("SAUDACAO", "ID_SAUDACAO=1", null)
    }


}