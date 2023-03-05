package com.example.satri.ui.main.rv_sale

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.satri.R
import com.example.satri.domain.lastest.models.Latest
import com.example.satri.domain.sale.models.FlashSale
import com.example.satri.domain.sale.models.Sale
import com.example.satri.ui.main.rv_latest.ViewHolderLatest

class AdaptersSale() : RecyclerView.Adapter<ViewHoldeSale>() {

    private var localListData: MutableList<FlashSale> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<FlashSale>) {
        localListData.clear()
        localListData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldeSale {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item_sale, parent, false)
        return ViewHoldeSale(view)
    }

    override fun onBindViewHolder(holder: ViewHoldeSale, position: Int) {
        holder.bind(localListData[position])
    }


    override fun getItemCount(): Int {
        return localListData.size
    }
}