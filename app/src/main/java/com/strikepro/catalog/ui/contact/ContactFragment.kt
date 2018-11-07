package com.strikepro.catalog.ui.contact

import android.os.Bundle
import androidx.core.app.Fragment
import androidx.core.app.FragmentManager
import androidx.core.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strikepro.catalog.R
import com.strikepro.catalog.di.Injectable
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment(), Injectable {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup contact view pager
        contact_pager.adapter = ContactSlidePagerAdapter(childFragmentManager)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (contact_pager != null)
            outState.putInt(STATE_KEY_POSITION, contact_pager.currentItem)

        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if (savedInstanceState != null)
            contact_pager.currentItem = savedInstanceState.getInt(STATE_KEY_POSITION, 0)

        super.onViewStateRestored(savedInstanceState)
    }

    private class ContactSlidePagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                SLIDE_STORE_INDEX -> StoreFragment.newInstance()
                SLIDE_PARTNER_INDEX -> PartnerFragment.newInstance()
                else -> throw RuntimeException("Contact slide with position $position is not exists.")
            }
        }

        override fun getCount(): Int {
            return NUM_PAGES
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContactFragment()

        const val TAG = "ContactFragment"

        const val NUM_PAGES = 2

        const val SLIDE_STORE_INDEX = 0
        const val SLIDE_PARTNER_INDEX = 1

        const val STATE_KEY_POSITION = "slide_position"

        const val BACK_STACK_NAME = "contact"
    }
}
