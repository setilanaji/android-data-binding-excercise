package com.example.androiddatabinding.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddatabinding.R
import com.example.androiddatabinding.model.PostModel
import com.example.androiddatabinding.model.UserModel

class PostAdapter (private val context: Context, private val items: List<PostModel>, private val  itemListener: PostAdapter.PostItemListener): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view, this.itemListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = items[position]
        holder.title?.text = post.title
        holder.body?.text = post.body    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): PostModel{
        return items[position]
    }

    interface PostItemListener {
        fun onPostClick(postModel: PostModel)
    }

    inner class PostViewHolder(var view: View, var itemListener: PostAdapter.PostItemListener): RecyclerView.ViewHolder(view), View.OnClickListener{
        var title: TextView? = null
        var body: TextView? = null

        init {
            title = view.findViewById(R.id.tv_item_post_title)
            body = view.findViewById(R.id.tv_item_post_body)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val post = getItem(adapterPosition)
            this.itemListener.onPostClick(post)
            this@PostAdapter.notifyDataSetChanged()

        }

    }

}