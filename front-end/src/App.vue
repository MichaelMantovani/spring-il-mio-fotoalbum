<script setup>
import axios from 'axios';
import PhotoIndex from './components/PhotoIndex.vue';
import { onMounted, ref } from 'vue';

const photos= ref(null)

const getPhotos = async() => {
  const data = await axios.get('http://localhost:8080/api/photo')
  photos.value = data.data
}

onMounted(getPhotos)

</script>

<template>
  <PhotoIndex :photos="photos"/>
</template>


