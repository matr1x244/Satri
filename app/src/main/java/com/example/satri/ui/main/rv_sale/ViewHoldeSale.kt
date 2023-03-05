package com.example.satri.ui.main.rv_sale

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.satri.databinding.RvItemSaleBinding
import com.example.satri.domain.sale.models.FlashSale

class ViewHoldeSale(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = RvItemSaleBinding.bind(itemView)

    fun bind(item: FlashSale) {
        Glide.with(binding.ivSale)
            .load(item.image_url)
            .centerCrop()
            .into(binding.ivSale)

        binding.tvCategory.text = item.category
        binding.tvName.text = item.name
        binding.tvPrice.text = "$ ${item.price}"
        binding.tvDiscount.text = "${item.discount}% off"
    }
}