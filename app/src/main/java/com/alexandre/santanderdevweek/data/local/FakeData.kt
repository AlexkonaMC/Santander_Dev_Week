package com.alexandre.santanderdevweek.data.local

import com.alexandre.santanderdevweek.data.Cartao
import com.alexandre.santanderdevweek.data.Cliente
import com.alexandre.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Alexandre")
        val cartao = Cartao("423567924564")
        return Conta(
            "445655-4",
            "6552-5",
            "2.450,80",
            "4.120,00",
            cliente,
            cartao
        );
    }
}