package com.example.androiddatabinding.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddatabinding.R
import com.example.androiddatabinding.model.UserModel
import com.example.androiddatabinding.utils.ImageRoundedCorner
import com.squareup.picasso.Picasso

class UserAdapter (private val context: Context, val items: MutableList<UserModel>, private val  itemListener: UserAdapter.PostItemListener): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view, this.itemListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = items[position]
        holder.setData(user , position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): UserModel{
        return items[position]
    }

    interface PostItemListener {
        fun onPostClick(userModel: UserModel)
    }

    inner class UserViewHolder(var view: View, var itemListener: UserAdapter.PostItemListener): RecyclerView.ViewHolder(view), View.OnClickListener{
        var name: TextView? = null
        var email: TextView? = null
        var image: ImageView? = null
        var userModel: UserModel? = null

        init {

            name = view.findViewById(R.id.tv_item_user_name)
            email = view.findViewById(R.id.tv_item_user_email)
            image = view.findViewById(R.id.image_item_user_profile)
            view.setOnClickListener(this)


        }
        fun setData(userModel: UserModel, position: Int){
            userModel?.let {
                name?.text  = userModel.firstName + " " + userModel.lastName
                email?.text = userModel.email
                Picasso.get().load(userModel.avatarImgUrl).transform(ImageRoundedCorner()).into(this.image)
            }
            this.userModel = userModel
        }

        override fun onClick(v: View?) {
            val user = getItem(adapterPosition)
            this.itemListener.onPostClick(user)
            this@UserAdapter.notifyDataSetChanged()
        }

    }


}