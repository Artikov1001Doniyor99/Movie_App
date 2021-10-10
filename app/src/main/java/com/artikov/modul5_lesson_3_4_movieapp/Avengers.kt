package com.artikov.modul5_lesson_3_4_movieapp

import Kesh.MySharedPrefarance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_avengers.*

class Avengers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)



        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val position =intent.getIntExtra("position",0)

        MySharedPrefarance.init(this)
        val array = MySharedPrefarance.obektString

        val name = array[position].name
        val authors = array[position].muallif
        val about = array[position].about
        val data = array[position].sana

        supportActionBar?.title = name

        txt_name.text = "${txt_name.text} $name"
        txt_about.text = "${txt_about.text} $about"
        txt_authors.text = "${txt_authors.text} $authors"
        txt_data.text = "${txt_data.text} $data"

        btn_close.setOnClickListener {
            finish()
        }

    }
}