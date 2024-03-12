package com.example.visual_novel_.scenes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.view.View
import com.example.visual_novel_.R

class MainScreen : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.main_exit -> {
                finish()
            }
            R.id.main_new_game -> {
                val intent = Intent(applicationContext, BuildCharacterActivity::class.java)
                startActivity(intent)
            }
            R.id.main_load -> {

            }
            R.id.main_settings -> {
                val intent = Intent(applicationContext, SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.main_authors -> {
                val intent = Intent(applicationContext, AuthorsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}