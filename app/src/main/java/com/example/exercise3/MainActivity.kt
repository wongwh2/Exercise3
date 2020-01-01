package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{ calculateInsurance() }
        buttonReset.setOnClickListener{ reset() }
    }

    private fun calculateInsurance(){
        val age:Int = spinnerAge.selectedItemPosition
        val btnGender: RadioButton = findViewById(radioGroupGender.checkedRadioButtonId)
        val smoker:Boolean = checkBoxSmoker.isChecked
        var total:Int = 0;

        when(age){
            0 -> total += 60
            1 -> total += 70
            2 -> total += 90
            3 -> total += 120
            4,5 -> total += 150
        }
        if(btnGender.text == "Male"){
            when(age){
                1 -> total += 50
                2 -> total += 100
                3 -> total += 150
                4,5 -> total += 200
            }
        }
        if(smoker){
            when(age){
                1 -> total += 100
                2 -> total += 150
                3 -> total += 200
                4 -> total += 250
                5 -> total += 300
            }
        }

        textViewPremium.text =  String.format("%s RM%d",
            resources.getString(R.string.insurance_premium),total)
    }
    private fun reset(){
        spinnerAge.setSelection(0)
        radioButtonMale.isChecked = true
        checkBoxSmoker.isChecked = false
        textViewPremium.text =  String.format("%s",
            resources.getString(R.string.insurance_premium))
    }
}
