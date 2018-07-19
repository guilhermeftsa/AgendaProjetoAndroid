package br.com.guilherme.agendatelefonica

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import br.com.guilherme.agendatelefonica.Auth.business.AuthBusiness
import br.com.guilherme.agendatelefonica.Auth.module.AuthUsuario
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this)
        cadastrar()

    }

    fun cadastrar() {

        botaoCadastrar.setOnClickListener {

            val usuarioA = AuthUsuario()

            usuarioA.email = campoEmail.text.toString()
            usuarioA.password = campoSenha.text.toString()
            usuarioA.passwordConfirmation = usuarioA.password


            AuthBusiness.cadastrar(usuarioA, {
                    Log.d("tag", "cadastrou")
                })
            }


        }


    }
