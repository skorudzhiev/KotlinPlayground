package com.example.kotlinplayground

fun main() {

    val book = Book("Romeo and Juliet", "William Shakespeare", 1597)
    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()

    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")

    println("Here is your book ${bookTitleAuthorYear.first} " +
            "by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third}")
}

open class Book(val title: String, val author: String, val year: Int) {

    private var currentPage = 1

    open fun readPage() {
        currentPage++
    }

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

class eBook(title: String, author: String, var format: String = "text") : Book(title, author, year = 1990) {

    private var wordsRead = 0

    override fun readPage() {
        wordsRead += 250
    }
}