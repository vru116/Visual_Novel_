package com.example.visual_novel_.scenes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.visual_novel_.Character
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

//            var phrase = ""
//            var scene = Scene()
//
//            phrase = "Согласны ли Вы взять этого пацана в мужья? Клянетесь быть с ним в богатстве и бедности, на дискотеках и стрелках с другими группировками?"
//            scene = Scene("@drawable/wedding", null, null, phrase, null, null)
//            scene.save()
//            currentSceneId = SugarRecord.last(Scene::class.java).id
//            println(currentSceneId)
//            goToNextScene()
//            val characterNataliaNikolaevna = Character("Наталья Николаевна", "@drawable/natalia_nikolevna_usual")
//            phrase = "Согласна"
//            scene = Scene("@drawable/wedding", characterNataliaNikolaevna, null, phrase, null, null)
//            characterNataliaNikolaevna.save()
//            scene.save()
//            phrase = "А Вы, жених, согласны взять в жены Наталью? Клянетесь быть с ней в богатстве и бедности, защищать её и обеспечивать?"
//            scene = Scene("@drawable/wedding", null, null, phrase, null, null)
//            scene.save()
//            val characterOleg = Character("Олег", "@drawable/oleg_usual")
//            phrase = "Согласе…"
//            scene = Scene("@drawable/wedding", characterOleg, null, phrase, null, null)
//            characterOleg.save()
//            scene.save()


//            phrase = "Приснится же такое! Права была мать, нужно меньше смотреть сериалы перед сном."
//            scene = Scene("@drawable/bedroom", null, null, phrase, null, null)
//            scene.save()
//            phrase = "В комнате было тихо, только слабый свет ночной лампы напоминал о ленивом утре. Повернув голову, я услышал запах свежесваренного кофе, уже чувствуя, как усталость покидает мое тело."
//            scene = Scene("@drawable/bedroom", null, null, phrase, null, null)
//            scene.save()
//            phrase = "Вставать определённо не хотелось, но перспектива пропустить очередную контрольную не очень радовала. Да и я уже договорился помочь Равшану с выбором новой гитары на перемене."
//            scene = Scene("@drawable/bedroom", null, null, phrase, null, null)
//            scene.save()
//            phrase = "Пора вставать."
//            scene = Scene("@drawable/bedroom", null, null, phrase, null, null)
//            scene.save()
//            phrase = "Осмотрев комнату, я обнаружил:"
//            scene = Scene("@drawable/bedroom", null, null, phrase, null, null)
//            scene.save()
//            val characterFides = Character(null, "@drawable/cat_fides")
//            phrase = "О, Фидес у меня снова у меня в комнате спал. Такой он ласковый, такой мягкий и теплый. Очень его люблю, хоть и кусается иногда."
//            scene = Scene("@drawable/bedroom", characterFides, null, phrase, null, null)
//            characterFides.save()
//            scene.save()
//            val itemGuitar = Character(null, "@drawable/guitar")
//            phrase = "Трунь-трунь"
//            scene = Scene("@drawable/bedroom", itemGuitar, null, phrase, null, null)
//            itemGuitar.save()
//            scene.save()
//            val itemSpiderMan = Character(null, "@drawable/spider_man")
//            phrase = "Вот бы поиграть в Spider-Man 2 на пятой плойке, жаль в нашем компьютерном клубе её нет."
//            scene = Scene("@drawable/bedroom", itemSpiderMan, null, phrase, null, null)
//            itemSpiderMan.save()
//            scene.save()
//            phrase = "Я решил выйти на кухню"
//            scene = Scene("@drawable/bedroom", null, null, phrase, null, null)
//            scene.save()




//            phrase = "Когда я вышел из комнаты, мама с улыбкой встретила меня у стола."
//            scene = Scene("@drawable/kitchen", null, null, phrase, null, null)
//            scene.save()
//            currentSceneId = SugarRecord.last(Scene::class.java).id
//            println(currentSceneId)
//            goToNextScene()
//            val characterMum = Character("Мама", "@drawable/mum_happy")
//            phrase = "Ну ты и соня, наконец-то проснулся!"
//            scene = Scene("@drawable/kitchen", characterMum, null, phrase, null, null)
//            characterMum.save()
//            scene.save()
//            phrase = "Папа просматривал ленту новостей, периодически комментируя события прошлого дня."
//            scene = Scene("@drawable/kitchen", null, null, phrase, null, null)
//            scene.save()
//            val characterDad = Character("Папа", "@drawable/dad_happy")
//            phrase = "Прикинь, опять проиграли, 3:2. Угораздило же за этих кривоногих болеть...."
//            scene = Scene("@drawable/kitchen", characterDad, null, phrase, null, null)
//            characterDad.save()
//            scene.save()
//            phrase = "Не ворчи с утра пораньше."
//            scene = Scene("@drawable/kitchen", characterMum, null, phrase, null, null)
//            scene.save()
//            phrase = "Сашенька, ешь блины скорее, а то в школу опоздаешь!"
//            scene = Scene("@drawable/kitchen", characterMum, null, phrase, null, null)
//            scene.save()
//            phrase = "Она подвинула ближе ко мне тарелку с горячими блинами. Их, конечно, вкуснее есть со сгущёнкой."
//            scene = Scene("@drawable/kitchen", null, null, phrase, null, null)
//            scene.save()
//            phrase = "Я приобщился к столу, чувствуя, как жизнь начинает пробуждаться вместе со мной."
//            scene = Scene("@drawable/kitchen", null, null, phrase, null, null)
//            scene.save()
//            phrase = "Завтрак, а с ним и с самая приятная часть утра, закончился."
//            scene = Scene("@drawable/kitchen", null, null, phrase, null, null)
//            scene.save()



//            phrase = "Пора собираться в школу."
//            scene = Scene("@drawable/bedroom", null, null, phrase, null, null)
//            scene.save()
//            phrase = "Свитер, футболка и брюки лежали на стуле: что же сегодня надеть?.."
//            scene = Scene("@drawable/bedroom", null, null, phrase, null, null)
//            scene.save()




            var phrase = ""
            var scene = Scene()



//            val phrase5_3_1 = "Оглянувшись, я не обнаружил в толпе ни Полины, ни ее ярко-красной сумки, обычно заметной издалека."
//            val scene5_3_1 = Scene("@drawable/wedding", null, null, phrase5_3_1, null, null)
//
//
//            val phrase5_3_2 = "Я направился к кабинету в одиночестве, размышляя, что же приготовил мне сегодняшний день."
//            val scene5_3_2 = Scene("@drawable/wedding", null, null, phrase5_3_2, null, null)
//
//            scene5_3_1.save()
//            scene5_3_2.save()
//
//            val choice5_3_1 = Choice("оглянуться в поисках Полины", scene5_3_1, null)
//            val choice5_3_2 = Choice("Оставить одежду и продолжить путь к кабинету", scene5_3_2, null)
//            choice5_3_1.next_scene1 = scene5_3_1
//            choice5_3_2.next_scene1 = scene5_3_2
//            choice5_3_1.save()
//            choice5_3_2.save()
//
//
//
//
//
//            val phrase5_1 = "В раздевалке Полина смешалась с толпой одноклассников и исчезла."
//            val scene5_1 = Scene("@drawable/wedding", null, null, phrase5_1, null, null)
//            scene5_1.save()
//            currentSceneId = SugarRecord.last(Scene::class.java).id
//            println(currentSceneId)
//            goToNextScene()
//
//
//
//
//
//            val scene5_2 = Scene("@drawable/bedroom", null, null, null, choice5_3_1, choice5_3_2)
//            scene5_2.save()
//
//            val phrase5_4 = "В школьных коридорах витал запах мела, карандашей и сосисок в тесте из школьной столовой."
//            val scene5_4 = Scene("@drawable/wedding", null, null, phrase5_4, null, null)
//            scene5_4.save()



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
            nextScene = scene?.choice1?.next_scene1
        } else {
            nextScene = scene?.choice2?.next_scene1
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
                if (currentScene.firstCharacter?.name != null){
                    dialogueSpeaker.visibility = View.VISIBLE
                    dialogueSpeaker.text = currentScene.firstCharacter?.name
                } else {
                    dialogueSpeaker.visibility = View.GONE
                }
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