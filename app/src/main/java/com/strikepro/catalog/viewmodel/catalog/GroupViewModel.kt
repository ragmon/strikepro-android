package com.strikepro.catalog.viewmodel.catalog

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.strikepro.catalog.model.catalog.Group

class GroupViewModel: ViewModel() {
    private lateinit var groups: MutableLiveData<List<Group>>

    fun getGroups(): LiveData<List<Group>> {
        if (!::groups.isInitialized) {
            groups = MutableLiveData()
            loadGroups()
        }
        return groups
    }

    private fun loadGroups() {
        // Do an asynchronous operation to fetch groups
    }
}