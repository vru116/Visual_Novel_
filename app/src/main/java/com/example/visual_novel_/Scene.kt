package com.example.visual_novel_
import com.orm.SugarRecord


class Scene : SugarRecord {
    var number: Long = 0
    var background: String = ""
    var firstCharacter: Character? = null
    var secondCharacter: Character? = null

    var dialogue: String? = ""

    var choice1: Choice? = null
    var choice2: Choice? = null


    constructor()

    constructor(number: Long, background: String, firstCharacter: Character?, secondCharacter: Character?, dialogue: String?, choice1: Choice?, choice2: Choice?) {
        this.number = number
        this.background = background
        this.firstCharacter = firstCharacter
        this.secondCharacter = secondCharacter
        this.dialogue = dialogue
        this.choice1 = choice1
        this.choice2 = choice2
    }
}


