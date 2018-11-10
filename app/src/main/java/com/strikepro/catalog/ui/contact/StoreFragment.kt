package com.strikepro.catalog.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.strikepro.catalog.R
import com.strikepro.catalog.di.Injectable

class StoreFragment : Fragment(), Injectable {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact_store, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = StoreFragment()
    }
}
