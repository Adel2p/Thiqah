package com.ebc.ipnapplication.ui.login.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebc.ipnapplication.R
import com.ebc.ipnapplication.data.database.repository.post.Post
import kotlinx.android.synthetic.main.item_post_list.view.*

class PostsAdapter(private val postListItems: MutableList<Post>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun getItemCount() = this.postListItems.size
    internal fun addBlogsToList(blogs: List<Post>) {
        this.postListItems.addAll(blogs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_post_list, parent, false)
    )

    inner class PostViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.txtTitle.text = ""
        }

        fun onBind(position: Int) {

            // val (title) = postListItems[position]
            inflateData(postListItems[position].title)
        }

        private fun inflateData(title: String?) {
            title?.let { itemView.txtTitle.text = it }
        }
    }

}