package com.example.charactercreatortest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.charactercreatortest.databinding.ActivityCharacterSheetBinding
import com.google.android.material.snackbar.Snackbar
import java.io.File
import java.io.InputStream

class CharacterSheet : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCharacterSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_sheet)

        val backButton: ImageButton = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            val i = Intent(this, Title::class.java)
            startActivity(i)
        }

        //Load button for saving a created character to your phone
        val loadButton: Button = findViewById(R.id.load_char)

        loadButton.setOnClickListener {
            val toast = Toast.makeText(this, "Character Loaded!", Toast.LENGTH_SHORT)
            toast.show()
            val fileName: TextView = findViewById(R.id.NameText)
            val file:String  = "/data/data/com.example.charactercreatortest/files/" + fileName.getText().toString() + ".txt"


            val inputStream: InputStream = File(file).inputStream()
            val lineList = mutableListOf<String>()

            inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }

            val charBox: TextView = findViewById(R.id.notes)
            val charBox2: TextView = findViewById(R.id.notes2)
            val charBox3: TextView = findViewById(R.id.notes3)
            val charBox4: TextView = findViewById(R.id.notes4)
            val charBox5: TextView = findViewById(R.id.notes5)
            val charBox6: TextView = findViewById(R.id.notes6)
            val charBox7: TextView = findViewById(R.id.notes7)
            val charBox8: TextView = findViewById(R.id.notes8)
            val charBox9: TextView = findViewById(R.id.notes9)
            val charBox10: TextView = findViewById(R.id.notes10)

            charBox.setText(lineList[0] + "\n")
            charBox2.setText(lineList[1] + "\n")
            charBox3.setText(lineList[2] + "\n")
            charBox4.setText(lineList[3] + "\n")
            charBox5.setText("Strength: " + lineList[4] + "\n")
            charBox6.setText("Dexterity: " + lineList[5] + "\n")
            charBox7.setText("Constitution: " + lineList[6] + "\n")
            charBox8.setText("Intelligence: " + lineList[7] + "\n")
            charBox9.setText("Wisdom: " + lineList[8] + "\n")
            charBox10.setText("Charisma: " + lineList[9] + "\n")
        }

    }
}