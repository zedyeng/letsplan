import Vue from 'vue'
import Router from 'vue-router'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _1825c9cf = () => interopDefault(import('../pages/connexion.vue' /* webpackChunkName: "pages/connexion" */))
const _536edaa9 = () => interopDefault(import('../pages/creer-un-evenement.vue' /* webpackChunkName: "pages/creer-un-evenement" */))
const _61fc536e = () => interopDefault(import('../pages/deconnexion.vue' /* webpackChunkName: "pages/deconnexion" */))
const _b9522522 = () => interopDefault(import('../pages/evenement.vue' /* webpackChunkName: "pages/evenement" */))
const _699b3cd8 = () => interopDefault(import('../pages/evenements.vue' /* webpackChunkName: "pages/evenements" */))
const _25046844 = () => interopDefault(import('../pages/inscription.vue' /* webpackChunkName: "pages/inscription" */))
const _2dfb1658 = () => interopDefault(import('../pages/index.vue' /* webpackChunkName: "pages/index" */))

// TODO: remove in Nuxt 3
const emptyFn = () => {}
const originalPush = Router.prototype.push
Router.prototype.push = function push (location, onComplete = emptyFn, onAbort) {
  return originalPush.call(this, location, onComplete, onAbort)
}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: decodeURI('/'),
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/connexion",
    component: _1825c9cf,
    name: "connexion"
  }, {
    path: "/creer-un-evenement",
    component: _536edaa9,
    name: "creer-un-evenement"
  }, {
    path: "/deconnexion",
    component: _61fc536e,
    name: "deconnexion"
  }, {
    path: "/evenement",
    component: _b9522522,
    name: "evenement"
  }, {
    path: "/evenements",
    component: _699b3cd8,
    name: "evenements"
  }, {
    path: "/inscription",
    component: _25046844,
    name: "inscription"
  }, {
    path: "/",
    component: _2dfb1658,
    name: "index"
  }],

  fallback: false
}

export function createRouter () {
  return new Router(routerOptions)
}
