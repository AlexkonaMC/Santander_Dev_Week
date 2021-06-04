package com.alexandre.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexandre.santanderdevweek.data.Conta
import com.alexandre.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel() {
    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente(): LiveData<Conta> {
        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData
    }
}

// pegar os dados e trafegar para a activity
// definindo o liveData mutavel passando o "tipo" <Conta> de onde vamos trafegar os dados
/* private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData() */
//tem a responsabilidade de setar um valor: LiveData apenas repassa dados
//: MutableLiveData pode-se mudar alguma informação