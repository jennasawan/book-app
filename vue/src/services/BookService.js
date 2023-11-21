import axios from 'axios';

export default {

    //BOOKS
    
    searchByTitle(title){
        return axios.get(`/google/books/${title}`)
    },

    searchByISBN(ISBN){
        return axios.get(`/google/book/${ISBN}`)
    },

    addNewBook(book){
        return axios.post(`/book`, book)
    }, 

    getBookById(bookId){
        return axios.get(`/book/${bookId}`)
    }, 

    addToUserBook(userBook){
        return axios.post(`/user/book`, userBook)
    },

    getActiveBooks(userId){
        return axios.get(`/active/${userId}`)
    },

    getWishlist(userId){
        return axios.get(`/wishlist/${userId}`)
    },

    getHistory(userId){
        return axios.get(`/history/${userId}`)
    },

    //READING LOGS

    addReadingLog(log){
        return axios.post(`/log`, log)
    }
}