package com.example.visual_novel_

import com.orm.SugarRecord

class Dialogue : SugarRecord{
    var speaker: Character = Character()
    var text: String = ""

    constructor()
    constructor(speaker:Character, text:String){
        this.speaker = speaker
        this.text = text
    }
}