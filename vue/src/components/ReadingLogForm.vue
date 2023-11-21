<template>
    <div class="content">
        <div id="log-form">
            <div id="log-form-book-display">
                <div id="log-title">{{ booky.title }}</div>
                <div id="log-author">{{ booky.author }}</div>
                <img :src="booky.coverUrl" alt="book cover" id="log-cover" />
            </div>
            <div id="log-form-form">
                <div class="form-item"><label class="form-label">page you ended on: </label><input type="text" v-model="log.pageNumber" id="page-num"></div>

                <div class="rating">
                    <input id="rating1" type="radio" name="rating" value="1">
                    <label for="rating1">1</label>
                    <input id="rating2" type="radio" name="rating" value="2">
                    <label for="rating2">2</label>
                    <input id="rating3" type="radio" name="rating" value="3">
                    <label for="rating3">3</label>
                    <input id="rating4" type="radio" name="rating" value="4">
                    <label for="rating4">4</label>
                    <input id="rating5" type="radio" name="rating" value="5">
                    <label for="rating5">5</label>
                </div>


                <div class="form-item"><label class="form-label">thoughts:</label><textarea v-model="log.thoughts" id="thoughts"></textarea></div>
                <div><button @click="saveLog()">save</button></div>
            </div>
        </div>

    </div>
</template>

<script>

import bookService from '../services/BookService';

export default {
    props: ['booky'],

    name: "reading-log-form",

    data() {
        return {

            log: {
                userId: this.$store.state.user.id,
                bookId: this.$store.state.bookId,
                pageNumber: 0,
                starRating: 0,
                thoughts: ""
            },

        };
    },

    methods: {
        saveLog() {
            bookService
                .addReadingLog(this.log)
                .then((response) => {
                    if (response.status === 200) {

                        
                        this.log = {};
                        
                        this.$router.push({ name: "home" });
                    }
                })
                .catch((error) => {
                    if (error.request) {
                        this.errorMsg = "This book could not be added.";
                        this.$router.push({ name: "home" });
                    }
                });
        },

    }



}
</script>

<style>
/* .rating{
  display : flex;
}

.rating input{
  position : absolute;
  left     : -100vw;
}

.rating label{
  width      : 48px;
  height     : 48px;
  padding    : 48px 0 0;
  overflow   : hidden;
  background : url('stars.svg') no-repeat top left;
}

.rating:not(:hover) input:indeterminate + label,
.rating:not(:hover) input:checked ~ input + label,
.rating input:hover ~ input + label{
  background-position : -48px 0;
}

.rating:not(:hover) input:focus-visible + label{
  background-position : -96px 0;
} */
</style>