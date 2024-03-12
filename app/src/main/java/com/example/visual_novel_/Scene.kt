package com.example.visual_novel_
import com.orm.SugarRecord


class Scene : SugarRecord {
    var number: Long = 0
    var background: String = ""
    var firstCharacter: Character? = null
    var secondCharacter: Character? = null
    var dialogue: Dialogue? = null

    constructor()
    constructor(number: Long, background: String, firstCharacter: Character?, secondCharacter: Character?, dialogue: Dialogue?) {
        this.number = number
        this.background = background
        this.firstCharacter = firstCharacter
        this.secondCharacter = secondCharacter
        this.dialogue = dialogue

    }
}


