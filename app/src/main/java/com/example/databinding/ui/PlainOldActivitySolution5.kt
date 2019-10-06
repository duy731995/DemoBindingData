package com.example.databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.databinding.R
import com.example.databinding.data.SimpleViewModelSolution
import com.example.databinding.databinding.PlainActivitySolution5Binding

class PlainOldActivitySolution5 : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(SimpleViewModelSolution::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : PlainActivitySolution5Binding =
        DataBindingUtil.setContentView(R.layout.plain_activity_solution_5)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }
}
