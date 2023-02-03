package br.com.impacta.firstappkotlin

import com.orhanobut.hawk.Hawk


var isSigned: Boolean
    get() = Hawk.get("isSigned", false)
    set(value) {
        Hawk.put("isSigned", value)
    }