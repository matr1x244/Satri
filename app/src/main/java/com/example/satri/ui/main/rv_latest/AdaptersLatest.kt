package com.example.satri.ui.main.rv_latest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.satri.R
import com.example.satri.domain.lastest.models.Latest

class AdaptersLatest() : RecyclerView.Adapter<ViewHolderLatest>() {

    private var localListData: MutableList<Latest> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Latest>) {
        localListData.clear()
        localListData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLatest {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item_latest, parent, false)
        return ViewHolderLatest(view)
    }

    override fun onBindViewHolder(holder: ViewHolderLatest, position: Int) {
        holder.bind(localListData[position])
    }


    override fun getItemCount(): Int {
        return localListData.size
    }

}
