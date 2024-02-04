package com.example.charactercreatortest

import android.os.Bundle
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
        //Number Rolled from dice
        val DiceRolledNumber: TextView = findViewById(R.id.DiceRolled);

        //D4 Dice roll button
        val D4DiceButton: ImageButton = findViewById(R.id.D4Dice);
        D4DiceButton.setOnClickListener{
            DiceRolledNumber.setText(Interger.toString(DiceRoll(4)));
        }

        //D6 Dice roll button
        val D6DiceButton: ImageButton = findViewById(R.id.D6Dice);
        D6DiceButton.setOnClickListner{
            DiceRolledNumber.setText(Interger.toString(DiceRoll(6)));
        }
        //D8 Dice roll button
        val D8DiceButton: ImageButton = findViewById(R.id.D8Dice);
        D8DiceButton.setOnClickListener{
            DiceRolledNumber.setText(Interger.toString(DiceRoll(8)));
        }

        //D10 Dice roll button
        val D10DiceButton: ImageButton = findViewById(R.id.D10Dice);
        D10DiceButton.setOnClickListener{
            DiceRolledNumber.setText(Interger.toString(DiceRoll(10)));
        }

        //D10 Percentile Dice roll button
        val D10PercentDiceButton: ImageButton = findViewById(R.id.D10PercentDice);
        D10PercentDiceButton.setOnClickListener{
            DiceRolledNumber.setText(Interger.toString(DiceRoll(10)*10));
        }

        //D12 Dice roll button
        val D12DiceButton: ImageButton = findViewById(R.id.D12Dice);
        D12DiceButton.setOnClickListener{
            DiceRolledNumber.setText(Interger.toString(DiceRoll(12)));
        }

        //D20 Dice roll button
        val D20DiceButton: ImageButton = findViewById(R.id.D20Dice);
        D20DiceButton.setOnClickListener{
            DiceRolledNumber.setText(Interger.toString(DiceRoll(20)));
        }
        class DiceRoll(private val numSides: Int) {

            fun roll(): Int {
                return (1..numSides).random()
            }
        }

        binding = ActivityDiceRollerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_dice_roller)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_dice_roller)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}