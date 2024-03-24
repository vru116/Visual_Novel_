package com.example.visual_novel_.scenes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.example.visual_novel_.R

class BuildCharacterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var genderRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_character)

        genderRadioGroup = findViewById(R.id.gender_radio_group)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.next -> {
                val gender: String? = when (genderRadioGroup.checkedRadioButtonId) {
                    R.id.male_radio_button -> "Мужской"
                    R.id.female_radio_button -> "Женский"
                    else -> null
                }

                if (gender != null) {
                    val intent = Intent(this, Chapter1Activity::class.java)
                    intent.putExtra("gender", gender)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Пожалуйста, выберите пол", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}