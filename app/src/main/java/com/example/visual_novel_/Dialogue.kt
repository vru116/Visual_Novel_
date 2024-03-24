package com.example.visual_novel_

import com.orm.SugarRecord

class Dialogue {
    var speaker: Character = Character()
    var text: String = ""

    constructor()
    constructor(speaker: Character?, text:String){
        if (speaker != null) {
            this.speaker = speaker
        }
        this.text = text
    }
}



//            val phrase1_1 = "Согласны ли Вы взять этого пацана в мужья? Клянетесь быть с ним в богатстве и бедности, на дискотеках и стрелках с другими группировками?"
//            val scene1_1 = Scene(1, "@drawable/wedding", null, null, phrase1_1, null, null)
//            scene1_1.save()
//            currentSceneId = SugarRecord.last(Scene::class.java).id
//            println(currentSceneId)
//            goToNextScene()
//            val characterNataliaNikolaevna = Character("Наталья Николаевна", "@drawable/natalia_nikolevna_usual")
//            val phrase1_2 = "Согласна"
//            val scene1_2 = Scene(2, "@drawable/wedding", characterNataliaNikolaevna, null, phrase1_2, null, null)
//            characterNataliaNikolaevna.save()
//            scene1_2.save()
//            val phrase1_3 = "А Вы, жених, согласны взять в жены Наталью? Клянетесь быть с ней в богатстве и бедности, защищать её и обеспечивать?"
//            val scene1_3 = Scene(3, "@drawable/wedding", null, null, phrase1_3, null, null)
//            scene1_3.save()
//            val characterOleg = Character("Олег", "@drawable/oleg_usual")
//            val phrase1_4 = "Согласе…"
//            val scene1_4 = Scene(4, "@drawable/wedding", characterOleg, null, phrase1_4, null, null)
//            characterOleg.save()
//            scene1_4.save()
//
//
//            val phrase2_1 = "Приснится же такое! Права была мать, нужно меньше смотреть сериалы перед сном."
//            val scene2_1 = Scene(5, "@drawable/bedroom", null, null, phrase2_1, null, null)
//            scene2_1.save()
//            val phrase2_2 = "Приснится же такое! Права была мать, нужно меньше смотреть сериалы перед сном."
//            val scene2_2 = Scene(5, "@drawable/bedroom", null, null, phrase2_2, null, null)
//            scene2_2.save()