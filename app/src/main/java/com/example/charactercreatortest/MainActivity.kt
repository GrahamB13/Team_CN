package com.example.charactercreatortest

import android.content.Context
import android.os.Bundle
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
import android.text.method.ScrollingMovementMethod
class MainActivity : AppCompatActivity() {

    private var races = arrayOf<String?>("Dragonborn", "Dwarf", "Elf", "Gnome", "Half -Elf", "Halfling", "Half-Orc", "Human", "Tiefling")
    private var classes = arrayOf<String?>("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin",
        "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard")
    private var alignment = arrayOf<String?>("Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral",
        "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil")
    private var playerLevel = arrayOf<String?>("Beginner", "Average", "Advanced")

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
            popUpBox.setText("Race \n\n Dwarf\n\n" +
                    "Dwarves are known as steadfast, sturdy beings, deeply rooted in ancient traditions and unyielding in the face of adversity. Emerging from their mighty mountain fortresses and deep underground halls, Dwarves are as enduring as the stone they carve. Renowned for their craftsmanship, their forges produce legendary weapons and armor, and their stonework is without parallel. Shorter in stature but strong and resilient, Dwarves possess a natural resistance to poison and magic, a testament to their hardiness. They are a people of honor and clan loyalty, valuing the bonds of family and tradition above all else. Dwarves are also famed for their stubbornness and tenacity, qualities that make them formidable warriors and tireless workers. Their long beards are a mark of pride, often intricately braided and adorned to signify clan and status. In battle, they are fierce and unyielding, and their deep connection to the earth gives them a unique perspective on the world around them. Dwarves embody the unbreakable spirit of the stone they hail from, steadfast allies and implacable foes.\n\n" +
                    "Elf\n\n" +
                    "Elves embody grace, elegance, and a deep connection to nature and magic. Tall and slender, with pointed ears and ageless faces, Elves move with a fluidity and poise that belies their keen senses and innate agility. Ancient and wise, they live in harmonious seclusion in enchanted forests, hidden glades, and shimmering cities, often among the oldest and most majestic trees. Elves are deeply attuned to the rhythms of the natural world and the arcane currents that flow through it, granting them a natural proficiency in magic and a profound understanding of its mysteries. Their longevity allows them to view the world with a perspective that spans centuries, often making them seem aloof or detached to the shorter-lived races. Elves excel in art, music, and lore, their creations reflecting the beauty and complexity of the world they adore. In battle, they are swift and precise, using their superior agility and sharp intellect to outmaneuver foes. Elves are not just inhabitants of the world—they are its eternal custodians, guardians of its ancient magic and natural beauty.\n\n" +
                    "Halfling\n\n" +
                    "Halflings are a small but spirited folk, known for their cheerfulness, resourcefulness, and surprising bravery. Standing around three feet tall, Halflings navigate the larger world with a blend of plucky determination and easygoing charm. They hail from pastoral lands, living in peaceful, close-knit communities where everyone knows their neighbor. Halflings are renowned for their agility and stealth, able to move quietly and remain unseen when they wish. Their size, often seen as a disadvantage, proves to be their greatest strength in tight spots and unexpected situations. Fond of comfort and simple pleasures, Halflings love good food, a warm hearth, and a well-told story. Despite their love for home, Halflings are also incurably curious, and many are drawn to a life of adventure for the sheer joy of seeing what lies beyond the next hill. In a group, Halflings are loyal, dependable friends, using their wit and resourcefulness to overcome challenges that would daunt larger, less nimble adventurers. Their presence brings light-heartedness to even the direst situations, reminding their companions that joy can be found in the journey as well as the destination.\n\n" +
                    "Dragonborn\n\n" +
                    "Dragonborn are a proud and powerful race, embodying the awe-inspiring majesty and fearsome presence of dragons. Standing tall and robust, their humanoid form is accentuated by draconic features - scales covering their skin in a kaleidoscope of colors, reptilian eyes, and a fearsome visage crowned with horns or frills. Dragonborn are born from the union of dragons and ancient, forgotten magic, inheriting the formidable strength and elemental breath of their draconic ancestors. Their culture is steeped in honor, valor, and a deep sense of clan loyalty. Dragonborn place great value on the bonds of family and community, often dedicating themselves to high ideals and a life of service. In battle, they are formidable warriors, their natural armor and breath weapon making them both imposing and versatile. Dragonborn carry the weight of their heritage with a mix of pride and responsibility, constantly striving to bring honor to their clan and to live up to the legacy of their mythical forebears. Whether as noble paladins, fierce fighters, or wise counselors, Dragonborn stand as living emblems of the ancient power and wonder that dragons represent in the world of Dungeons & Dragons.\n\n" +
                    "Human\n\n" +
                    "Humans stand as the most adaptable and ambitious of all the races. With a variety of complexions, cultures, and backgrounds, they are a mosaic of the world's myriad possibilities. Humans lack the longevity of elves, the sturdiness of dwarves, or the specialized abilities of other races, but they compensate with their determination, ingenuity, and a remarkable capacity to endure and thrive in a multitude of environments. Humans build vast empires, bustling cities, and pioneering settlements, driven by their ceaseless ambition and a profound desire to shape the world around them. They are quick to forge alliances, yet equally swift to make enemies, embodying a spectrum of virtues and vices. In the realm of adventure, Humans are versatile and varied, their short lifespans fueling a thirst for achievement and a drive to leave a lasting legacy. As warriors, mages, rogues, or any other path they choose, Humans bring a dynamic spirit and an adaptable approach to both the challenges and wonders of the world of Dungeons & Dragons. Their greatest strength lies in their diversity, resilience, and the boundless potential to become anything they aspire to be.\n\n" +
                    "Gnome\n\n" +
                    "Gnomes are the embodiment of inventive spirit and quirky charisma. Standing just over 3 feet tall, these small beings radiate a sense of whimsy and wonder. With their bright eyes and quick smiles, Gnomes carry an innate curiosity and a penchant for mischief and creativity. They are the tinkerers and inventors, often found engrossed in complex mechanical contraptions or delving into arcane research with boundless enthusiasm. Gnomes live in vibrant communities where nature and invention harmoniously intertwine, often hidden away in forested valleys or underground burrows. Their homes are a chaotic blend of ingenious gadgets, colorful gardens, and eclectic decorations. Gnomes have a natural affinity for illusion magic and a talent for stealth, making them elusive and unpredictable. Despite their small stature, they possess a resilience and inner strength that surprises many. In an adventuring party, Gnomes are invaluable for their resourcefulness, intelligence, and ability to think outside the box. They approach life with a sense of joy and optimism, reminding those around them of the magic that exists in the smallest things and the importance of laughter and friendship in the face of adversity.\n\n" +
                    "Half-Elf\n\n" +
                    "Half-Elves stand at the crossroads of two worlds, embodying a unique blend of the grace and longevity of Elves and the drive and versatility of Humans. With features that draw from both their elven and human heritages, Half-Elves often possess the alluring beauty of Elves and the robust vitality of Humans. This duality extends beyond their appearance; they are creatures of juxtaposition, belonging fully to neither world, yet finding a place in both. Half-Elves often feel the pull of wanderlust, their dual nature driving them to explore and find their own path. They are natural diplomats and mediators, their mixed heritage granting them an innate ability to understand and relate to diverse cultures and races. In social situations, they are adaptable and charismatic, often serving as the bridge between disparate groups. Their versatility makes them well-suited to a variety of roles in an adventuring party. Whether as skilled negotiators, agile warriors, or cunning mages, Half-Elves bring a unique perspective and a wide array of talents, borne of a life spent navigating the complexities of two distinct identities. Their journey is one of self-discovery, a quest to find balance and belonging in a world where they often straddle the line between light and shadow, tradition and change.\n\n" +
                    "Half-Orc\n\n" +
                    "Half-Orcs stand as embodiments of strength, resilience, and the struggle between two conflicting heritages. Born from the union of Orc and Human, they often bear the physical prowess and commanding presence of their Orcish lineage, coupled with the adaptability and ingenuity of Humans. Half-Orcs typically feature prominent Orcish traits – towering builds, greenish skin, and strong, angular features, yet they move through the human world with a unique blend of grit and determination. Half-Orcs frequently grapple with their identity, facing prejudices from both sides of their heritage. This struggle often forges in them a fierce independence and a deep well of inner strength. In battle, they are formidable, channeling their intense emotions and physical power into fearsome displays of martial prowess. Yet, there's more to them than mere strength; many Half-Orcs are fiercely loyal, valuing the bonds of camaraderie and finding great honor in protecting those they care about. Their journey is often one of self-acceptance, as they seek to reconcile the disparate parts of their identity. In an adventuring party, Half-Orcs are not just brawny warriors; they are symbols of endurance, the resilience of the spirit, and the power of embracing one's own uniqueness in a world that often seeks conformity.\n\n" +
                    "Tiefling\n\n" +
                    "Tieflings are the embodiment of an enigmatic and powerful legacy. Bearing the bloodline of infernal beings, their ancestry is marked by striking features - horns curling from their foreheads, tails, and often, eyes that hold no pupil. Their skin tones range from human-like hues to vibrant reds, blues, or even purples, setting them apart in any crowd. Tieflings carry the weight of their heritage with a mix of pride and solitude, often facing suspicion and fear from those who misunderstand their demonic lineage. This ostracization fosters in many Tieflings a strong sense of independence, cunning, and resourcefulness. Despite the dark shadow cast by their ancestry, Tieflings are as varied in personality and alignment as any other race, challenging the stereotypes and prejudices that follow them. In an adventuring party, Tieflings bring a unique perspective, often surprising allies and adversaries alike with their innate abilities, which can include manipulating shadows, casting hellish spells, or enduring harsh environments. Their journey is often one of self-discovery, challenging the preconceived notions of fate and morality. A Tiefling's path is a testament to the enduring truth that one's choices define them more than their bloodline.\n\n")
        }

        //the button for information about the different classes
        val classInfoButton: ImageButton = findViewById(R.id.ClassInfo)
        classInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Classes \n\n Barbarian\n\n" +
                    "The Barbarian is a figure of primal might and untamed fury. Emerging from the wild frontiers and harsh landscapes, Barbarians are warriors of extraordinary strength and ferocity. Clad in simple garb rather than heavy armor, they rely on their unparalleled resilience and raw power. When a Barbarian's wrath is kindled, they enter a battle rage, a state of fierce focus and savage intensity that grants them extraordinary strength and durability. In this state, they become unstoppable juggernauts, capable of tearing through foes and withstanding great punishment. Barbarians often hail from nomadic tribes or reclusive clans, and their combat style is fueled by instinct and passion rather than formal training. This connection to their primal roots also gives them a unique bond with the natural world, making them formidable opponents both in the wilds and on the battlefield. The Barbarian is the embodiment of the wild spirit of survival and the raw power of nature, a relentless warrior undaunted by the greatest of challenges.\n\n" +
                    "Bard\n\n" +
                    "The Bard is a magical minstrel, a wandering poet whose words and music hold the power to enchant, inspire, and alter the fabric of reality. With a lute in hand and a song on their lips, Bards are storytellers and chroniclers, weaving tales of heroism and heartache. Their melodies can soothe the weary, bolster the courage of companions, or bewitch the minds of foes. As masters of lore and language, Bards are as adept with a witty verse as they are with a sharp sword, making them versatile companions on any adventure. Drawing on the mystical forces of their art, they can cast spells that heal wounds, reveal secrets, or summon illusions. More than mere entertainers, Bards are the keepers of knowledge, the voices that echo through the ages, turning history into legend with every note they play.\n\n" +
                    "Cleric\n\n" +
                    "The Cleric stands as a divine conduit, a sacred warrior, and a healer, bound by deep faith and granted power by their deity. Clad in armor sanctified by prayer, they wield holy symbols as both shield and weapon against the darkness. Clerics are the heart of their party, offering guidance with wisdom as ancient as the gods they serve. Their prayers manifest as miraculous spells—mending broken bodies, shielding the innocent, or smiting the wicked. Each Cleric is a devoted follower of a specific deity, their abilities and spells reflecting the nature of their divine patron, be it a god of light, darkness, nature, or storm. In battle, they stand resolute, a beacon of hope and courage. Outside combat, they are counselors and mediators, their words imbued with the authority of the heavens. More than mere priests, Clerics are the embodiment of their deity's will on the mortal plane, champions of their faith's ideals in every word and deed.\n\n" +
                    "Druid\n\n" +
                    "The Druid is a guardian of the natural world, a mystical bridge between the primeval forces of nature and the civilized realms. These enigmatic figures harness the ancient magic of the earth, drawing power from the whispering forests, murmuring streams, and the very soil beneath their feet. Druids are shape-shifters, capable of transforming into the beasts of the wild, embodying the fierce strength of the bear, the cunning of the wolf, or the grace of the eagle. Their spells are born of a deep, intrinsic understanding of nature's balance, allowing them to summon vines from the ground, call upon the elements, or heal with the touch of their hands. As stewards of the wilderness, they often stand as the first line of defense against unnatural threats, preserving the harmony between mankind and the untamed world. A Druid's wisdom is as deep as the roots of the oldest tree, and their presence is a reminder of the ancient pact between humanity and the natural order.\n\n" +
                    "Fighter\n\n" +
                    "The Fighter stands as the epitome of martial prowess and physical might. Clad in armor forged from the fires of the forge and wielding weapons honed to deadly perfection, Fighters are masters of combat in all its forms. From the disciplined knight in shining armor to the rugged mercenary, and from the skilled archer to the master of unarmed combat, Fighters come from all walks of life, each with their own unique story. They are defined by their unyielding courage and exceptional combat skills, capable of standing toe-to-toe with fearsome monsters and emerging victorious. Fighters are versatile warriors, adept at both leading charges and holding the line, their presence a bulwark against the chaos of battle. Through rigorous training and battlefield experience, they gain extraordinary feats of strength, agility, and endurance. Whether as noble champions, cunning gladiators, or daring adventurers, Fighters are the backbone of any group, steadfast in the face of overwhelming odds.\n\n" +
                    "Monk\n\n" +
                    "The Monk is a master of martial arts, a warrior ascetic who has honed body and mind to become a living weapon. Monks eschew heavy armor and clunky weapons, instead relying on the strength of their fists and the agility of their movements. They are disciples of ancient monastic traditions, each with its own unique philosophies and fighting styles. Through rigorous training and meditation, Monks achieve extraordinary physical feats—leaping great distances, moving with blinding speed, and striking with deadly precision. Their understanding of ki, the life force that flows through all living beings, allows them to perform superhuman acts and harness mystical energies. Monks can stun powerful foes with a touch, heal their own wounds through sheer will, and even slow their fall from great heights. Beyond combat, they are centered and reflective, their wisdom often providing guidance in times of moral quandary. The Monk embodies the perfect harmony of body and soul, a serene warrior walking a path of balance in a world of chaos.\n\n" +
                    "Paladin\n\n" +
                    "The Paladin stands as a beacon of divine righteousness and mortal valor. These holy warriors are the armored fist of their deity, bound by sacred oaths to uphold the forces of good and justice in a world rife with darkness and chaos. Paladins are clad in gleaming armor, emblems of their unwavering faith, and wield weapons consecrated by holy rites. They are as much a cleric as they are a fighter, blending martial prowess with divine magic. Their spells bolster their allies, heal the wounded, and smite the wicked. More than just warriors, Paladins are paragons of virtue and determination, often serving as moral compasses for their adventuring parties. Their divine connection grants them not only the power to combat evil but also the wisdom to provide counsel and guidance. In the face of overwhelming evil, the Paladin stands unflinching, a shining example of what it means to be a hero in a world beset by darkness.\n\n" +
                    "\n\n" +
                    "Ranger\n\n" +
                    "The Ranger is the ultimate survivalist, a master of tracking, hunting, and communing with nature. Rangers are the eyes and ears of their party, adept at navigating through dense forests, treacherous mountains, and hidden paths. Cloaked in camouflaging garb, they are skilled marksmen with a bow and arrow, capable of taking down enemies from great distances. Their deep connection to the natural world grants them a unique kinship with animals, allowing them to enlist the aid of nature's creatures or move through the wild with unparalleled ease. Rangers are also adept at setting traps and laying ambushes, using their knowledge of the wilderness to outsmart foes. Many Rangers are driven by a personal quest, a deep-seated vendetta against certain creatures, or a commitment to protect the natural world. Solitary but loyal, a Ranger's knowledge of terrain and survival skills make them invaluable guides and relentless hunters, ever vigilant against the dangers lurking beyond the civilized world.\n\n" +
                    "Rogue\n\n" +
                    "The Rogue thrives, a master of stealth, cunning, and agility. Rogues are the unseen hand, the whispered rumor, the flash of a dagger from the darkness. They move through the world with a silent grace, masters of disguise and infiltration, adept at unlocking secrets both literal and figurative. Whether as skilled thieves, elusive spies, or daring treasure hunters, Rogues rely on their wits, dexterity, and an uncanny knack for surviving the most perilous situations. Their combat style is about precision and finesse, striking swiftly and decisively. Rogues are often motivated by self-interest, personal goals, or a thirst for adventure, yet their resourcefulness and versatility make them invaluable allies. They have an eye for detail, noticing things others overlook, which makes them excellent problem solvers. In a world of dragons and dungeons, the Rogue is the wild card, an unpredictable element whose skills can mean the difference between success and failure, fortune and folly.\n\n" +
                    "Sorcerer\n\n" +
                    "The Sorcerer is a natural conduit of arcane power, a spellcaster whose magic is an innate extension of their very being. Unlike wizards who study ancient tomes, Sorcerers are born with the ability to harness the raw, untamed forces of magic. This power often manifests from a mysterious lineage or a cosmic event, making each Sorcerer unique in their capabilities. They channel magic through sheer force of will and emotion, shaping spells in ways others cannot fathom. This innate talent allows them to perform spectacular feats of magic spontaneously, releasing bursts of elemental energy, warping the fabric of reality, or bending the minds of others. However, their power is as unpredictable as it is formidable, sometimes surging out of control. Sorcerers walk a fine line between chaos and control, their presence a reminder of the wild and untamed nature of magic itself. As enigmatic as they are powerful, Sorcerers challenge the boundaries of what is possible in the world of magic and adventure.\n\n" +
                    "Warlock\n\n" +
                    "The Warlock stands as a wielder of arcane secrets and forbidden powers. Bound by a pact to otherworldly entities — be they eldritch beings, fiendish lords, or fae patrons — Warlocks gain their magic through an exchange of loyalty for unearthly knowledge. This relationship imbues them with an array of mystical abilities, from casting spells that rend the fabric of reality to invoking curses that doom their foes. Unlike other spellcasters, a Warlock's power is as much a curse as it is a blessing, often coming with a cost or a hidden agenda set by their patrons. They are adept at manipulation and deception, using their dark gifts to outsmart and overpower opponents. With a tome, a blade, or a familiar at their side, Warlocks tread a precarious path, balancing the whims of their patrons with their own ambitions. Their presence brings a sense of mystery and danger, a reminder that not all power is freely given or safely wielded.\n\n" +
                    "Wizard\n\n" +
                    "the Wizard epitomizes the pinnacle of arcane knowledge and spellcasting. Cloistered in ancient libraries and schools of magic, Wizards dedicate their lives to the pursuit of magical lore, uncovering secrets hidden in musty tomes and forgotten scrolls. Through intense study and practice, they learn to harness the fundamental laws of reality, casting spells of immense power and variety. Wizards are defined by their spellbooks, meticulously prepared repositories of arcane incantations and complex rituals. Whether summoning elemental forces, bending the fabric of space and time, or conjuring illusions to deceive and confuse, Wizards approach each situation with a strategic mind and a vast repertoire of magical solutions. Their path is one of constant learning and adaptation, driven by an insatiable curiosity about the mysteries of the universe. In the hands of a skilled Wizard, magic is a tool of limitless potential, a force that can shape worlds and redefine the impossible.\n\n")
        }

        //the button for information about the different classes
        val allignmentInfoButton: ImageButton = findViewById(R.id.AllignmentInfo)
        allignmentInfoButton.setOnClickListener {
            popUpClose.isVisible = true
            popUpBox.isVisible = true
            popUpBox.setText("Allignment \n\n A typical creature in the game world has an alignment, which broadly describes its moral and personal attitudes. Alignment is a combination of two factors: one identifies morality (good, evil, or neutral), and the other describes attitudes toward society and order (lawful, chaotic, or neutral). Thus, nine distinct alignments define the possible combinations.  \n\n" +
                    "These brief summaries of the nine alignments describe the typical behavior of a creature with that alignment. Individuals might vary significantly from that typical behavior, and few people are perfectly and consistently faithful to the precepts of their alignment. \n\n" +
                    " Lawful good (LG) creatures can be counted on to do the right thing as expected by society. Gold dragons, paladins, and most dwarves are lawful good. \n\n" +
                    "Neutral good (NG) folk do the best they can to help others according to their needs. Many celestials, some cloud giants, and most gnomes are neutral good. \n\n" +
                    "Chaotic good (CG) creatures act as their conscience directs, with little regard for what others expect. Copper dragons, many elves, and unicorns are chaotic good. \n\n" +
                    " Lawful neutral (LN) individuals act in accordance with law, tradition, or personal codes. Many monks and some wizards are lawful neutral. \n\n" +
                    "Neutral (N) is the alignment of those who prefer to steer clear of moral questions and don’t take sides, doing what seems best at the time. Lizardfolk, most druids, and many humans are neutral. \n\n" +
                    "Chaotic neutral (CN) creatures follow their whims, holding their personal freedom above all else. Many barbarians and rogues, and some bards, are chaotic neutral. \n\n" +
                    " Lawful evil (LE) creatures methodically take what they want, within the limits of a code of tradition, loyalty, or order. Devils, blue dragons, and hobgoblins are lawful evil. \n\n" +
                    "Neutral evil (NE) is the alignment of those who do whatever they can get away with, without compassion or qualms. Many drow, some cloud giants, and goblins are neutral evil. \n\n" +
                    "Chaotic evil (CE) creatures act with arbitrary violence, spurred by their greed, hatred, or bloodlust. Demons, red dragons, and orcs are chaotic evil. \n\n")
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
                if(lineList[1] == value)
                    position = index
            }
            classBox.setSelection(position)
            for((index, value) in alignment.withIndex()){
                if(lineList[1] == value)
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
