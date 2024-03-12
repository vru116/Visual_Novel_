package com.example.visual_novel_.scenes

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.visual_novel_.R
import com.example.visual_novel_.Scene
import com.orm.SchemaGenerator
import com.orm.SugarContext
import com.orm.SugarRecord

class Chapter2Activity : AppCompatActivity(){

    private lateinit var characterImageView: ImageView
    private lateinit var backgroundImageView: ImageView
    private lateinit var dialogueTextView: TextView
    private lateinit var game_view: LinearLayout

    private var currentSceneId: Long = 1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter2)

        //currentSceneId = SugarRecord.last(Scene::class.java).id + 1
        //SugarContext.terminate();

        SugarRecord.deleteAll(Scene::class.java)

        characterImageView = findViewById(R.id.characterImageView)
        backgroundImageView = findViewById(R.id.backgroundImageView)
        dialogueTextView = findViewById(R.id.dialogueTextView)

        game_view = findViewById(R.id.game_view)
        dialogueTextView.setOnClickListener {
            goToNextScene()
        }

        val characterPolina = com.example.visual_novel_.Character("Полина", "@drawable/img_1.png")
        val dialogue1 = com.example.visual_novel_.Dialogue(characterPolina, "Саша, что с тобой?")
        val scene1 = com.example.visual_novel_.Scene(1, "@drawable/img_2", characterPolina, null, dialogue1)
        scene1.save()
        currentSceneId = SugarRecord.last(Scene::class.java).id
        println(currentSceneId)

        val characterSasha = com.example.visual_novel_.Character("Саша", "@drawable/img.png")
        val dialogue2 = com.example.visual_novel_.Dialogue(characterSasha, "А что со мной?")
        val scene2 = com.example.visual_novel_.Scene(2, "@drawable/img_5", characterSasha, null, dialogue2)
        scene2.save()
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
            if (currentScene.firstCharacter != null){
                characterImageView.setImageResource(resources.getIdentifier(currentScene.firstCharacter!!.current_image, "drawable", packageName))
            } else {
                println("no character")
            }

            backgroundImageView.setImageResource(resources.getIdentifier(currentScene.background, "drawable", packageName))
            if (currentScene.dialogue != null){
                dialogueTextView.text = currentScene.dialogue!!.text
            }
            else {
                println("bad")
            }
        }
    }

    private fun goToNextScene() {
        loadScene(currentSceneId)
        currentSceneId += 1
    }

}