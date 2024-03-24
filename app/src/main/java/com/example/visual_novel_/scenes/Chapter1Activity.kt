package com.example.visual_novel_.scenes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.visual_novel_.Dialogue
import com.example.visual_novel_.R
import com.example.visual_novel_.Scene
import com.example.visual_novel_.Character
import com.orm.SugarRecord

class Chapter1Activity : AppCompatActivity() {

    private lateinit var characterImageView: ImageView
    private lateinit var backgroundImageView: ImageView
    private lateinit var dialogueTextView: TextView
    private lateinit var gameView: LinearLayout
    private lateinit var choiceView: LinearLayout

    private var currentSceneId: Long = 1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter1)

        SugarRecord.deleteAll(Scene::class.java)

        characterImageView = findViewById(R.id.characterImageView)
        backgroundImageView = findViewById(R.id.backgroundImageView)
        dialogueTextView = findViewById(R.id.dialogueTextView)
        choiceView = findViewById(R.id.choiceView)

        gameView = findViewById(R.id.gameView)
        dialogueTextView.setOnClickListener {
            goToNextScene()
        }



        val gender: String? = intent.getStringExtra("gender")

        if (gender == "Мужской"){
            val phrase1 = "Согласны ли Вы взять этого пацана в мужья? Клянетесь быть с ним в богатстве и бедности, на дискотеках и стрелках с другими группировками?"
            val scene1 = Scene(1, "@drawable/wedding", null, null, phrase1, "", "")
            scene1.save()

            currentSceneId = SugarRecord.last(Scene::class.java).id
            println(currentSceneId)

            goToNextScene()

            val characterNataliaNikolaevna = Character("Наталья Николаевна", "@drawable/natalia_nikolevna_usual")
            val phrase2 = "Согласна"
            val scene2 = Scene(2, "@drawable/wedding", characterNataliaNikolaevna, null, phrase2, "", "")
            characterNataliaNikolaevna.save()
            scene2.save()

            val phrase3 = "А Вы, жених, согласны взять в жены Наталью? Клянетесь быть с ней в богатстве и бедности, защищать её и обеспечивать?"
            val scene3 = Scene(3, "@drawable/wedding", null, null, phrase3, "", "")
            scene3.save()

            val characterOleg = Character("Олег", "@drawable/oleg_usual")
            val phrase4 = "Согласе…"
            val scene4 = Scene(4, "@drawable/wedding", characterOleg, null, phrase4, "", "")
            characterOleg.save()
            scene4.save()

            val characterMale = Character("Саша Виноградов", "@drawable/male_main_hero")
            val phrase5 = "Приснится же такое! Права была мать, нужно меньше смотреть сериалы перед сном."
            val scene5 = Scene(5, "@drawable/bedroom", characterMale, null, phrase5, "", "")
            characterMale.save()
            scene5.save()

        }
    }

    private fun goToNextScene() {
        println("go_next")
        loadScene(currentSceneId)
        currentSceneId += 1
    }

    private fun switchToDialogScreen() {
        choiceView.visibility = View.GONE
        dialogueTextView.visibility = View.VISIBLE
    }
    private fun switchToButtonsScreen() {
        choiceView.visibility = View.VISIBLE
        dialogueTextView.visibility = View.GONE
    }

    private fun loadScene(sceneId: Long) {
        val scene: Scene? = SugarRecord.findById(Scene::class.java, sceneId)
        if (scene != null) {
            println("Loaded scene ${sceneId}")
        } else {
            println("Scene with id $sceneId not found")
        }
        updateUI(scene)
    }
    private fun updateUI(currentScene: Scene?) {
        if (currentScene != null) {

            if (currentScene.dialogue != null){
                switchToDialogScreen()
            } else {
                switchToButtonsScreen()
            }

            backgroundImageView.setImageResource(resources.getIdentifier(currentScene.background, "drawable", packageName))
            if (currentScene.dialogue != null){
                dialogueTextView.text = currentScene.dialogue
            }
            else {
                println("bad")
            }

            if (currentScene.firstCharacter != null) {

                characterImageView.visibility = View.VISIBLE

                println(currentScene.firstCharacter?.current_image)
                val currentImageName = currentScene.firstCharacter?.current_image?.substringAfterLast("/")?.substringBeforeLast(".")
                val characterImageResource = resources.getIdentifier(currentImageName, "drawable", packageName)
                if (characterImageResource != 0) {
                    characterImageView.setImageResource(characterImageResource)
                } else {
                    println("Character image resource not found")
                }
            } else {
                println("no_ch")
                characterImageView.visibility = View.GONE
            }


        }
    }




}