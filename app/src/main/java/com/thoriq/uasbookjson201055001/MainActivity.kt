package com.thoriq.uasbookjson201055001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var rvBooks: RecyclerView
    private val list = ArrayList<Book>()
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBooks = findViewById(R.id.rv_books)
        rvBooks.setHasFixedSize(true)

        getListBooks("https://ermaweb.com/pmobile/book/books.json")
    }

    private fun getListBooks(url: String){
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val strResponse = response.body()!!.string()
                val jsonContact = JSONArray(strResponse).getJSONObject(0)
                var i = 0
                val size: Int = strResponse.length
                val listBook = ArrayList<Book>()
                println(strResponse)
                for (i in 0 until size){
                    val book = Book()
                    book.title = jsonContact.getString("title")
                    book.author = jsonContact.getString("author")
                    book.page = jsonContact.getString("language")
                    listBook.add(book)
                }
                setupRv()
            }
        })
    }

    private fun setupRv(){
        rvBooks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listHeroAdapter = ListBookAdapter(this, list)
        rvBooks.adapter = listHeroAdapter
    }
}