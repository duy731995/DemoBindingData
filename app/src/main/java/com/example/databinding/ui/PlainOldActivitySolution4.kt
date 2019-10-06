package com.example.databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.databinding.R
import com.example.databinding.data.SimpleViewModelSolution
import com.example.databinding.databinding.PlainActivitySolution4Binding

class PlainOldActivitySolution4 : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(SimpleViewModelSolution::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: PlainActivitySolution4Binding =
        DataBindingUtil.setContentView(R.layout.plain_activity_solution_4)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }
}
