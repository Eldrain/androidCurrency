package ru.artnnv.bsktask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import ru.artnnv.bsktask.adapters.CurrencyAdapter
import ru.artnnv.bsktask.data.CurrencyList.COUNT
import ru.artnnv.bsktask.data.CurrencyList.EURO
import ru.artnnv.bsktask.data.CurrencyList.ROUBLE
import ru.artnnv.bsktask.data.CurrencyList.USD
import ru.artnnv.bsktask.data.EuroCurrency
import ru.artnnv.bsktask.data.RoubleCurrency
import ru.artnnv.bsktask.data.UsdCurrency
import ru.artnnv.bsktask.data.framework.CurrencyItem
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val ITEM_COUNT = 30
    val SUM_BOUND = 1000000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.mainRecyclerView).adapter =
                CurrencyAdapter(getData(ITEM_COUNT), this)
    }

    private fun getData(count : Int) : MutableList<CurrencyItem> {
        var list = ArrayList<CurrencyItem>()

        for(i in 0..count) {
            var item : CurrencyItem? = null
            val value = Random.nextInt(0, SUM_BOUND + 1)
            when(i % COUNT) {
                ROUBLE -> {
                    item = RoubleCurrency(value)
                }
                USD -> {
                    item = UsdCurrency(value)
                }
                EURO -> {
                    item = EuroCurrency(value)
                }
            }
            list.add(item!!)
        }
        return list
    }
}
