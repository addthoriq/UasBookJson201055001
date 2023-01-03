package com.thoriq.uasbookjson201055001

class Book{
    lateinit var title: String
    lateinit var author: String
    lateinit var page: String

    constructor(title: String, author: String, page: String){
        this.title = title
        this.author = author
        this.page = page
    }

    constructor()
}
