<template>
  <v-app>
    <v-navigation-drawer v-model="drawer" app clipped>
      <v-list dense>
        <v-list-item v-for="link in links" :key="link.id" link>
          <v-list-item-action>
            <v-icon>{{ link.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>{{ link.text }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app clipped-left :color="mainColor" flat dense>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-icon class="mx-4">fab fa-youtube</v-icon>
      <v-toolbar-title class="mr-12 align-center">
        <span class="title mainName">{{ mainName }}</span>
      </v-toolbar-title>
    </v-app-bar>

    <v-content>
      <Home />
    </v-content>

    <v-footer app>
      <span class="px-4">&copy; {{ new Date().getFullYear() }} - {{ mainName }}</span>
    </v-footer>
  </v-app>
</template>

<script>
import Home from "./components/Home";

export default {
  name: "App",

  components: {
    Home
  },

  data: () => ({
    mainName: "Let's Plan",
    mainColor: "#66C39F",
    drawer: null,
    links: [
      {
        icon: "mdi-home",
        href: "skusku",
        text: "Home"
      },
      {
        icon: "mdi-trending-up",
        href: "skusku",
        text: "Most Popular"
      },
      {
        icon: "mdi-thumb-up",
        href: "skusku",
        text: "Recommendation"
      },
      {
        icon: "mdi-twitter",
        href: "https://www.twitter.com",
        text: "Twitter"
      },
      {
        icon: "mdi-heart",
        href: "booooma",
        text: "Donate"
      }
    ]
  })
};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Satisfy");

.mainName {
  font-family: "Satisfy", cursive;
  color: #515151;
}
</style>