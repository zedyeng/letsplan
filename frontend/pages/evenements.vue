<template>
  <v-container fluid fill-height>
    <v-card class="elevation-12 mx-auto" width="600">
      <v-list two-line subheader>
        <v-card-title
            class="headline"
            style="font-family: Abril Fatface !important;"
            color="secondary"
          >Mes évenements</v-card-title>
          <v-divider class="mx-4"></v-divider>

        <v-list-item v-for="event in events" :key="event.id" @click :to="'/evenement?id=' + event.id" nuxt>
          <v-list-item-avatar>
            <v-icon class="secondary lighten-1 white--text">mdi-calendar</v-icon>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title v-text="event.libelle"></v-list-item-title>
            <v-list-item-subtitle v-text="event.nature"></v-list-item-subtitle>
            <span class="text--grey">{{ event.date }}</span>
          </v-list-item-content>
        </v-list-item>

        <v-card-title
            class="headline"
            style="font-family: Abril Fatface !important;"
            color="secondary"
          >Mes invitations</v-card-title>
          <v-divider class="mx-4"></v-divider>

        <v-list-item v-for="invitaion in invitaions" :key="invitaion.id" @click :to="'/evenement?id=' + invitaion.id" nuxt>
          <v-list-item-avatar>
            <v-icon class="primary lighten-1 white--text">mdi-calendar-alert</v-icon>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title v-text="invitaion.libelle"></v-list-item-title>
            <v-list-item-subtitle v-text="invitaion.nature"></v-list-item-subtitle>
            <span class="text--grey">{{ invitaion.date }}</span>
          </v-list-item-content>

          <v-list-item-action>
            <v-btn icon :to="'/evenement?id=' + invitaion.id + '&accept=true'" nuxt>
              <v-icon color="primary lighten-1">mdi-check-circle</v-icon>
            </v-btn>
            <v-btn icon :to="'/evenement?id=' + invitaion.id + '&accept=false'" nuxt>
              <v-icon color="red lighten-1">mdi-close-circle</v-icon>
            </v-btn>
          </v-list-item-action>
        </v-list-item>
      </v-list>
    </v-card>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    events: [
      {
        id: 1,
        libelle: "Corona",
        nature: "ultra nouvel an",
        date: "Jan 9, 2014"
      }
    ],
    invitaions: [
      {
        id: 4,
        libelle: "Vacation a la playa",
        nature: "superbe vacances en famille",
        date: "Jan 20, 2014"
      }
    ]
  })
};
</script>