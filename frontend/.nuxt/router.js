import Vue from 'vue'
import Router from 'vue-router'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _1825c9cf = () => interopDefault(import('../pages/connexion.vue' /* webpackChunkName: "pages/connexion" */))
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
