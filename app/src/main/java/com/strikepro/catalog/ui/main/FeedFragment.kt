package com.strikepro.catalog.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.strikepro.catalog.R
import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.binding.FragmentDataBindingComponent
import com.strikepro.catalog.common.AppExecutors
import com.strikepro.catalog.di.Injectable
import com.strikepro.catalog.ui.EmptyFragment
import com.strikepro.catalog.ui.about.AboutFragment
import com.strikepro.catalog.util.autoCleared
import com.strikepro.catalog.vo.ResourceType
import com.strikepro.catalog.vo.main.FeedCategory
import com.strikepro.catalog.vo.main.FeedItem

import kotlinx.android.synthetic.main.fragment_feed.*

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
    @Inject
    lateinit var appExecutors: AppExecutors

//    var binding by autoCleared<FeedFragmentBinding>()
    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    private lateinit var feedViewModel: FeedViewModel
    private var adapter by autoCleared<FeedListAdapter>()

//    private lateinit var feedViewModel: FeedViewModel
////
//    private lateinit var categories: LiveData<Resource<List<FeedCategory>>>
//    private lateinit var selectedCategory: LiveData<FeedCategory>
//    private lateinit var feedItems: LiveData<Resource<List<FeedItem>>>
//
//    private lateinit var mFeedPagerAdapter: FeedPagerAdapter

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
//        val dataBinding = DataBindingUtil.inflate<FeedFragmentBinding>(
//                inflater,
//                R.layout.fragment_feed,
//                container,
//                false,
//                dataBindingComponent
//        )
//        binding = dataBinding
//        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        feedViewModel = ViewModelProviders.of(this, viewModelFactory)
//                .get(FeedViewModel::class.java)
//
//        feedViewModel.getCategories().observe(this, Observer { categories ->
//            binding.categories = categories.data
//        })
//        val rvAdapter = FeedListAdapter(
//                dataBindingComponent = dataBindingComponent,
//                appExecutors = appExecutors
//        ) { feedItem ->
////            navController().navigate()
//        }
//        binding.itemsList.adapter = rvAdapter
//        this.adapter = rvAdapter
//        initItemsList()
    }

    private fun initItemsList() {
        feedViewModel.getItems().observe(this, Observer { items ->
            adapter.submitList(items?.data)
        })
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        mFeedPagerAdapter = FeedPagerAdapter(fragmentManager!!)
////        feed_pages.adapter = mFeedPagerAdapter
//
//        // TODO: remove ViewModel calls to layout <data>
//
//        feedViewModel = ViewModelProviders.of(this, viewModelFactory)
//                .get(FeedViewModel::class.java)
//
////        categories = feedViewModel.getCategories()
////        selectedCategory = feedViewModel.getSelectedCategory()
////        feedItems = feedViewModel.getItems()
////
////        categories.observe(this, categoriesObserver)
////        selectedCategory.observe(this, selectedCategoryObserver)
////        feedItems.observe(this, feedItemsObserver)
//    }

//    private val categoriesObserver = Observer<Resource<List<FeedCategory>>> {
//        if (it.data != null) {
//            Timber.d("Feed categories exists. Render it...")
//
//            mFeedPagerAdapter = FeedPagerAdapter(fragmentManager!!, it.data)
//            feed_pages.adapter = mFeedPagerAdapter
//        } else {
//            Timber.d("Feed categories not exists. Show empty fragment.")
//
//            //
//        }
//    }

//    private fun inflateCategoryTabItemLayout(name: String, type: ResourceType): View {
//        val view = LayoutInflater.from(activity).inflate(R.layout.feed_category_item, null)
//
////        view.category_icon. = type.type
//        view.category_title.text = name
//
//        return view
//    }


//    private val selectedCategoryObserver = Observer<FeedCategory> { selectedCategory ->
////        categoryType = selectedCategory.resource_type
//    }
//
//    private val feedItemsObserver = Observer<Resource<List<FeedItem>>> { items: Resource<List<FeedItem>> ->
////        items.forEach { item ->
////            item.
////        }
////        if (items.data != null && items.data.isNotEmpty()) {
////            for (item in items.data) {
////                feed_item.
////            }
////        }
//    }

    /**
     * Created to be able to override in tests
     */
    fun navController() = findNavController()

    class FeedPagerAdapter(
            fm: FragmentManager,
            private val categories: List<FeedCategory>
    ): FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = categories.size

        override fun getItem(position: Int): Fragment = EmptyFragment.newInstance()

        override fun getPageTitle(position: Int): CharSequence? = categories[position].resource_name
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
