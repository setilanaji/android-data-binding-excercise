package com.example.androiddatabinding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddatabinding.R
import com.example.androiddatabinding.model.UserModel

class UserAdapter ( private val context: Context, val items: MutableList<UserModel>): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = items[position]
        holder.name?.text = user.firstName + " " + user.lastName
        holder.email?.text = user.email
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class UserViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var name: TextView? = null
        var email: TextView? = null

        init {
            name = view.findViewById(R.id.tv_item_user_name)
            email = view.findViewById(R.id.tv_item_user_email)
        }

    }


}