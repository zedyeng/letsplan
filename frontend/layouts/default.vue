<template>
  <v-app>
    <v-navigation-drawer v-model="drawer" app clipped>
      <v-list dense>
        <v-list-item v-for="link in links" :key="link.id" link :to="link.href" nuxt>
          <v-list-item-action>
            <v-icon>{{ link.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>{{ link.text }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app clipped-left color="primary" flat dense>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-toolbar-title class="mr-12 align-center">
        <span class="title" color="secondary" style="font-family: Satisfy !important;">{{ mainName }}</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn class="ml-2" text to="/inscription" nuxt>
        <span class="mr-2">Inscription</span>
        <v-icon>mdi-account</v-icon>
      </v-btn>
      <v-btn class="ml-2" text to="/connexion" nuxt>
        <span class="mr-2">Connexion</span>
        <v-icon>mdi-login</v-icon>
      </v-btn>
      <v-btn class="ml-2" text to="/deconnexion" nuxt>
        <span class="mr-2">Déconnexion</span>
        <v-icon>mdi-logout</v-icon>
      </v-btn>
    </v-app-bar>

    <v-content>
      <nuxt />
    </v-content>

    <v-footer app>
      <span class="px-4" >&copy; {{ new Date().getFullYear() }} - {{ mainName }}</span>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  // props: {
  //   source: String
  // },
  data: () => ({
    mainName: process.env.mainName,
    drawer: null,
    links: [
      {
        icon: "mdi-home",
        href: "/",
        text: "Accueil"
      },
      {
        icon: "mdi-calendar",
        href: "/evenements",
        text: "Évenements"
      },
      {
        icon: "mdi-calendar-plus",
        href: "/creer-un-evenement",
        text: "Créer un évenement"
      }
    ]
  })
};
</script>