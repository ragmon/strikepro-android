package com.strikepro.catalog.fragment.contact

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strikepro.catalog.R
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup contact view pager
        contact_pager.adapter = ContactSlidePagerAdapter(childFragmentManager)
        contact_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                when (position) {
                    SLIDE_STORE_INDEX -> setSlideNavButtonsState(false, true)
                    SLIDE_PARTNER_INDEX -> setSlideNavButtonsState(true, false)
                    else -> setSlideNavButtonsState(false, false)
                }
            }
        })
        setSlideNavButtonsState(false, true)

        // Setup contact view pager navigation buttons
        btnSwipeRight.setOnClickListener {
            contact_pager.setCurrentItem(contact_pager.currentItem + 1, true)
        }
        btnSwipeLeft.setOnClickListener {
            contact_pager.setCurrentItem(contact_pager.currentItem - 1, true)
        }
    }

    @SuppressLint("RestrictedApi")
    private fun setSlideNavButtonsState(left: Boolean, right: Boolean) {
        btnSwipeLeft.visibility = if (left) View.VISIBLE else View.GONE
        btnSwipeRight.visibility = if (right) View.VISIBLE else View.GONE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(STATE_KEY_POSITION, contact_pager.currentItem)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        if (savedInstanceState != null) {
            contact_pager.currentItem = savedInstanceState.getInt(STATE_KEY_POSITION, 0)
        }
    }

    private class ContactSlidePagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            when (position) {
                SLIDE_STORE_INDEX -> return StoreFragment.newInstance()
                SLIDE_PARTNER_INDEX -> return PartnerFragment.newInstance()
                else -> {
                    throw RuntimeException("Contact slide with position $position is not exists.")
                }
            }
        }

        override fun getCount(): Int {
            return NUM_PAGES
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContactFragment()

        const val NUM_PAGES = 2
        const val TAG = "ContactFragment"

        const val SLIDE_STORE_INDEX = 0
        const val SLIDE_PARTNER_INDEX = 1

        const val STATE_KEY_POSITION = "slide_position"
    }
}
