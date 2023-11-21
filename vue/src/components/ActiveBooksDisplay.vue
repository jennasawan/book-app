<template>
    <div>
        <div class="active-books">
            <div class="active-book" v-for="book in bookList" v-bind:key="book.id" @click="logIt(book)">
                <book-display :this-book="book" />

            </div>

        </div>
    </div>
</template>

<script>

import BookDisplay from './BookDisplay.vue';
export default {

    name: 'active-books-display',

    components: { BookDisplay },

    computed: {
        bookList() {
            return this.$store.state.activeBooks
        }
    },

    methods: {

        logIt(book){
            this.$router.push({ name: "reading-log", params: { booky: book } });
        }

    }

}
</script>

<style></style>