<script setup>
const props = defineProps({
    photos:{
        type : Array,
        required: true
    }
})
</script>




<template>
    <div class="container mt-4">
        <h1 class="text-center">My photos</h1>
        <div class="row mt-4">
				<div class="col-10 d-flex align-items-start gap-3">
					<form class="d-flex w-25 mb-4" role="search">
						<input class="form-control me-2" type="search" placeholder="Search" 
							name="searchValue">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
					<a href="#" class="btn btn-secondary">My categories</a>
				</div>
				<div class="col-2">
					<a class="btn btn-primary" href="#">Login</a>
				</div>
			</div>
		<div class="row row-cols-4 mt-5">
			<div class="col mb-5" v-for="photo in photos">
				<div class="card" style="width: 18rem;">
					<img :src="photo.url" class="card-img-top" :alt="photo.title"> 
					<div class="card-body">
						<h5 class="card-title">{{ photo.title }}</h5>
						<p class="card-text">{{ photo.description }}</p>
						<a href="#" class="btn btn-primary btn-sm">See more</a>
					</div>
				</div>
			</div>
		</div>
    </div>
</template>