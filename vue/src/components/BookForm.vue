<template>
    <div class="content">
        <form>
            <div class="search-box">
                <input type="text" name="" required="" v-model="searchText" />
                <label>title</label>
            </div>
            <div class="either-or">-or-</div>
            <div class="search-box">
                <input type="text" name="" required="" v-model="searchISBN" />
                <label>isbn</label>
            </div>
            <a href="#" v-on:click="searchBook(book.title)" class="add-book-submit">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                search
            </a>
        </form>

        <div v-if="this.bookSelected"><search-results :bookResult="book" />

            <button @click="toCurrent(book)">i'm reading this book</button>
            <button @click="toHistory(book)">i've finished this book</button>
            <button @click="toWishlist(book)">i want to read this book</button>

        </div>

        <!-- <div id="search-results" v-for="book in searchResults" :key="book.id" @click="saveBook(book)"> -->
        <div id="search-results" v-for="book in searchResults" :key="book.id" @click="choosePath(book)">
            <div v-if="bookSelected === false"><search-results :bookResult="book" /></div>
        </div>



    </div>
</template>

<script>

import bookService from '../services/BookService';
import SearchResults from '../components/SearchResults.vue'

export default {
    components: { SearchResults },
    name: "book-form",

    data() {
        return {
            bookSelected: false,
            searchText: "",
            searchISBN: "",
            book: {
                bookId: 0,
                title: "wow",
                author: "great hair",
                isbn: "yes",
                coverUrl: "nice",
                pageCount: 0
            },
            readyToSave: false,
            searchResults: [],
            isbnResult: {}
        }

    },

    methods: {

        searchBook() {
            this.bookSelected = false;
            this.searchResults = [];
            if (this.searchText === "" && this.searchISBN !== "") {
                bookService.searchByISBN(this.searchISBN).then((response) => {
                    let result = response.data;
                    this.searchResults.push(result);
                })
            } else if (this.searchText !== "" && this.searchISBN === "") {
                this.searchText = this.searchText.replaceAll(" ", "-");
                bookService.searchByTitle(this.searchText).then((response) => {
                    this.searchResults = response.data
                })
            }
        },

        choosePath(thisOne) {
            this.book = thisOne;
            this.bookSelected = true;
            bookService
                .addNewBook(thisOne)
                .then((response) => {
                    if (response.status === 200) {
                        this.$store.commit('SET_BOOK_ID', response.data)
                        this.searchResults = [];
                    }
                })
                .catch((error) => {
                    if (error.request) {
                        this.errorMsg = "This book could not be added.";
                        this.$router.push({ name: "home" });
                    }
                });
        },


        toCurrent(book) {

            let userBook = {
                userId: this.$store.state.user.id,
                bookId: this.$store.state.bookId,
                bookStatus: "Current",
                percentFinished: 0
            };
            this.$store.state.activeBooks.push(book);
            bookService
                .addToUserBook(userBook)
                .then((response) => {
                    if (response.status == 200) {
                        this.searchResults = [];
                        this.$router.push({ name: "reading-log", params: { booky: book } });
                    }
                })
                .catch((error) => {
                    if (error.request) {
                        this.errorMsg = "No dice."
                        this.$router.push({ name: "home" })
                    }
                })

        },

        toHistory(book) {
            let userBook = {
                userId: this.$store.state.user.id,
                bookId: this.$store.state.bookId,
                bookStatus: "History",
                percentFinished: 0
            };
            this.$store.state.bookHistory.push(book);
            bookService
                .addToUserBook(userBook)
                .then((response) => {
                    if (response.status == 200) {
                        this.searchResults = [];
                        this.$router.push({ name: "reading-log", params: { booky: book } });
                    }
                })
                .catch((error) => {
                    if (error.request) {
                        this.errorMsg = "No dice."
                        this.$router.push({ name: "home" })
                    }
                })
        },

        toWishlist(book) {
            let userBook = {
                userId: this.$store.state.user.id,
                bookId: this.$store.state.bookId,
                bookStatus: "Wishlist",
                percentFinished: 0
            };
            this.$store.state.wishlist.push(book);
            bookService
                .addToUserBook(userBook)
                .then((response) => {
                    if (response.status == 200) {
                        this.searchResults = [];
                        this.$router.push({ name: "wishlist", params: { booky: book } });
                    }
                })
                .catch((error) => {
                    if (error.request) {
                        this.errorMsg = "No dice."
                        this.$router.push({ name: "home" })
                    }
                })
        },


    }

}
</script>

<style></style>