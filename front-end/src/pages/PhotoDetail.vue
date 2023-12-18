<script setup>
import axios from 'axios';
import { useRoute } from 'vue-router';
import { onMounted, ref } from 'vue';

const route = useRoute();  
const id = route.params.id;
const photo = ref(null)

const getPhotoDetail = async()=>{
    const data = await axios.get(`http://localhost:8080/api/photo/${id}`)
    photo.value = data.data
}

onMounted(getPhotoDetail)
</script>



<template>
	<div v-if="photo != null" class="container mt-4">
		<div class="d-flex justify-content-center align-items-center">
			<div class="card p-2" style="width: 25rem;">
				<img :src="photo.url" class="card-img-top" :alt="photo.title"> 
				<div class="mt-2">
					<ul class="list-unstyled horizontal-list">
						<li v-for="category in photo.categories" class="badge"
							:style="`background-color: ${category.color} `">{{category.name}}</li>
					</ul>
				</div>
				<h3 class="card-title mt-2">{{photo.title}}</h3>
				<div class="card-body">{{photo.description}}</div>
                <div>
                    <RouterLink class="btn btn-secondary btn-sm" :to="{name: 'home'}">Return</RouterLink>
                </div>
			</div>
		</div>
	</div>
</template>
