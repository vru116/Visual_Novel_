package com.example.visual_novel_

class Scene {
    var background: String = ""
    var characters: Array<Character> = arrayOf()
    var dialogue: Dialogue
    constructor(background:String, characters:Array<Character>, dialogue:Dialogue){
        this.background = background
        this.characters = characters
        this.dialogue = dialogue
    }
}