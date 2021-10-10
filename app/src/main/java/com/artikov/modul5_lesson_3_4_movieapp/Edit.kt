package com.artikov.modul5_lesson_3_4_movieapp

import Kesh.MySharedPrefarance
import Models.Cinema
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_movie.*

class Edit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        supportActionBar?.title = "Edit movie"

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val position = intent.getIntExtra("position",0)
        MySharedPrefarance.init(this)

        val array = MySharedPrefarance.obektString
        edt_movies_name.setText(array[position].name)
        edt_about_movies.setText(array[position].about)
        edt_aithors_movie.setText(array[position].muallif)
        edt_movie_date.setText(array[position].sana)
        btn_save.text = "Edit"

        btn_save.setOnClickListener {
            val name = edt_movies_name.text.toString().trim()
            val about = edt_about_movies.text.toString().trim()
            val authors = edt_aithors_movie.text.toString().trim()
            val data = edt_movie_date.text.toString().trim()

            array[position] = Cinema(name, authors, about, data)
            MySharedPrefarance.obektString = array
            Toast.makeText(this, "Edit movies", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}