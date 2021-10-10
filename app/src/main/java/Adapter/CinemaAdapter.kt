package Adapter

import Models.Cinema
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artikov.modul5_lesson_3_4_movieapp.R
import kotlinx.android.synthetic.main.item_view_rv.view.*
import java.text.FieldPosition

class CinemaAdapter(val context:Context,var cinemaList: List<Cinema>,val myItemClickListener: OnMyItemClickListener)
    :RecyclerView.Adapter<CinemaAdapter.MyHolder>(){

    inner class MyHolder(var itemView: View): RecyclerView.ViewHolder(itemView){
        @SuppressLint("SetTextI18n")
        fun onBind(cinema: Cinema, position: Int){
            if (cinema.name.length > 10) {
                itemView.txt_name_item_rv.text = cinema.name.subSequence(0,10).toString() + "..."
            }else{
                itemView.txt_name_item_rv.text = cinema.name
            }
            if (cinema.muallif.length >= 32) {
                itemView.txt_authors.text = cinema.muallif.subSequence(0,32).toString() + "..."
            }else{
                itemView.txt_authors.text = cinema.muallif
            }
            if (cinema.sana.length > 10) {
                itemView.txt_sana_item_rv.text = cinema.sana.subSequence(0,10).toString() + "..."
            }else{
                itemView.txt_sana_item_rv.text = cinema.sana
            }

            itemView.btn_delete.setOnClickListener {
                myItemClickListener.onMyItemClickDelete(cinema,position)
            }

            itemView.btn_edit.setOnClickListener {
                myItemClickListener.onMyItemClickEdit(cinema, position)
            }

            itemView.lin_rv.setOnClickListener {
                myItemClickListener.onMyLinClick(cinema, position)
            }

        }
    }

    interface OnMyItemClickListener{
        fun onMyItemClickDelete(cinema: Cinema,position: Int)
        fun onMyItemClickEdit(cinema: Cinema,position: Int)
        fun onMyLinClick(cinema: Cinema,position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaAdapter.MyHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view_rv,parent,false)
        val myHolder = MyHolder(itemView)
        return myHolder
    }

    override fun onBindViewHolder(holder: CinemaAdapter.MyHolder, position: Int) {
        holder.onBind(cinemaList[position],position)
    }

    override fun getItemCount(): Int {
        return cinemaList.size
    }

}