package com.example.androidsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.math.round
import com.example.androidsample.databinding.ActivityMainBinding
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView((binding.root))
    }
    fun convertCurrency(view: View) {
        if(binding.dollarText.text.isNotEmpty()) {
            val dollarValue = binding.dollarText.text.toString().toFloat()
            binding.error.text = " The possible tips on a $" + dollarValue + " bill are"
            val twentBill = (dollarValue * 0.20)
            val twentRound:Double = String.format("%.2f", twentBill).toDouble()
            binding.textView.text = "20 % is $ " + twentRound.toString()
            val fifteenBill = (dollarValue * 0.15)
            val fifteenRound:Double = String.format("%.2f", fifteenBill).toDouble()
            binding.dollarText15.text = "15% is $ " + fifteenRound.toString()
            val tenBill = (dollarValue * 0.10)
            val tenRound:Double = String.format("%.2f", tenBill).toDouble()
            binding.dollarText10.text = "10% is $ " + tenRound.toString()
        }
        else {
            binding.error.text = getString(R.string.no_value_string)
        }
    }
}