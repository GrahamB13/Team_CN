package com.example.charactercreatortest

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


class MainActivity : AppCompatActivity() {

    private var races = arrayOf<String?>("Dragonborn", "Dwarf", "Elf", "Gnome", "Half -Elf", "Halfling", "Half-Orc", "Human", "Tiefling")
    private var classes = arrayOf<String?>("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin",
        "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard")
    private var alignment = arrayOf<String?>("Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral",
        "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil")
    private var playerLevel = arrayOf<String?>("Beginner", "Average", "Advanced")
    private var playerNames = arrayOf<String?>("Raya", "Onyx", "Inga", "Ender", "Electra", "Kodiak", "Polaris", "Cosmo", "Lotus", "Rigel", "Siara", "Lux",
            "Gemini", "Creed", "Isis", "Zephyr", "Xara", "Kano", "Lumina", "Xerxes", "Neo", "Skai", "Merlin", "Arcadia", "Wilder", "Luma", "Astro", "Vega",
            "Calxy", "Xoey", "Geo", "Atara", "Solaris", "Kodi", "Lynx", "Octavia", "Krew", "Enzo",
            "Eloise", "Sevyn", "Blaise", "Sasha", "Reya", "Reno", "Flynt", "Chyna", "Helios", "Calliope", "Blaze", "Alara", "Kai", "Saffire", "Jett", "Elektra",
            "Xeno", "Zenia", "Solar", "Zeta", "Xzander",
            "Bexley", "Zeno", "Freya", "Zeke", "Ember", "Felix", "Xiomara", "Loki", "Capri", "Sirius", "Vesper", "Pax", "Wisteria", "Lazar", "Wynter",
            "Ezekiel", "Kassius", "Nikita", "Cortez", "Araceli",
            "Raiden", "Zora", "Zayne", "Maya", "Kairo", "Sierra", "Ryu", "Athena", "Maverick", "Astoria", "Xion", "Siena", "Cato", "Stormi",
            "Zen", "Ekaterina", "Killian", "Astrid", "Axton", "Azura", "Xavior",
            "Skyla", "Dax", "Ripley", "Rex", "Venus", "Ryker", "Kira", "Ajax", "Signe", "Calixto", "Sora", "Keanu", "Sacha", "Zain", "Xenia", "Dante",
            "Xia", "Blade", "Zofia", "Zander", "Xiamara", "Ulysses", "Klara",
            "Phoenix", "Katara", "Blaise", "Kali", "Lynk", "Sia", "Jayceon", "Zia", "Helix", "Hawke", "Zelda", "Blayze", "Kylo", "Starla", "Genesis", "Delta",
            "Ryden", "Xena", "Klay", "Lexi", "Kaige", "Cisco",
            "Shyla", "Zenon", "Trinity", "Cyprian", "Valkyrie", "Acer", "Roxi", "Saber", "Elyse", "Kyo", "Solara", "Sirena", "Sixtus",
            "Saskia", "Loxo", "Cosmia", "Scipio", "Aeryn", "Condor", "Zhora",
            "Quatro", "Kitanna", "Scorpio", "Elaxa", "Xenon", "Sixta", "Loko", "Wylda", "Zio", "Zolton", "Calyxtra", "Sirocco", "Olexa", "Six", "Exton",
            "Zuzana", "Salix", "Lexxy", "Falco", "Santara", "Xannon", "Snoh", "Indio", "Azure", "Kannon", "Jimothy")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val popUpClose: ImageButton = findViewById(R.id.ClosePopUp)
        val popUpBox: TextView = findViewById(R.id.Popup)
        popUpClose.isVisible = false
        popUpBox.isVisible = false
        popUpBox.movementMethod = ScrollingMovementMethod()

        //the button for information about the different races
        val raceInfoButton: ImageButton = findViewById(R.id.RaceInfo)
        raceInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Race \n\n This is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goesThis is where the information about the races you can select goes")
        }

        //the button for information about the different classes
        val classInfoButton: ImageButton = findViewById(R.id.ClassInfo)
        classInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Classes \n\n This is where the information about the classes you can select goes")
        }

        //the button for information about the different classes
        val allignmentInfoButton: ImageButton = findViewById(R.id.AllignmentInfo)
        allignmentInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Allignment \n\n This is where the information about the allignments you can select goes")
        }

        //the button for information about the different skill leevls you can select
        val skillLevelInfoButton: ImageButton = findViewById(R.id.SkillLeveInfo)
        skillLevelInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Player Skill Level \n\n Beginner: Will role 6 d6 dice and choose the best 4 to assign to each stat \n\n" +
                    "Average: Will roll 4 d6 dice and choose the best 3 to assign to each stat\n\n" +
                    "Advanced: Will for 3 d6 dice and assign the values to each stat")
        }

        //the button for information about character strength
        val strengthInfoButton: ImageButton = findViewById(R.id.StrengthInfo)

        strengthInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Strength \n\n Measures your characters physical power")
        }

        //the button for information about character dexterity
        val dexInfoButton: ImageButton = findViewById(R.id.DexInfo)

        dexInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Dexteriry \n\n Measures your characters agility")
        }

        //the button for information about character constitution
        val constInfoButton: ImageButton = findViewById(R.id.ConstInfo)

        constInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Constitution \n\n Measures your characters endurance")
        }

        //the button for information about character intelligence
        val intInfoButton: ImageButton = findViewById(R.id.IntInfo)

        intInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Intelligence \n\n Measures your characters reasoning and memory")
        }

        //the button for information about character wisdom
        val wisdomInfoButton: ImageButton = findViewById(R.id.WisdomInfo)

        wisdomInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Wisdom \n\n Measures your characters perception and insight")
        }

        //the button for information about character charisma
        val charInfoButton: ImageButton = findViewById(R.id.CharInfo)

        charInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Charisma \n\n Measures the force of your characters personality")
        }


        //closes the popup window in the app
        popUpClose.setOnClickListener {
            popUpClose.isVisible = false
            popUpBox.isVisible = false
        }


        //Roll Button to randomize character stats
        val rollButton: Button = findViewById(R.id.rollStats)

        rollButton.setOnClickListener {
            rollStats()
        }

        //Back Button to return to the title screen
        val backButton: ImageButton = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            val i = Intent(this, Title::class.java)
            startActivity(i)
        }

        //Randomize the character
        val randomButton: ImageButton = findViewById(R.id.randomizeButton)

        randomButton.setOnClickListener {
            val nameBox: TextView = findViewById(R.id.NameText)
            val raceBox = findViewById<Spinner>(R.id.RaceSpinner)
            val classBox = findViewById<Spinner>(R.id.ClassSpinner)
            val alignmentBox = findViewById<Spinner>(R.id.AlignmentSpinner)
            val name1 = (1..playerNames.size).random()
            val name2 = (1..playerNames.size).random()
            val race = (1..races.size).random()
            val class1 = (1..classes.size).random()
            val allignment = (1..alignment.size).random()
            nameBox.setText(playerNames[name1 - 1] + " " + playerNames[name2 - 1])
            raceBox.setSelection(race - 1)
            classBox.setSelection(class1 - 1)
            alignmentBox.setSelection(allignment - 1)
            rollStats()
        }
        val randomNameButton: ImageButton = findViewById(R.id.randomizeNameButton)

        randomNameButton.setOnClickListener {
            val nameBox: TextView = findViewById(R.id.NameText)
            val name1 = (1..playerNames.size).random()
            val name2 = (1..playerNames.size).random()
            nameBox.setText(playerNames[name1 - 1] + " " + playerNames[name2 - 1])
        }


        //Save button for saving a created character to your phone
        val saveButton: Button = findViewById(R.id.save)

        saveButton.setOnClickListener {
            val toast = Toast.makeText(this, "Character Saved!", Toast.LENGTH_SHORT)
            toast.show()

            val nameBox: TextView = findViewById(R.id.NameText)
            val raceBox = findViewById<Spinner>(R.id.RaceSpinner)
            val classBox = findViewById<Spinner>(R.id.ClassSpinner)
            val alignmentBox = findViewById<Spinner>(R.id.AlignmentSpinner)
            val strengthBox: TextView = findViewById(R.id.StrRoll)
            val dexterityBox: TextView = findViewById(R.id.DexRoll)
            val constitutionBox: TextView = findViewById(R.id.ConRoll)
            val intelligenceBox: TextView = findViewById(R.id.IntRoll)
            val wisdomBox: TextView = findViewById(R.id.WisRoll)
            val charismaBox: TextView = findViewById(R.id.CharRoll)
            //val file:String = fileName
            val file:String = nameBox.getText().toString() + ".txt"
            val nameData:String = nameBox.getText().toString() + "\n"
            val raceData:String = raceBox.selectedItem.toString() + "\n"
            val classData:String = classBox.selectedItem.toString() + "\n"
            val alignmentData:String = alignmentBox.selectedItem.toString() + "\n"
            val strengthData:String = strengthBox.getText().toString() + "\n"
            val dexterityData:String = dexterityBox.getText().toString() + "\n"
            val constitutionData:String = constitutionBox.getText().toString() + "\n"
            val intelligenceData:String = intelligenceBox.getText().toString() + "\n"
            val wisdomData:String = wisdomBox.getText().toString() + "\n"
            val charismaData:String = charismaBox.getText().toString() + "\n"
            val fileOutputStream: FileOutputStream
            try {
                fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(nameData.toByteArray())
                fileOutputStream.write(raceData.toByteArray())
                fileOutputStream.write(classData.toByteArray())
                fileOutputStream.write(alignmentData.toByteArray())
                fileOutputStream.write(strengthData.toByteArray())
                fileOutputStream.write(dexterityData.toByteArray())
                fileOutputStream.write(constitutionData.toByteArray())
                fileOutputStream.write(intelligenceData.toByteArray())
                fileOutputStream.write(wisdomData.toByteArray())
                fileOutputStream.write(charismaData.toByteArray())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        //Load button for saving a created character to your phone
        val loadButton: Button = findViewById(R.id.load)

        loadButton.setOnClickListener {
            val toast = Toast.makeText(this, "Character Loaded!", Toast.LENGTH_SHORT)
            toast.show()
            val fileName: TextView = findViewById(R.id.NameText)
            val file:String  = "/data/data/com.example.charactercreatortest/files/" + fileName.getText().toString() + ".txt"
            var position = 0;


            val inputStream: InputStream = File(file).inputStream()
            val lineList = mutableListOf<String>()

            inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }

            val nameBox: TextView = findViewById(R.id.NameText)
            val raceBox = findViewById<Spinner>(R.id.RaceSpinner)
            val classBox = findViewById<Spinner>(R.id.ClassSpinner)
            val alignmentBox = findViewById<Spinner>(R.id.AlignmentSpinner)
            val strengthBox: TextView = findViewById(R.id.StrRoll)
            val dexterityBox: TextView = findViewById(R.id.DexRoll)
            val constitutionBox: TextView = findViewById(R.id.ConRoll)
            val intelligenceBox: TextView = findViewById(R.id.IntRoll)
            val wisdomBox: TextView = findViewById(R.id.WisRoll)
            val charismaBox: TextView = findViewById(R.id.CharRoll)

            nameBox.setText(lineList[0])
            for((index, value) in races.withIndex()){
                if(lineList[1] == value)
                    position = index
            }
            raceBox.setSelection(position)
            for((index, value) in classes.withIndex()){
                if(lineList[2] == value)
                    position = index
            }
            classBox.setSelection(position)
            for((index, value) in alignment.withIndex()){
                if(lineList[3] == value)
                    position = index
            }
            alignmentBox.setSelection(position)
            strengthBox.setText(lineList[4])
            dexterityBox.setText(lineList[5])
            constitutionBox.setText(lineList[6])
            intelligenceBox.setText(lineList[7])
            wisdomBox.setText(lineList[8])
            charismaBox.setText(lineList[9])


        }

        //Spinner for race selection
        val spin = findViewById<Spinner>(R.id.RaceSpinner)

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            races)

        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)

        spin.adapter = ad

        //Spinner for class selection
        val spin2 = findViewById<Spinner>(R.id.ClassSpinner)

        val ad2: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            classes)

        ad2.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)

        spin2.adapter = ad2

        //Spinner for class selection
        val spin3 = findViewById<Spinner>(R.id.AlignmentSpinner)

        val ad3: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            alignment)

        ad3.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)

        spin3.adapter = ad3

        //Spinner for class selection
        val spin4 = findViewById<Spinner>(R.id.PlayerSkillLevel)

        val ad4: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            playerLevel)

        ad4.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)

        spin4.adapter = ad4
    }

    //Function for randomly rolling all of the stats for the character
    private fun rollStats() {
        val LevelBox = findViewById<Spinner>(R.id.PlayerSkillLevel)
        val stat = StatRoll(LevelBox.selectedItem.toString())
        val statRoll = stat.roll()
        val strTextView: TextView = findViewById(R.id.StrRoll)
        strTextView.text = statRoll.toString()
        val statRoll2 = stat.roll()
        val dexTextView: TextView = findViewById(R.id.DexRoll)
        dexTextView.text = statRoll2.toString()
        val statRoll3 = stat.roll()
        val conTextView: TextView = findViewById(R.id.ConRoll)
        conTextView.text = statRoll3.toString()
        val statRoll4 = stat.roll()
        val intTextView: TextView = findViewById(R.id.IntRoll)
        intTextView.text = statRoll4.toString()
        val statRoll5 = stat.roll()
        val wisTextView: TextView = findViewById(R.id.WisRoll)
        wisTextView.text = statRoll5.toString()
        val statRoll6 = stat.roll()
        val charTextView: TextView = findViewById(R.id.CharRoll)
        charTextView.text = statRoll6.toString()
    }
}

    // the random number generator used to determine the random stats
    class DiceRoll(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    //Roll stats for the character based on their skill level. A beginner rolls 6 d6 and picks the top 4
    //Average players will roll 4 d6 and use the top 3, and advanced players will just roll 3 d6
    class StatRoll(private val Level: String){

        fun roll(): Int {
            val stat = DiceRoll(6)
            val advancedStatRoll = stat.roll() + stat.roll() + stat.roll()

            val beginnerRoll = mutableListOf<Int>(stat.roll(), stat.roll(), stat.roll(), stat.roll(), stat.roll(), stat.roll())

            beginnerRoll.sort()

            val beginnerStatRoll = beginnerRoll[5] + beginnerRoll[4] + beginnerRoll[3] + beginnerRoll[2]

            val averageRoll = mutableListOf<Int>(stat.roll(), stat.roll(), stat.roll(), stat.roll())

            val averageStatRoll = averageRoll[1] + averageRoll[2] + averageRoll[3]

            averageRoll.sort()

            if(Level == "Beginner"){
                return beginnerStatRoll
            }else if(Level == "Average"){
                return averageStatRoll
            }else{
                return advancedStatRoll
            }
        }
    }