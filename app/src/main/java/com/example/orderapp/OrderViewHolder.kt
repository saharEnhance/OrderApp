package com.example.orderapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_order.view.*

class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(order: Order, clickListener: (String) -> Unit) {
        itemView.clientTxt.text = order.client
        itemView.dishTxt.text = order.dish
        itemView.setOnClickListener { order.toString()?.let { it1 -> clickListener(it1) } }
    }

}