package com.strikepro.catalog.fragment

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strikepro.catalog.R
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        loadDescriptionContent(view)

        return view
    }

    private fun loadDescriptionContent(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            view.about_company_desc.text = Html.fromHtml(getString(R.string.about_longdesc), Html.FROM_HTML_MODE_LEGACY)
        } else {
            view.about_company_desc.text = Html.fromHtml(getString(R.string.about_longdesc))
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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
    }
}
