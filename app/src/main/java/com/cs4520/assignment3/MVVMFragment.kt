package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.data.Operation
import com.cs4520.assignment3.databinding.FragmentCalculatorBinding
import com.cs4520.assignment3.viewmodel.MVVMViewModel
import java.lang.NumberFormatException

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

        viewModel!!.result.observe(viewLifecycleOwner, Observer {
            binding.calcResult.text = "Result: $it"
        })

        binding.addBtn.setOnClickListener {
            try {
                viewModel!!.updateResult(Operation.ADD,
                    binding.num1Input.text.toString(), binding.num2Input.text.toString())
            } catch (e: Exception) {
                showToast(e)
            }
            clearInputs()
        }

        binding.subBtn.setOnClickListener {
            try {
                viewModel!!.updateResult(Operation.SUB,
                    binding.num1Input.text.toString(), binding.num2Input.text.toString())
            } catch (e: Exception) {
                showToast(e)
            }
            clearInputs()
        }

        binding.mulBtn.setOnClickListener {
            try {
                viewModel!!.updateResult(Operation.MUL,
                    binding.num1Input.text.toString(), binding.num2Input.text.toString())
            } catch (e: Exception) {
                showToast(e)
            }
            clearInputs()
        }

        binding.divBtn.setOnClickListener {
            try {
                viewModel!!.updateResult(Operation.DIV,
                    binding.num1Input.text.toString(), binding.num2Input.text.toString())
            } catch (e: Exception) {
                showToast(e)
            }
            clearInputs()
        }
    }

    private fun showToast(e: Exception) {
        if (e is NumberFormatException) {
            Toast.makeText(this.context,
                "Invalid input. Try again.",
                Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this.context, e.message, Toast.LENGTH_SHORT).show()
        }
    }


    private fun clearInputs() {
        binding.num1Input.text.clear()
        binding.num2Input.text.clear()
    }


}