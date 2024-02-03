package com.example.charactercreatortest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.charactercreatortest.databinding.ActivityCharacterSheetBinding
import com.google.android.material.snackbar.Snackbar

class CharacterSheet : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCharacterSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}