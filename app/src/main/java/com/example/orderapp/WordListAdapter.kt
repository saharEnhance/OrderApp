package com.example.orderapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter(private var list: List<Order>, private val clickListener: (String) -> Unit)
    : RecyclerView.Adapter<WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        val inflater = LayoutInflater.from(parent.context)
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val view = inflater.inflate(R.layout.item, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(list[position], clickListener)
    }

 /*   fun updateWords(words: MutableList<Word>) {
        list.clear()
        list = words
        // to refresh the ui
        notifyDataSetChanged()
    }*/
    fun updatePeople(orders: List<Order>) {
       //list.clear()

        list = orders
        // to refresh the ui
        notifyDataSetChanged()
    }

}


