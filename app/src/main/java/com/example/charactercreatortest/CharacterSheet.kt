package com.example.charactercreatortest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.charactercreatortest.databinding.ActivityCharacterSheetBinding

class CharacterSheet : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCharacterSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonClick = findViewById<Button>(R.id.more_info_cs)
        buttonClick.setOnClickListener {
            val intent = Intent(this, character_sheet_2::class.java)
            startActivity(intent) }

        val buttonClick2 = findViewById<Button>(R.id.back_cs)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_character_sheet)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}