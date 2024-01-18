package com.example.android_davaleba1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.android_davaleba1.databinding.MobileItemBinding

class MobilesAdapter : ListAdapter<Items.ItemModel, MobilesAdapter.ViewHolder>(AdapterDiffUtil()) {

    inner class ViewHolder(binding: MobileItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val manufacturer = binding.tvManufacturer
        val deviceName = binding.tvDeviceName
        val androidVersion = binding.tvAndroidVersion
        val cover = binding.ivItemImage

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        MobileItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        Glide.with(holder.cover.context).load(item.cover).into(holder.cover)
        holder.manufacturer.text = item.manufacturer
        holder.deviceName.text = item.deviceName
        holder.androidVersion.text = item.androidVersion

    }

    class AdapterDiffUtil() : DiffUtil.ItemCallback<Items.ItemModel>() {
        override fun areItemsTheSame(oldItem: Items.ItemModel, newItem: Items.ItemModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: Items.ItemModel,
            newItem: Items.ItemModel
        ): Boolean {
            return oldItem == newItem
        }
    }

}