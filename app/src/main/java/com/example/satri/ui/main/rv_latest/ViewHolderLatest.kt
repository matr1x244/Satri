package com.example.satri.ui.main.rv_latest

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.satri.databinding.RvItemLatestBinding
import com.example.satri.domain.lastest.models.Latest

class ViewHolderLatest(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = RvItemLatestBinding.bind(itemView)

    fun bind(item: Latest) {
        Glide.with(binding.ivLatest)
            .load(item.image_url)
            .centerCrop()
            .into(binding.ivLatest)

        binding.tvCategory.text = item.category
        binding.tvName.text = item.name
        binding.tvPrice.text = "$ ${item.price.toString()}"
    }

}