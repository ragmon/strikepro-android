package com.strikepro.catalog.model

import android.net.Uri
import java.util.*

class Post {
    lateinit var logoUrl: Uri
    lateinit var title: String
    lateinit var timestamp: Date
    lateinit var intro: String
}