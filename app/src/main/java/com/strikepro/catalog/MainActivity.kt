package com.strikepro.catalog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.strikepro.catalog.`interface`.IBackStack
import com.strikepro.catalog.fragment.AboutFragment
import com.strikepro.catalog.fragment.blog.BlogFragment
import com.strikepro.catalog.fragment.contact.ContactFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        supportFragmentManager.addOnBackStackChangedListener(this)

        nav_view.setNavigationItemSelectedListener(this)

        Log.d(TAG, "onCreate")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.d(TAG, "onRestoreInstanceState")

        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(TAG, "onSaveInstanceState")

        super.onSaveInstanceState(outState)
    }

    override fun onBackStackChanged() {
        Log.d(TAG, "onBackStackChanged")

        getCurrentMenuItem()?.isChecked = true
    }

    private fun getCurrentMenuItem(): MenuItem? {
        return if (supportFragmentManager.backStackEntryCount - 1 >= 0) {
            val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.frame_content)
            val menuItemId: Int? = if (fragment is IBackStack)
                (fragment as IBackStack).getCurrentMenuItem()
            else
                null

            if (menuItemId != null)
                nav_view.menu.findItem(menuItemId)
            else
                null
        }
        else
            null
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
                .addToBackStack(BlogFragment.BACK_STACK_NAME)
                .commit()
    }

    private fun navWhereBuy() {
        //
    }

    private fun navContactItem() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_content, ContactFragment.newInstance())
                .addToBackStack(ContactFragment.BACK_STACK_NAME)
                .commit()
    }

    private fun navAboutItem() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_content, AboutFragment.newInstance())
                .addToBackStack(AboutFragment.BACK_STACK_NAME)
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
    }
}
