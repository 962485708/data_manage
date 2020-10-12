import Vue from 'vue'
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
	state: {
		token: sessionStorage.getItem('token') ? sessionStorage.getItem('token') : '',
		currentDb: {}
	},
	mutations: {
		setToken (state,token) {
			state.token =token;
			sessionStorage.setItem("token",token.token);
		},
		delToken (state) {
			state.token = '';
			sessionStorage.removeItem("token");
		}
	}
})

export default store;