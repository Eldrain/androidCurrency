package ru.artnnv.bsktask.data

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import ru.artnnv.bsktask.R
import ru.artnnv.bsktask.data.CurrencyList.ROUBLE
import ru.artnnv.bsktask.data.framework.Currency

/**
 * Author: Artem Novikov
 * Date: 20.12.2018
 * Module name: RoubleCurrency
 * Description: Rouble Currency
 */

class RoubleCurrency(value : Int) : Currency() {

    init {
        super.value = value
    }

    override fun fillData(viewHolder: RecyclerView.ViewHolder) {
        val holder = viewHolder as RoubleHolder
        holder.textValue.setText("$value")
    }

    override fun getType(): Int {
        return ROUBLE
    }

    class RoubleHolder(view : View)
        : RecyclerView.ViewHolder(view) {
        val textValue = view.findViewById<TextView>(R.id.currencyRoubleItemValue)
    }


}