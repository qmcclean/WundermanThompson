package com.dev.myapplication.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.myapplication.R

class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var bookImage: ImageView = view.findViewById(R.id.booksImageView)
    var bookText: TextView = view.findViewById(R.id.booksTextView)
}