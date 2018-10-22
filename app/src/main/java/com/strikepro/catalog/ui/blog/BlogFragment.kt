package com.strikepro.catalog.ui.blog

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strikepro.catalog.R
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

    companion object {
        const val ARG_PARAM_CATEGORY_ID = "category_id"
        const val BACK_STACK_TAG = "post_list"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param categoryId Blog category ID.
         * @return A new instance of fragment BlogFragment.
         */
        @JvmStatic
        fun newInstance(categoryId: Int? = null) = BlogFragment().apply {
            arguments = Bundle().apply {
                if (categoryId != null)
                    putInt(ARG_PARAM_CATEGORY_ID, categoryId)
            }
        }
    }
}
