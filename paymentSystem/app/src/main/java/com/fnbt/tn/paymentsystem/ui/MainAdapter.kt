package com.fnbt.tn.paymentsystem.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.fnbt.tn.paymentsystem.R
import kotlinx.android.synthetic.main.cell_main.view.*

class MainAdapter(private val data: Array<String>,
                  private val listener: OnMainItemClick)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_main, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
                .load(data[position])//array of links to pic
                .into(holder.itemView.image)
        holder.itemView.setOnClickListener {
            listener.onMainItemClickListener(position)
        }
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v)

    interface OnMainItemClick {
        fun onMainItemClickListener(id: Int)
    }
}