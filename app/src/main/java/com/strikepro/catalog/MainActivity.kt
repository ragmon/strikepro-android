package com.strikepro.catalog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.strikepro.catalog.fragment.AboutFragment
import com.strikepro.catalog.fragment.BlogFragment
import com.strikepro.catalog.fragment.contact.ContactFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mainMenuItemChanged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null || !savedInstanceState.getBoolean(KEY_MAIN_MENU_ITEM_CHANGE_STATUS, false)) {
            selectDefaultNavItem()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putBoolean(KEY_MAIN_MENU_ITEM_CHANGE_STATUS, mainMenuItemChanged)

        super.onSaveInstanceState(outState)
    }

    /**
     * Select the default navigation item.
     */
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
            // Common navigation items
            R.id.nav_home -> selectHomeItem()
            R.id.nav_catalog -> selectCatalogItem()
            R.id.nav_blog -> selectBlogItem()
            R.id.nav_wherebuy -> selectWhereBuy()
            // Secondary navigation items
            R.id.nav_contact -> selectContactItem()
            R.id.nav_about -> selectAboutItem()
            // Social buttons
            R.id.open_facebook -> openFacebook()
            R.id.open_vk -> openVk()
            R.id.open_youtube -> openYoutube()
            R.id.open_instagram -> openInstagram()
        }

        mainMenuItemChanged = true

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

    private fun selectWhereBuy() {
        //
    }

    private fun selectContactItem() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_content, ContactFragment.newInstance())
                .commit()
    }

    private fun selectAboutItem() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_content, AboutFragment.newInstance())
                .commit()
    }

    private fun openFacebook() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/StrikeProRussia")))
    }

    private fun openVk() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/strikepro")))
    }

    private fun openYoutube() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/StrikeProRussia")))
    }

    private fun openInstagram() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/strikeprorussia")))
    }

    companion object {
        const val TAG = "MainActivity"

        const val KEY_MAIN_MENU_ITEM_CHANGE_STATUS = "main_menu_item_changed"
    }
}
