package com.strikepro.catalog.ui.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import com.strikepro.catalog.R
import com.strikepro.catalog.di.Injectable

/**
 * A simple [Fragment] subclass.
 * Use the [PostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostFragment : Fragment(), Injectable {
    private var paramPostId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramPostId = it.getInt(ARG_PARAM_POST_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    companion object {
        const val ARG_PARAM_POST_ID = "post_id"
        const val BACK_STACK_TAG = "post"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param postId Blog dummyPost ID.
         * @return A new instance of fragment PostFragment.
         */
        @JvmStatic
        fun newInstance(postId: Int) =
                PostFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_PARAM_POST_ID, postId)
                    }
                }

//        val dummyPost = Post(
//                1,
//                "Some dummy post title",
//                "https://picsum.photos/g/400/200",
//                "15.07.2016",
//                "Post short desc"
//        )
    }
}
