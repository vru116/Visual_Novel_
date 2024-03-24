package com.example.visual_novel_.scenes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.visual_novel_.R
import com.example.visual_novel_.Scene
import com.example.visual_novel_.Choice
import com.orm.SugarRecord

class Chapter1Activity : AppCompatActivity() {

    private lateinit var characterImageView: ImageView
    private lateinit var backgroundImageView: ImageView
    private lateinit var gameView: LinearLayout

    private lateinit var dialogueTextView: LinearLayout
    private lateinit var dialogueText: TextView
    private lateinit var dialogueSpeaker: TextView

    private lateinit var choiceView: LinearLayout
    private lateinit var choice1Button: Button
    private lateinit var choice2Button: Button

    private var currentSceneId: Long = 1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter1)

        SugarRecord.deleteAll(Scene::class.java)

        characterImageView = findViewById(R.id.characterImageView)
        backgroundImageView = findViewById(R.id.backgroundImageView)
        gameView = findViewById(R.id.gameView)

        dialogueTextView = findViewById(R.id.dialogueTextView)
        dialogueText = findViewById(R.id.dialogueText)
        dialogueSpeaker = findViewById(R.id.speakerText)

        choiceView = findViewById(R.id.choiceView)
        choice1Button = findViewById(R.id.choice1Button)
        choice2Button = findViewById(R.id.choice2Button)

        dialogueText.setOnClickListener {
            goToNextScene()
        }





        val gender: String? = intent.getStringExtra("gender")

        if (gender == "Мужской"){


            val phrase5_3_1 = "Оглянувшись, я не обнаружил в толпе ни Полины, ни ее ярко-красной сумки, обычно заметной издалека."
            val scene5_3_1 = Scene(3, "@drawable/wedding", null, null, phrase5_3_1, null, null)


            val phrase5_3_2 = "Я направился к кабинету в одиночестве, размышляя, что же приготовил мне сегодняшний день."
            val scene5_3_2 = Scene(4, "@drawable/wedding", null, null, phrase5_3_2, null, null)

            scene5_3_1.save()
            scene5_3_2.save()

            val choice5_3_1 = Choice("оглянуться в поисках Полины", scene5_3_1)
            val choice5_3_2 = Choice("Оставить одежду и продолжить путь к кабинету", scene5_3_2)
            choice5_3_1.next_scene = scene5_3_1
            choice5_3_2.next_scene = scene5_3_2
            choice5_3_1.save()
            choice5_3_2.save()





            val phrase5_1 = "В раздевалке Полина смешалась с толпой одноклассников и исчезла."
            val scene5_1 = Scene(1, "@drawable/wedding", null, null, phrase5_1, null, null)
            scene5_1.save()
            currentSceneId = SugarRecord.last(Scene::class.java).id
            println(currentSceneId)
            goToNextScene()





            val scene5_2 = Scene(2, "@drawable/bedroom", null, null, null, choice5_3_1, choice5_3_2)
            scene5_2.save()

            val phrase5_4 = "В школьных коридорах витал запах мела, карандашей и сосисок в тесте из школьной столовой."
            val scene5_4 = Scene(5, "@drawable/wedding", null, null, phrase5_4, null, null)
            scene5_4.save()



        }
    }

    private fun handleChoice(choice: Int) {

        currentSceneId-=1
        println(currentSceneId)

        val scene: Scene? = SugarRecord.findById(Scene::class.java, currentSceneId)

        if (scene != null){
            println(scene.choice1?.text)
        } else{
            println("no scene")
        }

        var nextScene: Scene? = null
        if (choice == 1) {
            nextScene = scene?.choice1?.next_scene
        } else {
            nextScene = scene?.choice2?.next_scene
        }

        if (nextScene != null) {
            println(nextScene.dialogue)
        } else{
            println("no next_scene")
        }

        updateUI(nextScene)

        currentSceneId += 1
        println(currentSceneId)
    }



    fun onChoiceButtonClick(view: View) {
        println("button_clicked")
        val choice = view.tag.toString().toInt()
        handleChoice(choice)
    }


    private fun goToNextScene() {
        println("go_next")
        println(currentSceneId)
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
        println(currentScene)
        if (currentScene != null) {

            if (currentScene.dialogue != null){
                switchToDialogScreen()
                dialogueText.text = currentScene.dialogue
                dialogueSpeaker.text = currentScene.firstCharacter?.name
            }

            if (currentScene.choice1 != null){
                println("choices")
                switchToButtonsScreen()

                choice1Button.text = currentScene.choice1!!.text

                if (currentScene.choice2 != null){
                    choice2Button.visibility = View.VISIBLE
                    choice2Button.text = currentScene.choice2!!.text
                } else {
                    choice2Button.visibility = View.GONE
                }
            } else {
                println("no choices")
            }

            backgroundImageView.setImageResource(resources.getIdentifier(currentScene.background, "drawable", packageName))

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
                characterImageView.visibility = View.GONE
            }
        }
    }




}