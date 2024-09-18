package com.isadoralopes.bmicalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private  lateinit var textWeight: TextView
    private  lateinit var textHeight: TextView
    private  lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textWeight = findViewById(R.id.text_weight)
        textHeight = findViewById(R.id.text_height)
        textResult = findViewById(R.id.text_result)

        val bundle = intent.extras

        if ( bundle != null ) {

            val weight = bundle.getDouble("weight")
            val height = bundle.getDouble("height")

            textWeight.text = "Reported weight: $weight kg"
            textHeight.text = "Reported height: $height m"

            val bmi = weight / ( height * height )

            val result = if ( bmi < 18.5 ) {
                "Low"
            } else if (bmi in 18.5..24.9) {
               "Normal"
            } else if (bmi in 25.0..29.9) {
               "Overweight"
            } else {
               "Obese"
            }

            textResult.text = result
        }
    }
}