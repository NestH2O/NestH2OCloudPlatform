package com.nesth2o.watersystem.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nesth2o.watersystem.R

/**
 * Created by nbtk on 5/4/18.
 */
class CarouselAdapter : RecyclerView.Adapter<CarouselItemViewHolder>() {

    private val data: ArrayList<String> = ArrayList();
    var callback: Callback? = null
    val clickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            v?.let { callback?.onItemClicked(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_carousel_output, parent, false)

        itemView.setOnClickListener(clickListener)

        val horizontalViewHolder = CarouselItemViewHolder(itemView)
        return horizontalViewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        holder.tvItem?.text = data[position]
    }

    fun setData(data: ArrayList<String>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    interface Callback {
        fun onItemClicked(view: View)
    }
}