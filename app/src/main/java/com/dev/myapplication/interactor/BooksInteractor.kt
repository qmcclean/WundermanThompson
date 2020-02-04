package com.dev.myapplication.interactor

import android.util.Log
import com.dev.myapplication.api.RetrofitServiceBuilder
import com.dev.myapplication.model.BooksResponse
import com.dev.myapplication.presenter.BooksPresenter
import com.dev.myapplication.view.BooksActivityInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "BooksInteractor"

class BooksInteractor(controller: BooksActivityInterface) : BooksInteractorInterface {

    val presenter = BooksPresenter(controller)

    override fun executeService() {
        val service = RetrofitServiceBuilder.create().getBooks()

        service.enqueue(object : Callback<List<BooksResponse>> {
            override fun onResponse(
                call: Call<List<BooksResponse>>,
                response: Response<List<BooksResponse>>
            ) {
                if (!response.isSuccessful) {
                    return
                }
                response.body()?.let {
                    presenter.buildBooksViewModel(it)
                }
            }

            override fun onFailure(call: Call<List<BooksResponse>>, t: Throwable) {
                Log.i(TAG, "Response Failed: + ${t.message}")
            }
        }
        )
    }
}