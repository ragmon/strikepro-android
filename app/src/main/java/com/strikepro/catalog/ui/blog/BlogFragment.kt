package com.strikepro.catalog.ui.blog

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strikepro.catalog.R
import com.strikepro.catalog.binding.FragmentDataBindingComponent
import com.strikepro.catalog.common.AppExecutors
import com.strikepro.catalog.di.Injectable
import com.strikepro.catalog.ui.common.RetryCallback
import com.strikepro.catalog.util.autoCleared

import javax.inject.Inject

/**
 * The UI Controller for displaying a Blog Categories information with its posts.
 */
class BlogFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    // mutable for testing
    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
//    var binding by autoCleared<BlogFragmentBinding>()

    private lateinit var blogViewModel: BlogViewModel
//    private val adapter by autoCleared<CategoryAdapter>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        val dataBinding = DataBindingUtil.inflate<BlogFragmentBinding>(
//                inflater,
//                R.layout.fragment_blog,
//                container,
//                false,
//                dataBindingComponent
//        )
//        binding = dataBinding
//        return dataBinding.root

        return inflater.inflate(R.layout.fragment_blog, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        blogViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(BlogViewModel::class.java)

//        blogViewModel.getCategories().observe(this, Observer { categories ->
//            binding.categories = categories
//        })
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        post_list.adapter = PostAdapter(activity as Context)
//    }

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
