package com.strikepro.catalog.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.strikepro.catalog.R
import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.di.Injectable
import com.strikepro.catalog.vo.ResourceType
import com.strikepro.catalog.vo.main.FeedCategory
import com.strikepro.catalog.vo.main.FeedItem
import timber.log.Timber

import javax.inject.Inject

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM_CATEGORY_TYPE = "category_type"

/**
 * A simple [Fragment] subclass.
 * Use the [FeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FeedFragment : Fragment(), Injectable {
//    private lateinit var categoryType: ResourceType

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var feedViewModel: FeedViewModel
//
    private lateinit var categories: LiveData<Resource<List<FeedCategory>>>
    private lateinit var selectedCategory: LiveData<FeedCategory>
    private lateinit var feedItems: LiveData<Resource<List<FeedItem>>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            if (it.getString(ARG_PARAM_CATEGORY_TYPE) != null)
//                categoryType = ResourceType.valueOf(it.getString(ARG_PARAM_CATEGORY_TYPE)!!)
//        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        feedViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(FeedViewModel::class.java)

        categories = feedViewModel.getCategories()
        selectedCategory = feedViewModel.getSelectedCategory()
        feedItems = feedViewModel.getItems()

        categories.observe(this, categoriesObserver)
        selectedCategory.observe(this, selectedCategoryObserver)
        feedItems.observe(this, feedItemsObserver)
    }

    private val categoriesObserver = Observer<Resource<List<FeedCategory>>> {
//        Timber.d("categoriesObserver")
//        categories.sortedBy { feedCategory ->
//            feedCategory.order
//        }.forEach { category ->
//            feed_category.addView(inflateCategoryTabItemLayout(category.resource_name, category.resource_type))
//        }

//        if (categories != null) {
//            //
//        } else {
//            //
//        }
        if (it.data != null) {
            Timber.d("categoriesObserver total=%d", it.data.size)
        }
    }

//    private fun inflateCategoryTabItemLayout(name: String, type: ResourceType): View {
//        val view = LayoutInflater.from(activity).inflate(R.layout.feed_category_item, null)
//
////        view.category_icon. = type.type
//        view.category_title.text = name
//
//        return view
//    }


    private val selectedCategoryObserver = Observer<FeedCategory> { selectedCategory ->
//        categoryType = selectedCategory.resource_type
    }

    private val feedItemsObserver = Observer<Resource<List<FeedItem>>> { items: Resource<List<FeedItem>> ->
//        items.forEach { item ->
//            item.
//        }
//        if (items.data != null && items.data.isNotEmpty()) {
//            for (item in items.data) {
//                feed_item.
//            }
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param resourceType Feed items resource type (category).
         * @return A new instance of fragment FeedFragment.
         */
        @JvmStatic
        fun newInstance(resourceType: ResourceType = ResourceType.ALL) =
                FeedFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM_CATEGORY_TYPE, resourceType.type)
                    }
                }
    }
}
