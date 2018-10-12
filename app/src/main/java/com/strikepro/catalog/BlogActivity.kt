package com.strikepro.catalog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.strikepro.catalog.fragment.blog.BlogFragment
import com.strikepro.catalog.fragment.blog.PostFragment

class BlogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        if (savedInstanceState == null) {
            // Open blog post fragment
            if (intent.hasExtra(PostFragment.ARG_PARAM_POST_ID)) {
                val postId: Int = intent.getIntExtra("post_id", -1)

                Log.d(TAG, "Open blog post with ID #$postId")

                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.blog_content, PostFragment.newInstance(postId), PostFragment.BACK_STACK_TAG)
                        .commit()
            }
            // Open blog categories & post list fragment
            else {
                val categoryId: Int? =
                        if (intent.hasExtra("category_id"))
                            intent.getIntExtra("category_id", -1)
                        else
                            null

                Log.d(TAG, "Open blog categories & post list with category ID #$categoryId")

                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.blog_content, BlogFragment.newInstance(categoryId), BlogFragment.BACK_STACK_TAG)
                        .commit()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home && supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val TAG = "BlogActivity"
    }

}
