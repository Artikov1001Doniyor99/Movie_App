package com.artikov.modul5_lesson_3_4_movieapp

import Adapter.CinemaAdapter
import Kesh.MySharedPrefarance
import Models.Cinema
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var cineList:ArrayList<Cinema> = ArrayList()
    lateinit var cinemaAdapter: CinemaAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Movies"

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        loadData()
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rv.addItemDecoration(dividerItemDecoration)

    }

    private fun loadData() {
        MySharedPrefarance.init(this)
        cineList = MySharedPrefarance.obektString
        cinemaAdapter = CinemaAdapter(this,cineList,object : CinemaAdapter.OnMyItemClickListener{
            override fun onMyItemClickDelete(cinema: Cinema, position: Int) {
                cineList = MySharedPrefarance.obektString
                cineList.removeAt(position)
                MySharedPrefarance.obektString = cineList
                loadData()
                cinemaAdapter.notifyDataSetChanged()
                Toast.makeText(this@MainActivity, "Removed", Toast.LENGTH_SHORT).show()
            }

            override fun onMyItemClickEdit(cinema: Cinema, position: Int) {
                val intent = Intent(this@MainActivity, Edit::class.java)
                intent.putExtra("position", position)
                startActivity(intent)
            }

            override fun onMyLinClick(cinema: Cinema, position: Int) {
                val intent = Intent(this@MainActivity, Avengers::class.java)
                intent.putExtra("position", position)
                startActivity(intent)
            }

        })

        rv.adapter = cinemaAdapter

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        loadData()
        cinemaAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu):Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {

        when (item.itemId) {
            R.id.add_menu -> {
                val intent = Intent(this, addMovie::class.java)
                startActivity(intent)
                Toast.makeText(this, "Enter datas", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

}