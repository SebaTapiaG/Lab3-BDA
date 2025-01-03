import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import ProductView from '../views/ProductView.vue';
import RegisterView from '../views/RegisterView.vue';
import LoginView from '../views/LoginView.vue';
import AllProductsView from '../views/AllProductsView.vue';
import CartView from '../views/CartView.vue';
import OrdersView from '../views/OrdersView.vue';
import RegisterRepartidorView from '../views/RegisterDeliveryView.vue';
import MapView from '../views/MapView.vue';
import DeliveryView from '@/views/DeliveryView.vue';



const routes = [
    {
        path: '/',
        name: 'Home',
        component: HomeView,
    },
    {
        path: '/producto/:id',
        name: 'Product',
        component: ProductView,
    },
		{
			path: '/register',
			name: 'Register',
			component: RegisterView,
		},
		{
			path: '/login',
			name: 'Login',
			component: LoginView,
		},
		{
			path: '/products',
			name: 'Products',
			component: AllProductsView,
		},
		{
			path: '/cart',
			name: 'Cart',
			component: CartView,
		},
		{
			path: '/myOrders',
			name: 'Orders',
			component: OrdersView,
		},
		{
			path: '/register/repartidor',
			name: 'RegisterRepartidor',
			component: RegisterRepartidorView,
		},
		{
			path: '/mapa',
			name: 'Mapa',
			component: MapView,
		},
		{	path: '/delivery',
			name: 'Delivery',
			component: DeliveryView,
		}
		

];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
