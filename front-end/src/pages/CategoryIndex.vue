<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';

const categories = ref(null);

const getCategories = async () => {
  const data = await axios.get('http://localhost:8080/api/category');
  categories.value = data.data;
};

onMounted(getCategories);
</script>

<template>
  <div class="container mt-3">
    <h1 class="mb-4">My categories</h1>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">Name</th>
          <th scope="col">Badge</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="category in categories">
          <th>{{ category.id }}</th>
          <td>{{ category.name }}</td>
          <td>
            <div class="badge text-white" :style="`background-color: ${category.color};`">{{ category.name }}</div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
