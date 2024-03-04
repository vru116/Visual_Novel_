package com.example.visual_novel_

fun main() {
    var emotion_image_: Map<String, String> = mapOf("normal" to "@drawable/ralph")
    var p = Character("Ralph1", emotion_image_)

    println(p.name)
    println(p.emotion_image)
}