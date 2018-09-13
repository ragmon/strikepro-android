package com.strikepro.catalog

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.strikepro.catalog.fragment.AboutFragment
import com.strikepro.catalog.fragment.BlogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        selectDefaultNavItem()
    }

    private fun selectDefaultNavItem() {
        selectBlogItem()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> selectHomeItem()
            R.id.nav_catalog -> selectCatalogItem()
            R.id.nav_blog -> selectBlogItem()
            R.id.nav_contact -> selectContactsItem()
            R.id.nav_about -> selectAboutItem()
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun selectHomeItem() {
        //
    }

    private fun selectCatalogItem() {
        //
    }

    private fun selectBlogItem() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_content, BlogFragment.newInstance())
                .commit()
        nav_view.setCheckedItem(R.id.nav_blog)
    }

    private fun selectContactsItem() {
        //
    }

    private fun selectAboutItem() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_content, AboutFragment.newInstance())
                .commit()
    }
}
