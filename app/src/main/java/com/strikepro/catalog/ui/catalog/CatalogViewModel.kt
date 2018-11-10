package com.strikepro.catalog.ui.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.repository.CatalogRepository
import com.strikepro.catalog.util.AbsentLiveData
import com.strikepro.catalog.vo.catalog.Article
import com.strikepro.catalog.vo.catalog.Group

import javax.inject.Inject

class CatalogViewModel @Inject constructor(
        private val catalogRepository: CatalogRepository
) : ViewModel() {
    private val selectedGroup = MutableLiveData<Group>()
    private val groups: LiveData<Resource<List<Group>>> = Transformations
            .switchMap(selectedGroup) { selectedGroup ->
                if (selectedGroup == null)
                    AbsentLiveData.create()
                else
                    catalogRepository.loadGroupList(selectedGroup.id)
            }
    private val articles: LiveData<Resource<List<Article>>> = Transformations
            .switchMap(selectedGroup) { selectedGroup ->
                if (selectedGroup != null && selectedGroup.isProduct == true)
                    catalogRepository.loadArticleList(selectedGroup.id)
                else
                    AbsentLiveData.create()
            }

    fun getSelectedGroup(): LiveData<Group> = selectedGroup
    fun selectGroup(group: Group) {
        selectedGroup.value = group
    }
}