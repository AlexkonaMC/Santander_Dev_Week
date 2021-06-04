package com.alexandre.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.alexandre.santanderdevweek.R
import com.alexandre.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel   //import o MutableLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java) //já esta construido
        buscarContaCliente()
    }

    private fun buscarContaCliente(){
        mainViewModel.buscarContaCliente().observe(this, { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta : Conta){
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_conta_corrente).text = conta.numero
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_limite).text = conta.limite
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tv_cartao_value).text = conta.cartao.numeroCartao
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.item_1 -> {
                Log.d("CLICK", "Click no Item 1")
                true
            }
            else -> return onOptionsItemSelected(item)
        }
    }
}
