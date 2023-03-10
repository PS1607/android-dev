package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //Do a device roll when the app starts, so that user knows what's happening
        rollDice()

    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        // Update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        when (diceRoll){
            1-> diceImage.setImageResource(R.drawable.dice_1)
            2-> diceImage.setImageResource(R.drawable.dice_2)
            3-> diceImage.setImageResource(R.drawable.dice_3)
            4-> diceImage.setImageResource(R.drawable.dice_4)
            5-> diceImage.setImageResource(R.drawable.dice_5)
            6-> diceImage.setImageResource(R.drawable.dice_6)
        }

        val diceImage2: ImageView = findViewById(R.id.imageView2)
        when (diceRoll2){
            1-> diceImage2.setImageResource(R.drawable.dice_1)
            2-> diceImage2.setImageResource(R.drawable.dice_2)
            3-> diceImage2.setImageResource(R.drawable.dice_3)
            4-> diceImage2.setImageResource(R.drawable.dice_4)
            5-> diceImage2.setImageResource(R.drawable.dice_5)
            6-> diceImage2.setImageResource(R.drawable.dice_6)
        }
        // Updating the image description for screen readers
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()

        // Display Text for a while when button is clicked
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        toast.show()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}