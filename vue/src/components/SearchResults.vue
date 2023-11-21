<template>
  <div class="content">
    <div id="book-result">
      <div id="cover-art">
        <img :src="book.coverUrl" alt="book cover" id="book-pic" />
      </div>
  
      <div id="title-author">
        <h2 id="title-of-book">{{ book.title }}</h2>
        <h3 id="author-name">{{ book.author }}</h3>
      </div>
    </div>
  </div>
  </template>
  
  <script>
  export default {
    name: "search-results",
    props: ["bookResult"],
    data() {
      return {
        book: this.bookResult,
      };
    },
  };
  </script>

<style>

</style>