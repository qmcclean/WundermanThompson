package com.dev.myapplication.view

import com.dev.myapplication.model.BooksResponse

interface BooksActivityInterface {
    fun updateBooksList(booksList: List<BooksResponse>)
}