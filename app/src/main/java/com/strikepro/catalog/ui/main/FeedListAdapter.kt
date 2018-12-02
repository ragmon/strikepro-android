package com.strikepro.catalog.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil

import com.strikepro.catalog.R
import com.strikepro.catalog.common.AppExecutors
import com.strikepro.catalog.databinding.FeedItemBinding
import com.strikepro.catalog.ui.common.DataBoundListAdapter
import com.strikepro.catalog.vo.main.FeedItem

/**
 * A RecyclerView adapter for [FeedItem] class.
 */
class FeedListAdapter(
        private val dataBindingComponent: DataBindingComponent,
        appExecutors: AppExecutors,
        private val feedItemClickCallback: ((FeedItem) -> Unit)?
) : DataBoundListAdapter<FeedItem, FeedItemBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<FeedItem>() {
            override fun areItemsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean =
                    oldItem.resourceType == newItem.resourceType
                    && oldItem.resourceId == newItem.resourceId
        }
) {
    override fun createBinding(parent: ViewGroup): FeedItemBinding {
        val binding = DataBindingUtil.inflate<FeedItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.feed_item,
                parent,
                false,
                dataBindingComponent
        )
        binding.root.setOnClickListener {
            binding.feedItem?.let {
                feedItemClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: FeedItemBinding, item: FeedItem) {
        binding.feedItem = item
    }
}