package com.cs4520.assignment3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.data.Operation
import com.cs4520.assignment3.databinding.FragmentCalculatorBinding
import com.cs4520.assignment3.model.CalculatorModel

class MVPFragment : Fragment(), MVPContract.View {
    private var _binding: FragmentCalculatorBinding? = null

    private val binding get() = _binding!!
    private lateinit var presenter: CalculatorPresenter
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
        view.setBackgroundColor(resources.getColor(R.color.mvp_background))
        presenter = CalculatorPresenter(CalculatorModel(), this);

        binding.addBtn.setOnClickListener{
            Log.i("Add btn listener", "Clicked add button")
            presenter.onButtonClick(Operation.ADD,
                binding.num1Input.text.toString(), binding.num2Input.text.toString())
        }

        binding.subBtn.setOnClickListener{
            Log.i("Sub btn listener", "Clicked sub button")
            presenter.onButtonClick(Operation.SUB,
                binding.num1Input.text.toString(), binding.num2Input.text.toString())
        }

        binding.mulBtn.setOnClickListener{
            Log.i("Mul btn listener", "Clicked mul button")
            presenter.onButtonClick(Operation.MUL,
                binding.num1Input.text.toString(), binding.num2Input.text.toString())
        }

        binding.divBtn.setOnClickListener{
            Log.i("Div btn listener", "Clicked div button")
            presenter.onButtonClick(Operation.DIV,
                binding.num1Input.text.toString(), binding.num2Input.text.toString())
        }

    }

    override fun displayErrorMessage(msg: String) {
        Toast.makeText(this.context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun setResult(res: Number?) {
        binding.calcResult.text =
            if (res != null) "Result: $res" else ""
    }

    override fun clearInputFields() {
        binding.num1Input.text.clear()
        binding.num2Input.text.clear()
    }

}