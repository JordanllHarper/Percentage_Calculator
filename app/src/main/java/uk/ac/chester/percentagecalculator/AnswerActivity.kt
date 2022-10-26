package uk.ac.chester.percentagecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import uk.ac.chester.percentagecalculator.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAnswerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val percent = intent.extras?.get("percentage").toString()

        val value = intent.extras?.get("value").toString()

        binding.valuesInputted.text = "$percent% of $value is"


        binding.answerText.text = if (valuesValid(percent, value)) {
            PercentageCalculator().findValueOf(percent.toDouble(), value.toDouble()).toString()
        } else {
            "Invalid values, please try again!"
        }

        binding.backButton.setOnClickListener {
            finish()
        }


    }


    fun valuesValid(percent: String, value: String): Boolean {
        return try {
            percent.toDouble()
            value.toDouble()
            true
        } catch (e: java.lang.NumberFormatException) {
            false
        }

    }
}