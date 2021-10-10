package com.artikov.modul5_lesson_3_4_movieapp

import Kesh.MySharedPrefarance
import Models.Cinema
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_movie.*

class addMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        MySharedPrefarance.init(this)

        supportActionBar?.title = "Add movie"

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        btn_save.setOnClickListener {
            val arrayCinema = MySharedPrefarance.obektString

            val name = edt_movies_name.text.toString().trim()
            val authors = edt_aithors_movie.text.toString().trim()
            val about = edt_about_movies.text.toString().trim()
            val date = edt_movie_date.text.toString().trim()

            if (name.isNotEmpty() && authors.isNotEmpty() && date.isNotEmpty() && about.isNotEmpty()) {
                arrayCinema.add(Cinema(name, authors, about, date))
                println(arrayCinema)

                MySharedPrefarance.obektString = arrayCinema
                finish()
            }else{
                Toast.makeText(this, "Enter is full", Toast.LENGTH_SHORT).show()
            }

        }

    }
}