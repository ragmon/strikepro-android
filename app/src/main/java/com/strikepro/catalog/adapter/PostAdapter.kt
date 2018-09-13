package com.strikepro.catalog.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strikepro.catalog.R
import com.strikepro.catalog.model.Post
import kotlinx.android.synthetic.main.blog_item.view.*

class PostAdapter(private val items: ArrayList<Post>, private val context: Context) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.blog_item, parent, false))
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        holder.postLogo = items[position].logoUrl
        holder.postTitle.text = items[position].title
//        holder.postTimestamp = items[position].
//        holder.shortDesc = items[position].shortDesc
    }

    class PostViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val postLogo = view.post_logo
        var postTitle = view.post_title
        val shortDesc = view.post_shortdesc
        val postTimestamp = view.post_timestamp
    }
}