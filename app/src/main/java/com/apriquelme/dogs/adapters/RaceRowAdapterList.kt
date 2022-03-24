package com.apriquelme.dogs.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apriquelme.dogs.R
import com.apriquelme.dogs.data.models.RaceDataModel
import com.apriquelme.dogs.databinding.RowRaceBinding

class RaceRowAdapterList: RecyclerView.Adapter<RaceRowAdapterList.ViewHolder>() {

    private var listData: MutableList<RaceDataModel> = ArrayList()
    private lateinit var layoutInflater: LayoutInflater

    fun adapterList(listData: MutableList<RaceDataModel>, context: Context){
        this.listData = listData
        this.layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(this.layoutInflater.inflate(R.layout.row_race, parent, false))
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
            bundle.putString("race", item.name)
            holder.itemView.findNavController().navigate(R.id.action_next, bundle)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val context = view.context
        private val binding = RowRaceBinding.bind(view)

        fun bind(item: RaceDataModel, position: Int){
            binding.tvName.text = "Raza: ${item.name}"

            val adapter: SubRaceRowAdapterList = SubRaceRowAdapterList()
            adapter.adapterList(
                item.name,
                item.subRaceList,
                context = context,
            )
            binding.lvData.layoutManager = LinearLayoutManager(context)
            binding.lvData.adapter = adapter

        }

    }
}