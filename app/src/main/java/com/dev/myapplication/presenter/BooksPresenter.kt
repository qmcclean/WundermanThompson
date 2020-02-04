package com.dev.myapplication.presenter

import com.dev.myapplication.model.BooksResponse
import com.dev.myapplication.view.BooksActivityInterface

class BooksPresenter(
    private val booksActivity: BooksActivityInterface? = null
) : BooksPresenterInterface {


    override fun buildBooksViewModel(booksList: List<BooksResponse>) {
        val model = mutableListOf<BooksResponse>()
        for (book in booksList) {
            model.addAll(listOf(book))
        }
        booksActivity?.updateBooksList(model)
    }

}