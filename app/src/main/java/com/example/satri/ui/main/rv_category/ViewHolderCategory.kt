package com.example.satri.ui.main.rv_category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.satri.R
import com.example.satri.databinding.RvItemCategoryBinding
import com.example.satri.domain.category.Category

class ViewHolderCategory(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = RvItemCategoryBinding.bind(itemView)

    fun bind(item: Category) {
        Glide.with(binding.ivCategory)
            .load(item.imageCategory)
            .into(binding.ivCategory)

        binding.tvCategory.text = item.nameCategory
    }

}