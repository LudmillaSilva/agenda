package com.ludmilla.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.View.VISIBLE
import android.widget.*


class MainActivity : AppCompatActivity() {
    lateinit var edtnome: EditText
    lateinit var celular: EditText
    lateinit var tipopessoa: RadioGroup
    lateinit var pessoafisica: RadioButton
    lateinit var pessoajuridica: RadioButton
    lateinit var pesquisa: EditText
    lateinit var pesquisar: Button
    lateinit var cadastrar: Button
    lateinit var referencia: EditText
    lateinit var email: EditText
    lateinit var listagem: TextView

    private var contatos: MutableList<Pessoa> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtnome = findViewById(R.id.edtNome)
        celular = findViewById(R.id.edtCelular)
        tipopessoa = findViewById(R.id.rdgTipoPessoa)
        pessoafisica = findViewById(R.id.rdPessoaFisica)
        pessoajuridica = findViewById(R.id.rdPessoaJuridica)
        referencia = findViewById(R.id.edtreferencia)
        email = findViewById(R.id.edtemail)
        pesquisa = findViewById(R.id.edtPesquisa)
        pesquisar = findViewById(R.id.btnPesquisar)
        cadastrar = findViewById(R.id.btnCadastrar)
        listagem = findViewById(R.id.txtListagem)

        tipopessoa.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            if (pessoafisica.id == radio.id) {
                referencia.visibility = View.VISIBLE
                email.visibility = View.GONE
            } else {
                email.visibility = View.VISIBLE
                referencia.visibility = View.GONE
            }
        })

        cadastrar.setOnClickListener {
            var contatosexibidos: String = ""
            val nomeinserido = edtnome.text.toString()
            val celularinserido = celular.text.toString()

            if (pessoafisica.isChecked) {
                val referenciainserida = referencia.text.toString()
                var pessoaFisica = Fisica(nomePessoaFisica = nomeinserido,
                    celularPessoaFisica = celularinserido,
                    referencia = referenciainserida)
                contatos.add(pessoaFisica)
                referencia.setText("")

            } else {
                val emailinserido = email.text.toString()
                var pessoaJuridica = Juridica(nomePessoaJuridica = nomeinserido,
                    celularPessoaJuridica = celularinserido,
                    emailPessoaJuridica = emailinserido)
                contatos.add(pessoaJuridica)
                email.setText("")

            }
            edtnome.setText("")
            celular.setText("")
            Toast.makeText(this, "Contato $nomeinserido salvo!", Toast.LENGTH_SHORT).show()

            for (x in contatos) {
                contatosexibidos += x.toString()
            }
            listagem.text = contatosexibidos

            contatos.sortBy { it.nome }
        }

        /*pesquisar.setOnClickListener {
            val pesquisando = pesquisa.text.toString()

            //xuxa == contador (do for)
            val pesquisar = contatos.find { x ->
                x.edtnome() == pesquisa
            }

        }
        fun getNome(): String =

        fun setNome(nomeinserido1: String) {
            var nome1 = nomeinserido1
        }*/

    }
}



