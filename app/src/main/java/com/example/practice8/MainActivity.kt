package com.example.practice8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val languages = resources.getStringArray(R.array.languages_array)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            languages
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        getSolution.setOnClickListener {
            if (sideA.text.toString().matches(Regex("\\d+")) &&
                sideB.text.toString().matches(Regex("\\d+")) &&
                sideC.text.toString().matches(Regex("\\d+"))) {
                when (spinner.selectedItemPosition) {
                    0 -> solution.setText(
                        (4 * (sideA.text.toString().toInt() +
                                sideB.text.toString().toInt() + sideC.text.toString().toInt()))
                            .toString()
                    )
                    1 -> solution.setText(
                        (2 * (sideA.text.toString().toInt() * sideB.text.toString().toInt() +
                                sideA.text.toString().toInt() * sideC.text.toString().toInt() +
                                sideB.text.toString().toInt() * sideC.text.toString().toInt()))
                            .toString()
                    )
                    2 -> solution.setText(
                        (sideA.text.toString().toInt() *
                                sideB.text.toString().toInt() * sideC.text.toString().toInt())
                            .toString()
                    )
                }
            } else
                solution.setText("Ошибка ввода")
        }
    }
}