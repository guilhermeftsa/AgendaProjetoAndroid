package br.com.guilherme.agendatelefonica.Auth.module

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class AuthUsuario: RealmObject(){

    var email: String? = null

    var password: String? = null

    @SerializedName("password_confirmation")
    var passwordConfirmation: String? = null

    //Headers
    @SerializedName("access-token")
    var accessToken: String? = null
    var uid: String? = null
    var client: String? = null

}