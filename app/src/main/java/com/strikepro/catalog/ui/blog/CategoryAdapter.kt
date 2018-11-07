package com.strikepro.catalog.ui.blog

import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil

import android.support.v7.util.DiffUtil

import android.view.LayoutInflater
import android.view.ViewGroup

import com.strikepro.catalog.R

import com.strikepro.catalog.common.AppExecutors
import com.strikepro.catalog.ui.common.DataBoundListAdapter
import com.strikepro.catalog.vo.blog.Category

//import com.strikepro.catalog.databinding.CategoryItemBinder

//class CategoryAdapter(
//        private val dataBindingComponent: DataBindingComponent,
//        appExecutors: AppExecutors,
//        private val callback: ((Category) -> Unit)?
//) : DataBoundListAdapter<Category, CategoryItemBinding>(
//        appExecutors = appExecutors,
//        diffCallback = object : DiffUtil.ItemCallback<Category>() {
//            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean
//                    = oldItem.id == newItem.id
//
//            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean
//                    = oldItem.id == newItem.id && oldItem.updated_at == newItem.updated_at
//        }
//) {
//    override fun createBinding(parent: ViewGroup): CategoryItemBinder {
//        val binding = DataBindingUtil
//                .inflate<CategoryItemBinder>(
//                        LayoutInflater.from(parent.context),
//                        R.layout.blog_category_item,
//                        parent,
//                        false,
//                        dataBindingComponent
//                )
//        binding.root.setOnClickListener {
//            binding.category?.let {
//                callback?.invoke(it)
//            }
//        }
//        return binding
//    }
//
//    override fun bind(binding: CategoryItemBinding, item: Category) {
//        binding.category = item
//    }
//}