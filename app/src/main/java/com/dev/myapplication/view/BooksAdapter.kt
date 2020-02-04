package com.dev.myapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dev.myapplication.R
import com.dev.myapplication.model.BooksResponse
import com.squareup.picasso.Picasso

class BooksAdapter : RecyclerView.Adapter<BooksViewHolder>() {

    private var bookList: List<BooksResponse> = listOf()

    override fun getItemCount(): Int = bookList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_books_list, parent, false))
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        getImage(bookList[position].imageURL.toString(), holder.bookImage)
        holder.bookText.text = bookList[position].title
    }

    fun getImage(url: String, imageView: ImageView) {
        if (url.isNotEmpty()) {
            val modifiedUrl: String = url.replace("http", "https")
            Picasso.get()
                .load(modifiedUrl)
                .resize(200, 200)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background).into(imageView)
        } else {
            Picasso.get().load(R.drawable.ic_launcher_background).into(imageView)
        }
    }

    fun setBooks(books: List<BooksResponse>) {
        this.bookList = books
        notifyDataSetChanged()
    }

}