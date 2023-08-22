package com.serpilozguven.hiltkotlin

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

//Constructor Injection
@Singleton
class Musician
    @Inject
    constructor(instrument : Instrument,band: Band) {
    fun sign() {
        println("working..")
    }
}