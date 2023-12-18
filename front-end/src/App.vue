<script setup>
import axios from 'axios';
import { onMounted, ref } from 'vue';

const photos= ref(null)
const searchValue= ref(null)

const getPhotos = async() => {
  if(searchValue.value == null){
    const data = await axios.get('http://localhost:8080/api/photo')
    photos.value = data.data
  } else {
    const data = await axios.get('http://localhost:8080/api/photo', {params : {searchValue : searchValue.value}})
    photos.value = data.data
  }
}

const handleSearch = (value) => {
  searchValue.value = value
  getPhotos()
}

onMounted(getPhotos)

</script>

<template>
  <RouterView :photos="photos" @searchSubmit="handleSearch"></RouterView>
</template>


