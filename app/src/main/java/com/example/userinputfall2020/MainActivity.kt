package com.example.userinputfall2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var tipPercentage = ""
    var totalBefore = 00.00
    var theTip: Double = 00.00
    var grandTotal: Double = 00.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById(R.id.idUserInput)
        val group: Spinner = findViewById(R.id.idSpinnerGroup)
        val calculate: Button = findViewById(R.id.idButton)
        val result: TextView = findViewById(R.id.idResult)

        fun formatTip(percent:String): Double{
            if(percent == "5%"){
                percent.toDouble()
                return .05}
            if(percent == "10%"){
                percent.toDouble()
                return .10}
            if(percent == "15%"){
                percent.toDouble()
                return .15}
            if(percent == "20%"){
                percent.toDouble()
                return .20}
            if(percent == "25%"){
                percent.toDouble()
                return .25}
            return percent.toDouble()}

        calculate.setOnClickListener {
            totalBefore = userInput.text.toString().toDouble()
            tipPercentage = group.selectedItem.toString()
            formatTip(tipPercentage)
            theTip = (totalBefore * tipPercentage.toDouble())
            val currency = DecimalFormat("$###,###.00")
            grandTotal = (theTip + totalBefore)
            val grandTotalFormatted = currency.format(grandTotal)
            result.text = "$theTip is your tip at $tipPercentage, making $grandTotalFormatted your grand total"
        }
    }
}
