package com.dev.myapplication.presenter

import com.dev.myapplication.model.BooksResponse

interface BooksPresenterInterface {
    fun buildBooksViewModel(booksList: List<BooksResponse>)
}