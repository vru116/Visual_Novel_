package com.example.visual_novel_
import com.orm.SugarRecord

class Choice : SugarRecord{
    var text: String = ""
    var next_scene: Scene? = null

    constructor()

    constructor(text: String, next_:Scene) {
        this.text = text
        this.next_scene = next_scene
    }
}


