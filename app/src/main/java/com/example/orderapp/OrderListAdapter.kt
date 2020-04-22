package com.example.orderapp

import android.app.Person
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class OrderListAdapter(private var list: MutableList<Order>, private val clickListener: (String) -> Unit)
    : RecyclerView.Adapter<OrderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        val inflater = LayoutInflater.from(parent.context)
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val view = inflater.inflate(R.layout.item, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(list[position], clickListener)
    }

    fun updateOrders(orders:MutableList<Order>) {
     list.clear()
        list = orders
        // to refresh the ui
        notifyDataSetChanged()
    }

}


