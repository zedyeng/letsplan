<template>
  <v-container fluid fill-height>
    <v-card class="elevation-12 mx-auto" width="600">
      <v-list two-line subheader>
        <v-subheader inset>Mes évenements</v-subheader>

        <v-list-item v-for="event in events" :key="event.id" @click>
          <v-list-item-avatar>
            <v-icon class="secondary lighten-1 white--text">mdi-calendar</v-icon>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title v-text="event.title"></v-list-item-title>
            <v-list-item-subtitle v-text="event.subtitle"></v-list-item-subtitle>
            <span class='text--grey'>{{ event.date }}</span>
          </v-list-item-content>
        </v-list-item>

        <v-divider inset></v-divider>

        <v-subheader inset>Mes invitations</v-subheader>

        <v-list-item v-for="invitaion in invitaions" :key="invitaion.id" @click>
          <v-list-item-avatar>
            <v-icon class="primary lighten-1 white--text">mdi-calendar-alert</v-icon>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title v-text="invitaion.title"></v-list-item-title>
            <v-list-item-subtitle v-text="invitaion.subtitle"></v-list-item-subtitle>
            <span class='text--grey'>{{ invitaion.date }}</span>
          </v-list-item-content>

          <v-list-item-action>
            <v-btn icon>
              <v-icon color="primary lighten-1">mdi-check-circle</v-icon>
            </v-btn>
            <v-btn icon>
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
        title: "Corona",
        subtitle: "ultra nouvel an",
        date: "Jan 9, 2014"
      },
      {
        title: "Voisins",
        subtitle: "Giga fete des voisins",
        date: "Jan 17, 2014"
      },
      {
        title: "Work",
        subtitle: "Mega fete du travail",
        date: "Jan 28, 2014"
      }
    ],
    invitaions: [
      {
        title: "Vacation itinerary",
        subtitle: "oe magl",
        date: "Jan 20, 2014"
      },
      {
        title: "Kitchen remodel",
        subtitle: "sac a dos",
        date: "Jan 10, 2014"
      }
    ]
  })
};
</script>