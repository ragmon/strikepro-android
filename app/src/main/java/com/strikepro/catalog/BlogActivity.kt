package com.strikepro.catalog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.strikepro.catalog.fragment.blog.BlogFragment

class BlogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.blog_content, BlogFragment.newInstance(), BACK_STACK_TAG)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home && supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

//    override fun onBackStackChanged() {
//        Log.d(TAG, "onBackStackChanged")
//
//        supportFragmentManager.popBackStack()
//    }
//
//    override fun onBackPressed() {
//        Log.d(TAG, "onBackPressed")
//
//        super.onBackPressed()
//    }

    companion object {
        const val TAG = "BlogActivity"
        const val BACK_STACK_TAG = "blog"
    }

}
