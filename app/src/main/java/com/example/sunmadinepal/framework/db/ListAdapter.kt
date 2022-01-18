package com.example.sunmadinepal.framework.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentDateListBinding
import com.example.sunmadinepal.databinding.FragmentProfileBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var doctorAppointmentList = emptyList<DoctorAppointment>()

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.fragment_date_list, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = doctorAppointmentList[position]
        holder.view.findViewById<TextView>(R.id.dateBox1).text = currentItem.date
    }

    override fun getItemCount(): Int {
        return doctorAppointmentList.size
    }

    fun setData(doctorAppointment: List<DoctorAppointment>) {
        this.doctorAppointmentList = doctorAppointment
        notifyDataSetChanged()
    }

}