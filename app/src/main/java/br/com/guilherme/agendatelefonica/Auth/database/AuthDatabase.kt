package br.com.guilherme.agendatelefonica.Auth.database

import br.com.guilherme.agendatelefonica.Auth.module.AuthUsuario
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AuthDatabase {

    fun cadastrarUsuario(user: AuthUsuario, onSuccess: () -> Unit){

        Realm.getDefaultInstance().use { realm ->

            realm.beginTransaction()
            realm.copyToRealm(user)
            realm.commitTransaction()
            onSuccess()
        }

    }


    fun apagarBanco() {
        Realm.getDefaultInstance().use { realm ->
            realm.executeTransaction {
                realm.deleteAll()
            }
        }
    }
}
