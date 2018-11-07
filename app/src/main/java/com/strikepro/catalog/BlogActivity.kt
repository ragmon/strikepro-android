package com.strikepro.catalog

import android.os.Bundle
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.strikepro.catalog.ui.blog.BlogFragment
import com.strikepro.catalog.ui.blog.PostFragment

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

import timber.log.Timber

import javax.inject.Inject

class BlogActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        if (savedInstanceState == null) {
            // Open blog post fragment
            if (intent.hasExtra(PostFragment.ARG_PARAM_POST_ID)) {
                val postID: Int = intent.getIntExtra("post_id", -1)

                showPostFragment(postID)
            }
            // Open blog categories & post list fragment
            else {
                val categoryID: Int? =
                        if (intent.hasExtra("category_id"))
                            intent.getIntExtra("category_id", -1)
                        else
                            null

                showBlogFragment(categoryID)
            }
        }
    }

    /**
     * Show blog fragment with categories & related posts
     *
     * @param categoryID
     */
    private fun showBlogFragment(categoryID: Int?) {
        Timber.d("Open blog categories & post list with category ID #%d", categoryID)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.blog_content, BlogFragment.newInstance(categoryID), BlogFragment.BACK_STACK_TAG)
                .commit()
    }

    /**
     * Show post fragment by post ID.
     *
     * @param postID
     */
    private fun showPostFragment(postID: Int) {
        Timber.d("Open blog post with ID #%d", postID)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.blog_content, PostFragment.newInstance(postID), PostFragment.BACK_STACK_TAG)
                .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home && supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

}
