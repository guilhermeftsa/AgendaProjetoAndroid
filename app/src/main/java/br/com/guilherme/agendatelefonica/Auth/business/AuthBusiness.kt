package br.com.guilherme.agendatelefonica.Auth.business

import br.com.guilherme.agendatelefonica.Auth.database.AuthDatabase
import br.com.guilherme.agendatelefonica.Auth.module.AuthUsuario
import br.com.guilherme.agendatelefonica.Auth.network.AuthNetwork

object AuthBusiness {


//    fun logar(usuario: AuthUsuario, onSuccess: () -> Unit){
//        AuthNetwork.logar(usuario, { user: AuthUsuario ->
//            AuthDatabase.apagarBanco()
//                AuthDatabase.cadastrarUsuario(usuario){
//                        onSuccess()
//                }
//        })
//    }

    fun cadastrar(usuario: AuthUsuario, onSuccess: () -> Unit) {

        AuthNetwork.cadastrar(usuario,
                { _ ->
                    onSuccess()
                })

    }
}

