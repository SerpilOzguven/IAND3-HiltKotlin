package com.serpilozguven.hiltkotlin

import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

interface MyInterface {
    fun myPrintFunction(): String





}
/*
//Yöntem 1
@InstallIn(ActivityComponent::class) //ApplicationComponent
@Module
abstract class MyModule{

    @ActivityScoped //Singleton
    @Binds
    abstract fun bindingFunction(myImplementor: InterfaceImplementor): MyInterface


}

 */
//Yöntem 2
@InstallIn(SingletonComponent::class)
@Module
class myModule {

    @FirstImplementor
    @Singleton
    @Provides
    fun providerFunction(): MyInterface {
        return InterfaceImplementor()
    }
    //Hangisinden olacağını anlamak için (hata verdi.Alttaki işlemle düzelttik)
    @SecondImplementor
    @Singleton
    @Provides
    fun secondProviderFunction(): MyInterface {
        return SecondInterfaceImplementor()
    }




//Dışarıda kullandığımız kütüphane için
    @Singleton
    @Provides
    fun gsonProvider(): Gson{
        return Gson()

    }

}

//Yukarıdaki hahatayı çözeceğiz
//kendi anatasyonumuzu oluşturacağız.

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FirstImplementor


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SecondImplementor

