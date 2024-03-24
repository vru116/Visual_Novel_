package com.example.visual_novel_
import com.orm.SugarRecord

class Choice : SugarRecord{
    var text: String = ""
    var next_scene1: Scene? = null
    var next_scene2: Scene? = null
    constructor()

    constructor(text: String, next_scene1:Scene, next_scene2: Scene?) {
        this.text = text
        this.next_scene1 = next_scene1
        this.next_scene2 = next_scene2
    }
}


