package br.com.impacta.firstappkotlin

import android.app.Application
import com.orhanobut.hawk.Hawk

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build();
    }
}