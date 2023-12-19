<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
const form = ref({
  name: null,
  email: null,
  message: null,
});

const router = useRouter();
const emits = defineEmits();

const sendMessage = async () => {
  const store = await axios.post('http://localhost:8080/api/message/create', form.value);
  console.log('inviato');
  router.push({ name: 'home' });
};
</script>

<template>
  <div class="container mt-4">
    <form class="row g-3" @submit.prevent="sendMessage">
      <div class="col-md-6">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" v-model="form.name" />
      </div>
      <div class="col-md-6">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" v-model="form.email" />
      </div>
      <div class="col-12">
        <label for="message" class="form-label">Message</label>
        <textarea class="form-control" rows="10" id="message" v-model="form.message"></textarea>
      </div>
      <div class="col-12">
        <button type="submit" class="btn btn-primary">Send</button>
      </div>
    </form>
  </div>
</template>
