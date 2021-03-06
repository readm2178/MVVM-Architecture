package com.rajkumarrajan.mvvm_architecture.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.ImageLoader
import coil.ImageLoader.Companion.Builder
import coil.request.LoadRequest
import coil.request.LoadRequest.Companion.Builder
import com.bumptech.glide.Glide
import com.rajkumarrajan.mvvm_architecture.R
import com.rajkumarrajan.mvvm_architecture.data.model.Customer
import com.rajkumarrajan.mvvm_architecture.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.item_layout2.view.*

class MainAdapter2(
    private val customers: ArrayList<Customer>
) : RecyclerView.Adapter<MainAdapter2.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(customer: Customer) {
            val imageLoader = Coil.imageLoader(itemView.imageViewAvatarr.context)
            val request = LoadRequest.Builder(itemView.context)
                .data(customer.avatar)
                .target(itemView.imageViewAvatarr)
                .build()
            imageLoader.execute(request)
//            Glide.with(itemView.imageViewAvatarr.context)
//                .load(customer.avatar)
//                .into(itemView.imageViewAvatarr)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout2, parent,
                false
            )
        )

    override fun getItemCount(): Int = customers.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(customers[position])

    fun addData(list: List<Customer>) {
        customers.addAll(list)
    }

}