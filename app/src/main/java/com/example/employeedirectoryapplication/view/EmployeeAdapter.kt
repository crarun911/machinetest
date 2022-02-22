package com.example.employeedirectoryapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.employeedirectoryapplication.api.EmployeeItem
import com.example.employeedirectoryapplication.databinding.EmployeeItemBinding

class EmployeeAdapter(private val itemClick: onItemClick):androidx.recyclerview.widget.ListAdapter<EmployeeItem,EmployeeAdapter.EmployeeViewHolder>(EmployeeDiffutil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
       val binding=EmployeeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val currentItem=getItem(position)
        if (currentItem!=null){
            holder.bind(currentItem)
        }

    }

    inner class EmployeeViewHolder(private val binding: EmployeeItemBinding):
        RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                val item = getItem(position)
                itemClick.onItemClick(item)
            }


        }



            fun bind(employeeItem: EmployeeItem){
                binding.apply {
                    Glide.with(itemView)
                        .load(employeeItem.profile_image)
                        .into(imageViewProfile)
                    textViewName.text=employeeItem.name
                    textViewCompanyname.text=employeeItem.company.name
                }

            }
        }

    class EmployeeDiffutil:DiffUtil.ItemCallback<EmployeeItem>(){
        override fun areItemsTheSame(oldItem: EmployeeItem, newItem: EmployeeItem)=
           oldItem.id==newItem.id


        override fun areContentsTheSame(oldItem: EmployeeItem, newItem: EmployeeItem) =
            oldItem==newItem


    }

    interface onItemClick {
        fun onItemClick(item: EmployeeItem)
    }



}