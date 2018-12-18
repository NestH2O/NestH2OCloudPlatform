package com.nesth2o.watersystem.util

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.nesth2o.watersystem.R

class CarouselItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    val tvItem: TextView? = itemView?.findViewById(R.id.tv_item)
}