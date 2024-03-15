package com.example.visual_novel_

import com.orm.SugarRecord

class Character : SugarRecord{
    var name: String = ""
    // var emotion_image: MutableMap<String, String> = mutableMapOf()
    //var current_emotion = ""
    var current_image = ""

    constructor()
//    constructor(name:String, emotion_image:MutableMap<String, String>){
//        this.name = name
//        this.emotion_image = emotion_image
//    }
    constructor(name:String, image:String){
        this.name = name
        this.current_image = image
    }
//    fun ChangeEmotion(emotion: String, image: String) {
//        this.emotion_image[emotion] = image
//    }
}