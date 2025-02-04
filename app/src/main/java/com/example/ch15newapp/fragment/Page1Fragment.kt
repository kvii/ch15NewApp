package com.example.ch15newapp.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ch15newapp.R
import com.example.ch15newapp.viewmodel.CountVM

class Page1Fragment : Fragment(R.layout.fragment_page1) {
    private val count: CountVM by activityViewModels(factoryProducer = { CountVM.Factory })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        // 当前计数
        count.count.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.tv_count).text = getString(R.string.count, it)
        }
        // 添加计数
        view.findViewById<Button>(R.id.btn_add).setOnClickListener {
            count.increment()
        }
    }
}