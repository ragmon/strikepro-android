package com.strikepro.catalog.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.strikepro.catalog.R
import com.strikepro.catalog.model.Post
import kotlinx.android.synthetic.main.blog_item.view.*
import kotlinx.android.synthetic.main.fragment_blog.*

class BlogFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        post_list.adapter = PostAdapter(activity as Context)
    }

    private class PostAdapter(private val mContext: Context) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val postView: View = convertView ?: (mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                    .inflate(R.layout.blog_item, parent, false)

            val post: Post = dummyData[position]

            postView.post_logo.setImageResource(R.mipmap.ic_launcher) // TODO: replace to load from URLs
            postView.post_title.text = post.title
            postView.post_shortdesc.text = post.shortDesc
            postView.post_timestamp.text = post.timestamp
            postView.post_share.setOnClickListener { Log.d(TAG, "post_share button click") }

            return postView
        }

        override fun getItem(position: Int): Any? = null

        override fun getItemId(position: Int): Long = 0L

        override fun getCount(): Int = dummyData.size

        companion object {
            const val TAG: String = "PostAdapter"

            val dummyData: Array<Post> = arrayOf(
                    Post("1 post title", "https://picsum.photos/g/400/200", "14.06.2015", "1 post short desc"),
                    Post("2 post title", "https://picsum.photos/g/400/200", "15.07.2016", "2 post short desc"),
                    Post("3 post title", "https://picsum.photos/g/400/200", "16.08.2017", "3 post short desc")
            )
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment BlogFragment.
         */
        @JvmStatic
        fun newInstance() = BlogFragment()
    }
}
