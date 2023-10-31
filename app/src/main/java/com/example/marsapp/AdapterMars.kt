package com.example.marsapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marsapp.api.MarsProperty
import com.example.marsapp.databinding.ItemLayoutBinding


class AdapterMars (private val context: Context): RecyclerView.Adapter<AdapterMars.MarsViewHolder>(){
    private var marsData = emptyList<MarsProperty>()

    inner class MarsViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        val layout =  ItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MarsViewHolder(layout)
    }


    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val current = marsData[position]

       // Log.d("DATA", current.img_src)
        Glide.with(context)
       .load(current.img_src)
       .into(holder.binding.ivImage)
        holder.binding.ivDescription.text = current.type
        holder.binding.ivTittle.text = current.price.toString()
    }

    override fun getItemCount(): Int {
        return  marsData.size
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setData (mars: List<MarsProperty>){
        this.marsData = mars
        notifyDataSetChanged()
    }
}
















