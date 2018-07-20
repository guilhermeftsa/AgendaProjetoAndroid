package br.com.guilherme.agendatelefonica.Auth.business

import br.com.guilherme.agendatelefonica.Auth.database.AuthDatabase
import br.com.guilherme.agendatelefonica.Auth.module.AuthUsuario
import br.com.guilherme.agendatelefonica.Auth.network.AuthNetwork

object AuthBusiness {


    fun logar(email: String, password: String,  onSuccess: () -> Unit){
        val usuario = AuthUsuario()

        usuario.email = email
        usuario.password = password
        AuthDatabase.apagarBanco()
        AuthNetwork.logar(usuario, { usuario ->

                AuthDatabase.cadastrarUsuario(usuario){
                        onSuccess()
                }
        })
    }

    fun cadastrar(usuario: AuthUsuario, onSuccess: () -> Unit) {

        AuthNetwork.cadastrar(usuario,
                { _ ->
                    onSuccess()
                })

    }
}

