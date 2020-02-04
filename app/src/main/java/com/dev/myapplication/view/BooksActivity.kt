package com.dev.myapplication.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.myapplication.R
import com.dev.myapplication.interactor.BooksInteractor
import com.dev.myapplication.model.BooksResponse

class BooksActivity : AppCompatActivity(),
    BooksActivityInterface {

    private lateinit var booksRecyclerView: RecyclerView
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var interactor: BooksInteractor

    private val list = mutableListOf<BooksResponse>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        interactor = BooksInteractor(this)

        initView()
    }

    private fun initView() {
        interactor.executeService()

        val itemDecor = DividerItemDecoration(this, LinearLayout.VERTICAL)

        booksRecyclerView = findViewById(R.id.booksRecyclerView)
        booksAdapter = BooksAdapter()

        booksRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@BooksActivity)
            adapter = booksAdapter
            addItemDecoration(itemDecor)
        }
    }

    override fun updateBooksList(booksList: List<BooksResponse>) {
        list.clear()
        list.addAll(booksList)
        booksAdapter.setBooks(booksList)
    }
}
