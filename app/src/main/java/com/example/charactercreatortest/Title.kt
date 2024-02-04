package com.example.charactercreatortest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.charactercreatortest.databinding.ActivityTitleBinding


class Title : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTitleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val creatorMenuButton: Button = findViewById(R.id.characterCreator)

        creatorMenuButton.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        val characterMenuButton: Button = findViewById(R.id.characterSheet)

        characterMenuButton.setOnClickListener {
            val i = Intent(this, CharacterSheet::class.java)
            startActivity(i)
        }

        val diceMenuButton: Button = findViewById(R.id.diceRoller)
        diceMenuButton.setOnClickListener {
            val i = Intent(this, DiceRoller::class.java)
            startActivity(i)
        }
    }
}