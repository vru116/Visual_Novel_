package com.example.visual_novel_

class Character {
    var name: String = ""
    var emotion_image: MutableMap<String, String> = mutableMapOf()
    constructor(name:String, emotion_image:MutableMap<String, String>){
        this.name = name
        this.emotion_image = emotion_image
    }
    fun ChangeEmotion(emotion: String, image: String) {
        this.emotion_image[emotion] = image
    }
}