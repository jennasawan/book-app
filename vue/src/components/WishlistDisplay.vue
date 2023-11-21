<template>
  <div>
    <div class="wishlist-books">
      <div class="wishlist-book"
      v-for="book in bookList"
      v-bind:key="book.id"
      >
      <book-display :this-book="book"/>

      </div>

    </div>
  </div>
</template>

<script>

import BookDisplay from './BookDisplay.vue';
//import BookService from '../services/BookService';

export default {

  name: 'wishlist-display', 

  components: {BookDisplay},

  data(){

    return {
      //bookList: [],
    }

  },

  computed: {
    bookList(){
      return this.$store.state.wishlist
    }
  }

  // created(){
  //   BookService.getWishlist(this.$store.state.user.id).then((response) => {
  //     this.bookList = response.data;
  //   })
  // }

}
</script>

<style>

</style>