package com.example.satri.ui.main.rv_category

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.satri.R
import com.example.satri.domain.category.Category

class AdaptersCategory() : RecyclerView.Adapter<ViewHolderCategory>() {

    private var localListData: MutableList<Category> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Category>) {
        localListData.clear()
        localListData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategory {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item_category, parent, false)
        return ViewHolderCategory(view)
    }

    override fun onBindViewHolder(holder: ViewHolderCategory, position: Int) {
        holder.bind(localListData[position])
    }


    override fun getItemCount(): Int {
        return localListData.size
    }

}
