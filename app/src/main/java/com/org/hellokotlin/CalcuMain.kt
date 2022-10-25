package com.org.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calcu_main.*
import kotlin.math.pow

class CalcuMain : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_calcu_main)


        calculateButton.setOnClickListener{
            validate(binaryInputUser.text.toString())
        }



    }

    private fun validate(userNumber: String) {

            octalCalculator(userNumber.toLong())
            decimalCalculator(userNumber.toLong())
            hexCalculator(userNumber.toLong())

    }

    private fun octalCalculator(binaryInputUser: Long) {

        var userNumber = binaryInputUser
        var octalNumber = 0
        var decimalNumber = 0
        var i = 0

        while (userNumber.toInt() != 0) {
            decimalNumber += (userNumber % 10 * 2.0.pow(i.toDouble())).toInt()
            ++i
            userNumber /= 10
        }

        i = 1

        while (decimalNumber != 0){
            octalNumber += decimalNumber %8 * i
            decimalNumber /= 8
            i *= 10
        }

        octalResult.text = octalNumber.toString()
    }

    private fun decimalCalculator(binaryInputUser: Long) {

        var userNumber = binaryInputUser
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (userNumber.toInt() != 0) {
            remainder = userNumber % 10
            userNumber /= 10
            decimalNumber += (remainder * 2.0.pow(i.toDouble())).toInt()
            ++i
        }

        decimalResult.text = decimalNumber.toString()
    }

    private fun hexCalculator(userNumber: Long) {



    }



}