<template>
    <div id="book-disp">
        

        <div id="title-author">
            <h2 id="disp-title">{{ book.title }}</h2>
            <h3 id="disp-author">{{ book.author }}</h3>
        </div>

        <div id="cover-art">
            <img :src="book.coverUrl" alt="book cover" id="book-pic" />
        </div>
    </div>
</template>

<script>
export default {

    name: 'book-display', 
    props: ["thisBook"], 

    data(){
        return{
            book: {
                id: 0,
                title: "",
                author: "", 
                coverUrl: ""
            }
        }
    },

    created(){
        this.book = this.thisBook;
    }

}
</script>

<style></style>