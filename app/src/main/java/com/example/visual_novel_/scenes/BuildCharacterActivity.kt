package com.example.visual_novel_.scenes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.visual_novel_.R

class BuildCharacterActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_character)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.next -> {
                val intent = Intent(applicationContext, Chapter2Activity::class.java)
                startActivity(intent)
            }
        }
    }
}