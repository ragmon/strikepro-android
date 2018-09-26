package com.strikepro.catalog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.strikepro.catalog.fragment.AboutFragment
import com.strikepro.catalog.fragment.BlogFragment
import com.strikepro.catalog.fragment.contact.ContactFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var currentMainMenuItemIndex: Int = DEFAULT_MAIN_MENU_ITEM_INDEX

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        selectDefaultNavItem(savedInstanceState?.getInt(KEY_MAIN_MENU_ITEM_CHANGE_STATUS, -1))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.d(TAG, "onRestoreInstanceState; ${savedInstanceState?.getInt(KEY_MAIN_MENU_ITEM_CHANGE_STATUS, -1)}")

        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(TAG, "onSaveInstanceState; $KEY_MAIN_MENU_ITEM_CHANGE_STATUS=${outState?.putInt(KEY_MAIN_MENU_ITEM_CHANGE_STATUS, currentMainMenuItemIndex)}")

        outState?.putInt(KEY_MAIN_MENU_ITEM_CHANGE_STATUS, currentMainMenuItemIndex)

        super.onSaveInstanceState(outState)
    }

    /**
     * Select the default navigation item.
     *
     * @param lastItemIndex Last selected main menu item index.
     */
    private fun selectDefaultNavItem(@IdRes lastItemIndex: Int?) {
        Log.d(TAG, "selectDefaultNavItem; lastIndex = ${lastItemIndex ?: DEFAULT_MAIN_MENU_ITEM_INDEX}")

        val itemIndex: Int = lastItemIndex ?: DEFAULT_MAIN_MENU_ITEM_INDEX

        nav_view.setCheckedItem(itemIndex)
        onNavigationItemSelected(nav_view.menu.findItem(itemIndex))
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "onNavigationItemSelected; item = ${item.itemId}")

        // Handle navigation view item clicks here.
        when (item.itemId) {
            // Common navigation items
            R.id.nav_home -> navHomeItem()
            R.id.nav_catalog -> navCatalogItem()
            R.id.nav_blog -> navBlogItem()
            R.id.nav_wherebuy -> navWhereBuy()
            // Secondary navigation items
            R.id.nav_contact -> navContactItem()
            R.id.nav_about -> navAboutItem()
            // Social buttons
            R.id.open_facebook -> openFacebook()
            R.id.open_vk -> openVk()
            R.id.open_youtube -> openYoutube()
            R.id.open_instagram -> openInstagram()
        }

        currentMainMenuItemIndex = item.itemId

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun navHomeItem() {
        //
    }

    private fun navCatalogItem() {
        //
    }

    private fun navBlogItem() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_content, BlogFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }

    private fun navWhereBuy() {
        //
    }

    private fun navContactItem() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_content, ContactFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }

    private fun navAboutItem() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_content, AboutFragment.newInstance())
                .addToBackStack(null)
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
        const val TAG: String = "MainActivity"

        const val KEY_MAIN_MENU_ITEM_CHANGE_STATUS: String = "main_menu_item_changed"

        const val DEFAULT_MAIN_MENU_ITEM_INDEX: Int = R.id.nav_blog
    }
}
