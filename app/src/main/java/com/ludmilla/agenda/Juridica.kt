package com.ludmilla.agenda

class Juridica (nomePessoaJuridica: String,
                celularPessoaJuridica: String,
            val emailPessoaJuridica: String):
                Pessoa(nomePessoaJuridica,
                celularPessoaJuridica) {
    override fun toString(): String {
        return " $nome, $celular, $emailPessoaJuridica\n"
    }
}