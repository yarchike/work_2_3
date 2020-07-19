package com.yarchike.work_2_1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.postv_view.view.*



class PostAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Post> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.postv_view, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostViewHolder -> (
                    holder.bind(items[position])

                    )
        }
    }

    fun submiDataList(blockList: List<Post>) {
        items = blockList
    }

    class PostViewHolder
    constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val autorText = itemView.autorText
        val postText = itemView.postText
        val likeText = itemView.likeText
        val commentText = itemView.commentText
        val shareText = itemView.shareText
        val datePost = itemView.datePost
        val likeImage = itemView.likeImage

        fun bind(post: Post) {

            autorText.setText(post.autor)
            postText.setText(post.postText)

            if (post.like > 0) {
                likeText.setText(post.like.toString())
            } else {
                likeText.setText("")
            }
            if (post.comments > 0) {
                commentText.setText(post.comments.toString())
            } else {
                commentText.setText("")
            }
            if (post.share > 0) {
                shareText.setText(post.share.toString())
            } else {
                shareText.setText("")
            }


            val publishedAgo = (java.lang.System.currentTimeMillis() - post.date) / 1000
            val toMin = if (publishedAgo > 3599) {
                publishedAgo / 3600
            } else {
                publishedAgo / 60
            }
            val dateString = when (publishedAgo) {
                in 0..59 -> "менее минуты назад"
                in 60..179 -> "минуту назад"
                in 180..299 -> "$toMin минуты назад"
                in 300..3599 -> "$toMin минут назад"
                in 3600..17999 -> "$toMin часа назад"
                else -> "$toMin часов назад "
            }
            datePost.setText(dateString)
            likeImage.setOnClickListener{
                if (post.isLike) {
                    likeImage.setImageResource(R.drawable.ic_no_like)
                    likeText.setTextColor(Color.BLACK)
                  //  iteam.add(adapterPosition, post.copy(like = post.like - 1, isLike = false))
                } else {
                    likeImage.setImageResource(R.drawable.ic_like)
                    likeText.setTextColor(Color.RED)
                    //iteam.add(adapterPosition, post.copy(like = post.like + 1, isLike = true))

                }
            }

        }

    }


}