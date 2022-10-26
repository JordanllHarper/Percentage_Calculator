package uk.ac.chester.percentagecalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import uk.ac.chester.percentagecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)








        binding.convertButton.setOnClickListener {
            val percentage = binding.percentageField.text.toString()
            val value = binding.valueField.text.toString()
            Log.d("debug", percentage)
            Log.d("debug", value)

            startActivity(
                Intent(this, AnswerActivity::class.java)
                .putExtra("percentage", percentage)
                .putExtra("value", value))
        }






    }
}