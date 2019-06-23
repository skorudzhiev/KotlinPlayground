package com.example.kotlinplayground

import java.util.*

const val MAX_NUMBER_BOOKS = 20

fun main() {

    val book = Book("Romeo and Juliet", "William Shakespeare", 1597, 240)
    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()

    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")

    println("Here is your book ${bookTitleAuthorYear.first} " +
            "by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third}")

    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("Shakespeare" to allBooks)
    println(library.any { it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf("Wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle Book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)

    book.printUrl()

    val puppy = Puppy()
    val book2 = Book("Oliver Twist", "Charles Dickens", 1837, 540)

    while (book2.pages > 0) {
        puppy.playWithBook(book2)
        Thread.sleep(320)
        println("${book2.pages} left in ${book2.title}")
    }
    println("Sad puppy, no more pages in ${book2.title}. ")
}

open class Book(val title: String, val author: String, val year: Int, var pages: Int) {

    companion object {
            const val BASE_URL = "http://www.turtlecare.net/"
    }

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

    fun canBorrow(hasBooks: Int): Boolean {
        return (hasBooks < MAX_NUMBER_BOOKS)
    }

    fun printUrl() {
        println("$BASE_URL$title.html")
    }
}

fun Book.weight() : Double { return (pages * 1.5) }

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class eBook(title: String, author: String, var format: String = "text") : Book(title, author, year = 1990, pages = 100) {

    private var wordsRead = 0

    override fun readPage() {
        wordsRead += 250
    }
}

class Puppy {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))
    }
}