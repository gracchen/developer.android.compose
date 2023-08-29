package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() { //menu bar across all platforms so inherit that (part of jetpack)

    lateinit var diceImage: ImageView //lateinit: I promise it won't be null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //what to draw, cannot initialize member var yet
        val rollButton: Button = findViewById(R.id.roll_button)
        //rollButton.text = "Let's Roll!"
        rollButton.setOnClickListener{
            //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        //val resultText: TextView = findViewById(R.id.result_text)

        val randomInt = Random().nextInt(6) + 1

        //val diceImage: ImageView = findViewById(R.id.dice_image) local var keep call findId slow
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        //resultText.text = randomInt.toString()
    }
}