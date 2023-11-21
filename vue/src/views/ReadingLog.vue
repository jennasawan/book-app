<template>
  <div>
    <reading-log-form :booky="booky"/>
  </div>
</template>

<script>
import ReadingLogForm from '../components/ReadingLogForm.vue';

export default {

  props: ['booky'],
    
    components: {ReadingLogForm}

}
</script>

<style>

</style>