package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.data.Operation
import com.cs4520.assignment3.databinding.FragmentCalculatorBinding
import com.cs4520.assignment3.viewmodel.MVVMViewModel

class MVVMFragment : Fragment() {
    private var _binding: FragmentCalculatorBinding? = null

    private val binding get() = _binding!!
    private var viewModel: MVVMViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(resources.getColor(R.color.mvvm_background))

        viewModel = ViewModelProvider(this)[MVVMViewModel::class.java]

        binding.viewModel
        binding.addBtn.setOnClickListener {
            val res = viewModel!!.getResult(Operation.ADD)
            binding.calcResult.text = "Result: ${res}"
        }


    }


}