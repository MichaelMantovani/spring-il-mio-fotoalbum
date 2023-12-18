<script setup>
import { ref } from 'vue';

const value = ref('')
const props = defineProps({
    photos:{
        type : Array,
        required: true
    }
});


const emit = defineEmits()
</script>




<template>
    <div class="container mt-4">
        <h1 class="text-center">My photos</h1>
        <div class="row mt-4">
				<div class="col-10 d-flex align-items-start gap-3">
					<form @submit.prevent="emit('searchSubmit', value)" class="d-flex w-25 mb-4" role="search">
						<input class="form-control me-2" type="search" placeholder="Search" 
							name="searchValue" v-model="value">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
				<div class="col-2">
					<a class="btn btn-primary" href="http://localhost:8080/login">Login</a>
				</div>
			</div>
		<div class="row row-cols-4 mt-5">
			<div class="col mb-5" v-for="photo in photos" :key="photo.id">
				<div class="card" style="width: 18rem;">
					<img :src="photo.url" class="card-img-top" :alt="photo.title"> 
					<div class="card-body">
						<h5 class="card-title">{{ photo.title }}</h5>
						<p class="card-text">{{ photo.description }}</p>
						<RouterLink class="btn btn-primary" :to="{ name: 'detail', params: {id: photo.id}}">See more</RouterLink>
					</div>
				</div>
			</div>
		</div>
    </div>
</template>
