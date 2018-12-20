package ru.artnnv.bsktask.data.framework

import android.support.v7.widget.RecyclerView
/**
 * Author: Artem Novikov
 * Date: 20.12.2018
 * Module name: CurrencyItem
 * Description: Currency item for adapter
 */
interface CurrencyItem {

    fun fillData(viewHolder : RecyclerView.ViewHolder)

    fun getType() : Int

}