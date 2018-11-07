package com.strikepro.catalog.ui.contact

import android.os.Bundle
import androidx.core.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strikepro.catalog.R
import com.strikepro.catalog.di.Injectable

class PartnerFragment : Fragment(), Injectable {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact_partner, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = PartnerFragment()
    }
}
