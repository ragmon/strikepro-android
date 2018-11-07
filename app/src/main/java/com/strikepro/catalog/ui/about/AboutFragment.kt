package com.strikepro.catalog.ui.about

import android.os.Build
import android.os.Bundle
import androidx.core.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.strikepro.catalog.R
import com.strikepro.catalog.di.Injectable

import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment(), Injectable, View.OnLongClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        brandLogo.setOnLongClickListener(this)

        loadDescriptionContent(view)

        super.onViewCreated(view, savedInstanceState)
    }

    private fun loadDescriptionContent(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            view.about_company_desc.text = Html.fromHtml(getString(R.string.about_longdesc), Html.FROM_HTML_MODE_LEGACY)
        } else {
            view.about_company_desc.text = Html.fromHtml(getString(R.string.about_longdesc))
        }
    }

    override fun onLongClick(v: View?): Boolean {
        Toast.makeText(activity, getString(R.string.developers), Toast.LENGTH_LONG).show()

        return true
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
