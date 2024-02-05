package com.example.charactercreatortest

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.charactercreatortest.databinding.ActivityDiceRollerBinding
import com.google.android.material.snackbar.Snackbar

class DiceRoller : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDiceRollerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)
        //Number Rolled from dice
        val DiceRolledNumber: TextView = findViewById(R.id.DiceRolled);

        //D4 Dice roll button
        val D4DiceButton: ImageButton = findViewById(R.id.D4Dice);
        D4DiceButton.setOnClickListener{
            val rand = (1..4).random()
            DiceRolledNumber.setText(rand.toString());
        }

        //D6 Dice roll button
        val D6DiceButton: ImageButton = findViewById(R.id.D6Dice);
        D6DiceButton.setOnClickListener{
            val rand = (1..6).random()
            DiceRolledNumber.setText(rand.toString());
        }
        //D8 Dice roll button
        val D8DiceButton: ImageButton = findViewById(R.id.D8Dice);
        D8DiceButton.setOnClickListener{
            val rand = (1..8).random()
            DiceRolledNumber.setText(rand.toString());
        }

        //D10 Dice roll button
        val D10DiceButton: ImageButton = findViewById(R.id.D10Dice);
        D10DiceButton.setOnClickListener{
            val rand = (1..10).random()
            DiceRolledNumber.setText(rand.toString());
        }

        //D10 Percentile Dice roll button
        val D10PercentDiceButton: ImageButton = findViewById(R.id.D10PercentDice);
        D10PercentDiceButton.setOnClickListener{
            val rand = (1..10).random() * 10
            DiceRolledNumber.setText(rand.toString());
        }

        //D12 Dice roll button
        val D12DiceButton: ImageButton = findViewById(R.id.D12Dice);
        D12DiceButton.setOnClickListener{
            val rand = (1..12).random()
            DiceRolledNumber.setText(rand.toString());
        }

        //D20 Dice roll button
        val D20DiceButton: ImageButton = findViewById(R.id.D20Dice);
        D20DiceButton.setOnClickListener{
            val rand = (1..20).random()
            DiceRolledNumber.setText(rand.toString());
        }

        //Back Button to return to the title screen
        val backButton: ImageButton = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            val i = Intent(this, Title::class.java)
            //val i = Intent(this, CharacterSheet::class.java)
            startActivity(i)
        }
        class DiceRoll(private val numSides: Int) {
            fun roll(): Int {
                return (1..numSides).random()
            }
        }


    }


}