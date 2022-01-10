package com.example.sunmadinepal.framework.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.sunmadinepal.R
import com.example.sunmadinepal.framework.data.CustomAdapter


// Based on https://www.youtube.com/watch?v=3USvr1Lz8g8&t=49s

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var doctorAppointmentList = emptyList<DoctorAppointment>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var date : TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_home, parent, false)

        val holder = MyViewHolder(view)
        holder.date = view.findViewById(R.id.date)

        return MyViewHolder(view)
        //return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_home, parent, false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = doctorAppointmentList[position]
        holder.date.text = currentItem.date
    }

    override fun getItemCount(): Int {
        return doctorAppointmentList.size
    }

    fun setData(doctorAppointment: List<DoctorAppointment>) {
        this.doctorAppointmentList = doctorAppointment
        notifyDataSetChanged()
    }

}