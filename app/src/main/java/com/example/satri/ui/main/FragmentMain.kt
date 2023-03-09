package com.example.satri.ui.main

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.satri.R
import com.example.satri.databinding.FragmentMainBinding
import com.example.satri.ui.main.rv_category.AdaptersCategory
import com.example.satri.ui.main.rv_latest.AdaptersLatest
import com.example.satri.ui.main.rv_sale.AdaptersSale
import com.example.satri.utils.ViewBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class FragmentMain : ViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    companion object {
        fun newInstance() = FragmentMain()
    }

    private val viewModel: MainViewModel by viewModel(named("main_view_model"))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainHeadText()
        category()
        latest()
        sale()
    }

    private fun category() {
        var adaptersCategory = AdaptersCategory()
        viewModel.onShowListCategory()
        viewModel.category.observe(viewLifecycleOwner) {
            adaptersCategory.setData(it)
        }
        binding.rvCategory.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = adaptersCategory
    }

    private fun latest() {
        var adaptersLatest = AdaptersLatest()
        viewModel.getAll()
        viewModel.latest.observe(viewLifecycleOwner) {
            adaptersLatest.setData(it.latest)
        }
        binding.rvLatest.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvLatest.adapter = adaptersLatest
        progressBar()
        sale()
    }

    private fun sale() {
        var adaptersSale = AdaptersSale()
        viewModel.sale.observe(viewLifecycleOwner) {
            adaptersSale.setData(it.flash_sale)
        }
        binding.rvSale.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvSale.adapter = adaptersSale
    }

    private fun progressBar() {
        viewModel.inProgress.observe(viewLifecycleOwner) { inProgress ->
            binding.tvLatest.isVisible = !inProgress
            binding.tvViewAllLatest.isVisible = !inProgress
            binding.rvLatest.isVisible = !inProgress
            binding.tvFlashSale.isVisible = !inProgress
            binding.tvViewAllSale.isVisible = !inProgress
            binding.rvSale.isVisible = !inProgress
            binding.progressBar.isVisible = inProgress
        }
    }

    private fun mainHeadText() {
        var mainText = binding.tvTradeByBata.text
        val spannableStringBuilder = SpannableStringBuilder(mainText)
        val black = ForegroundColorSpan(Color.BLACK)
        val blue = ForegroundColorSpan(resources.getColor(R.color.blue_main_text))

        spannableStringBuilder.setSpan(black, 0, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(blue, 9, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvTradeByBata.text = spannableStringBuilder
    }
}