package com.strikepro.catalog.fragment.contact

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strikepro.catalog.R

class PartnerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact_partner, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = PartnerFragment()
    }
}
