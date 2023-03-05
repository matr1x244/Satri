package com.example.satri.data.local

import com.example.satri.R
import com.example.satri.domain.category.Category
import com.example.satri.domain.category.RepositoryCategory

class LocalCategory : RepositoryCategory {

    override fun getListCategory(): List<Category> {
        return listOf(
            Category(0, R.drawable.iv_ct_phone, "Phones"),
            Category(1, R.drawable.iv_ct_headphones, "Headphones"),
            Category(2, R.drawable.iv_ct_game, "Games"),
            Category(3, R.drawable.iv_ct_cars, "Cars"),
            Category(4, R.drawable.iv_ct_furniture, "Furniture"),
            Category(5, R.drawable.iv_ct_kids, "Kids")
        )
    }
}