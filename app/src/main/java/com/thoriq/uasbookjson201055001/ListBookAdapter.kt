package com.thoriq.uasbookjson201055001

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*

class ListBookAdapter(ctx: Context, private val listBook: ArrayList<Book>): RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        var tvAuthor: TextView = itemView.findViewById(R.id.tv_item_author)
        var tvPage: TextView = itemView.findViewById(R.id.tv_item_page)
    }

    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(ctx)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_json, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.tvTitle.text = listBook[position].title
        holder.tvAuthor.text = listBook[position].author
        holder.tvPage.text = listBook[position].page
    }

    override fun getItemCount(): Int = listBook.size

}