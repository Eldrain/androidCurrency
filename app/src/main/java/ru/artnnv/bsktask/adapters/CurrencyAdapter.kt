package ru.artnnv.bsktask.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.artnnv.bsktask.R
import ru.artnnv.bsktask.data.framework.CurrencyItem
import ru.artnnv.bsktask.data.CurrencyList.EURO
import ru.artnnv.bsktask.data.CurrencyList.ROUBLE
import ru.artnnv.bsktask.data.CurrencyList.USD
import ru.artnnv.bsktask.data.EuroCurrency
import ru.artnnv.bsktask.data.RoubleCurrency
import ru.artnnv.bsktask.data.UsdCurrency

/**
 * Author: Artem Novikov
 * Date: 20.12.2018
 * Module name: CurrencyAdapter
 * Description: Recycler View CurrencyAdapter
 */
class CurrencyAdapter(val mList: MutableList<CurrencyItem>, context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mInflater = LayoutInflater.from(context)

    init {
        mList.sortBy { item: CurrencyItem ->
            run {
                return@run item.getType()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int)
            : RecyclerView.ViewHolder {
        return createCurrencyHolder(itemType)
    }

    override fun getItemViewType(position: Int): Int {
        return mList[position].getType()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        mList[pos].fillData(holder)
    }

    /**
     * Creates specific currency holder by type
     */
    private fun createCurrencyHolder(type : Int) : RecyclerView.ViewHolder {
        var holder: RecyclerView.ViewHolder? = null

        when (type) {
            ROUBLE -> {
                holder = RoubleCurrency.RoubleHolder(
                    mInflater.inflate(R.layout.currency_rouble_item, null)
                )
            }
            USD -> {
                holder = UsdCurrency.UsdHolder(
                    mInflater.inflate(R.layout.currency_usd_item, null)
                )
            }
            EURO -> {
                holder = EuroCurrency.EuroHolder(
                    mInflater.inflate(R.layout.currency_euro_item, null)
                )
            }
        }
        return holder!!
    }
}