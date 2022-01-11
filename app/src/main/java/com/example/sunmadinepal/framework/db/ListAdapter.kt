package com.example.sunmadinepal.framework.db

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sunmadinepal.databinding.FragmentDateListBinding
import com.example.sunmadinepal.databinding.FragmentProfileBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var doctorAppointmentList = emptyList<DoctorAppointment>()

    class MyViewHolder(val binding: FragmentDateListBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(FragmentDateListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = doctorAppointmentList[position]
        holder.binding.dateBox1.text = currentItem.date
    }

    override fun getItemCount(): Int {
        return doctorAppointmentList.size
    }

    fun setData(doctorAppointment: List<DoctorAppointment>) {
        this.doctorAppointmentList = doctorAppointment
        notifyDataSetChanged()
    }

}