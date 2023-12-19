import { createRouter, createWebHistory } from 'vue-router';
import PhotoIndex from '../pages/PhotoIndex.vue';
import PhotoDetail from '../pages/PhotoDetail.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: PhotoIndex,
      name: 'home',
    },
    {
      path: '/photo/:id',
      component: PhotoDetail,
      name: 'detail',
    },
    {
      path: '/message',
      componet: MessageForm,
      name: 'message',
    },
  ],
});

export { router };
