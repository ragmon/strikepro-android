package com.strikepro.catalog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem

import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

import com.google.android.material.navigation.NavigationView

import com.strikepro.catalog.R.layout.activity_main
import com.strikepro.catalog.common.FACEBOOK_URL
import com.strikepro.catalog.common.INSTAGRAM_URL
import com.strikepro.catalog.common.VKONTAKTE_URL
import com.strikepro.catalog.common.YOUTUBE_URL

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout as DrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
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

    // ### Navigation callbacks ###################################################################

    private fun navHomeItem() {
        // TODO: update main feed
    }

    private fun navCatalogItem() {
        startActivity(Intent(this, CatalogActivity::class.java))
    }

    private fun navBlogItem() {
        startActivity(Intent(this, BlogActivity::class.java))
    }

    private fun navWhereBuy() {
        startActivity(Intent(this, WherebuyActivity::class.java))
    }

    private fun navContactItem() {
        startActivity(Intent(this, ContactActivity::class.java))
    }

    private fun navAboutItem() {
        startActivity(Intent(this, AboutActivity::class.java))
    }

    // ### End of navigation callbacks ############################################################

    private fun openFacebook() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_URL)))
    }

    private fun openVk() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(VKONTAKTE_URL)))
    }

    private fun openYoutube() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(YOUTUBE_URL)))
    }

    private fun openInstagram() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(INSTAGRAM_URL)))
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

}
