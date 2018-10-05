package com.strikepro.catalog.fragment

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strikepro.catalog.R
import com.strikepro.catalog.`interface`.IBackStack
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment(), IBackStack {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        loadDescriptionContent(view)

        return view
    }

    override fun onStart() {
        Log.d(TAG, "onStart")

        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")

        super.onResume()
    }

    private fun loadDescriptionContent(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            view.about_company_desc.text = Html.fromHtml(getString(R.string.about_longdesc), Html.FROM_HTML_MODE_LEGACY)
        } else {
            view.about_company_desc.text = Html.fromHtml(getString(R.string.about_longdesc))
        }
    }

    override fun getCurrentMenuItem(): Int {
        return R.id.nav_about
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment AboutFragment.
         */
        @JvmStatic
        fun newInstance() = AboutFragment()

        const val TAG = "AboutFragment"

        const val BACK_STACK_NAME = "about"
    }
}
