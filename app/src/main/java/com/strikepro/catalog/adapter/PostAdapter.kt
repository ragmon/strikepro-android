package com.strikepro.catalog.adapter

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.strikepro.catalog.R
import com.strikepro.catalog.fragment.blog.PostFragment
import com.strikepro.catalog.vo.blog.Post
import kotlinx.android.synthetic.main.blog_item.view.*

class PostAdapter(private val mContext: Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val postView: View = convertView ?: (mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.blog_item, parent, false)

//        val post: Post = dummyData[position]

//        postView.post_logo.setImageResource(R.mipmap.ic_launcher) // TODO: replace to load from URLs
//        postView.post_title.text = post.title
//        postView.post_shortdesc.text = post.shortDesc
//        postView.post_timestamp.text = post.timestamp
//        postView.setOnClickListener {
//            Log.d(TAG, "click on post item with position = $position")
//
//            (mContext as FragmentActivity).supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.blog_content, PostFragment.newInstance(0 /* TODO: feature do replace by real post ID */))
//                    .addToBackStack("post")
//                    .commit()
//        }
//        postView.post_share.setOnClickListener {
//            Log.d(TAG, "postView.post_share click; position = $position")
//        }

        return postView
    }

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    override fun getCount(): Int = dummyData.size

    companion object {
        const val TAG: String = "PostAdapter"

        val dummyData: Array<Post> = arrayOf(
//                Post(1, "1 dummy", "https://picsum.photos/g/400/200", "14.06.2015", "1 dummyPost short desc"),
//                Post(2, "2 dummy", "https://picsum.photos/g/400/200", "15.07.2016", "2 dummyPost short desc"),
//                Post(3, "3 dummy", "https://picsum.photos/g/400/200", "16.08.2017", "3 dummyPost short desc")
        )
    }

}