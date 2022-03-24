package com.apriquelme.dogs.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apriquelme.dogs.R
import com.apriquelme.dogs.databinding.RowImageBinding
import com.squareup.picasso.Picasso

class ImageRowAdapterList: RecyclerView.Adapter<ImageRowAdapterList.ViewHolder>() {

    private var listData: List<String> = emptyList()
    private lateinit var layoutInflater: LayoutInflater

    fun adapterList(listData: List<String>, context: Context){
        this.listData = listData
        this.layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            this.layoutInflater.inflate(
                R.layout.row_image,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listData[position]
        holder.bind(item, position)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RowImageBinding.bind(view)

        fun bind(item: String, position: Int){
            Picasso.get().load(item).into(binding.ivDog)
        }

    }

}