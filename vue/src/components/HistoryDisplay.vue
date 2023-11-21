<template>
    <div>
      <div class="history-books">
        <div class="history-book"
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
export default {

    name: 'history-display', 

    components: {BookDisplay},

data(){

  return {
  }

},

computed: {
  bookList(){
    return this.$store.state.bookHistory
  }
}

}
</script>

<style>

</style>