<template>
  <div class="content">
    <div class="home">
      <h1>Welcome back.</h1>

      <h3>Where to?</h3>
      <!-- <button id="log" @click="$router.push"><router-link :to="{ name: 'active' }">Active book(s)</router-link></button> -->
      <button id="log" @click="$router.push({name: 'active'})">Active book(s)</button>
      <button id="find" @click="$router.push({ name: 'book-search-page' })">Find new book</button>
      <button id="history" @click="$router.push({ name: 'history' })">History</button>
      <button id="wishlist" @click="$router.push({ name: 'wishlist' })">Wishlist</button>
    </div>
  </div>
</template>

<script>

import BookService from '../services/BookService';
export default {
  name: "home",

  created() {

    BookService.getActiveBooks(this.$store.state.user.id)
    .then((response) => {
        this.$store.commit('SET_ACTIVE_BOOKS', response.data)
      });


    BookService.getWishlist(this.$store.state.user.id)
      .then((response) => {
        this.$store.commit('SET_WISHLIST', response.data)
      });

      BookService.getHistory(this.$store.state.user.id)
      .then((response) => {
        this.$store.commit('SET_BOOK_HISTORY', response.data)
      })

  }

};
</script>

