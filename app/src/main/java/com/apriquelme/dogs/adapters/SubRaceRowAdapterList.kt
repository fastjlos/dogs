package com.apriquelme.dogs.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.apriquelme.dogs.R
import com.apriquelme.dogs.databinding.RowSubRaceBinding

class SubRaceRowAdapterList: RecyclerView.Adapter<SubRaceRowAdapterList.ViewHolder>() {

    private var race: String = ""
    private var listData: MutableList<String> = ArrayList()
    private lateinit var layoutInflater: LayoutInflater

    fun adapterList(race: String, listData: MutableList<String>, context: Context){
        this.race = race
        this.listData = listData
        this.layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(this.layoutInflater.inflate(R.layout.row_sub_race, parent, false))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listData[position]
        val itemView = holder.itemView
        holder.bind(item, position)

        itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("race", race)
            holder.itemView.findNavController().navigate(R.id.action_next, bundle)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RowSubRaceBinding.bind(view)

        fun bind(item: String, position: Int){
            binding.tvName.text = "-> $item"
        }

    }
}