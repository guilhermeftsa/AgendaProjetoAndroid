package br.com.guilherme.agendatelefonica.Auth.network

import br.com.guilherme.agendatelefonica.Auth.module.AuthUsuario
import io.reactivex.Observable
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthAPI {

    @POST("auth/sign_in")
    fun logar(@Body usuario: AuthUsuario): Observable<Response<ResponseAPI>>


    @POST("auth")
    fun cadastrar(@Body usuario: AuthUsuario): Observable<AuthUsuario>

}