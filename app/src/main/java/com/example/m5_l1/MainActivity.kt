package com.example.m5_l1

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.m5_l1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private val presenter = CounterPresenter()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachView(this)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.increment()
            }
            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showResult(result: Int) {
        binding.tvResult.text = result.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun greenText(isGreen: Boolean) {
        if (isGreen) {
            binding.tvResult.setTextColor(Color.GREEN)
        } else{
            binding.tvResult.setTextColor(Color.BLACK)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
