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



