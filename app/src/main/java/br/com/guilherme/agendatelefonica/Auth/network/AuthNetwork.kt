package br.com.guilherme.agendatelefonica.Auth.network

import br.com.guilherme.agendatelefonica.Auth.module.AuthUsuario
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AuthNetwork {

    val AuthAPI by lazy {
        getRetrofit().create(AuthAPI::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api-agenda-unifor.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

//    fun logar(usuario: AuthUsuario, onSuccess: (user: AuthUsuario) -> Unit) {
//
//        AuthAPI.logar(usuario)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ user ->
//
//                    user?.let { response ->
//                        response!!.body().let {
//
//                        }
//
//                        onSuccess(it)
//                    }
//
//                })
//
//    }

    fun cadastrar(usuario: AuthUsuario, onSuccess: (user: AuthUsuario) -> Unit) {

        AuthAPI.cadastrar(usuario)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ user ->

                    user?.let {
                        onSuccess(it)
                    }

                },{

                })

    }

    fun logar(usuario: AuthUsuario, onSuccess: (usuario: AuthUsuario) -> Unit){

        AuthAPI.logar(usuario)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->

                    response.body()!!.data?.let { usuario ->

                        usuario?.uid = response.headers().get("uid")
                        usuario?.client = response.headers().get("client")
                        usuario?.accessToken = response.headers().get("access-token")

                            onSuccess(usuario)

                    }
                })
        }
    }


