<template>
  <v-container fluid fill-height>
    <v-card class="elevation-12 mx-auto" width="600">
      <v-list two-line subheader>
        <v-subheader inset>{{ event.libelle }}</v-subheader>

        <v-list-item>
          <v-list-item-avatar>
            <v-icon class="primary lighten-1 white--text">mdi-calendar</v-icon>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title>{{ event.nature }}</v-list-item-title>
            <v-list-item-subtitle>Date : {{ event.date }} - Durée : {{ event.duree }}</v-list-item-subtitle>
            <span class="text--grey">{{ event.libelleLieu }}, {{ event.numRue }} {{ event.nomRue }}, {{ event.deparement }} {{ event.nomVille }}</span>
          </v-list-item-content>
        </v-list-item>

        <v-divider inset></v-divider>

        <v-subheader inset>Invités</v-subheader>

        <v-list-item v-for="invite in event.loginsInvite.split(',')" :key="invite">

          <v-list-item-avatar>
            <v-icon class="secondary lighten-1 white--text">mdi-account</v-icon>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title v-text="invite"></v-list-item-title>
          </v-list-item-content>

        </v-list-item>
      </v-list>
    </v-card>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    event: {
      libelle: "libelleeee evenement",
      nature: "nature evenemenetttt",
      date: "2020-03-05",
      duree: "2020-03-05",
      libelleLieu: "libelleeee lieueeuu",
      numRue: "143",
      nomRue: "avenue de ta sdvsdvgsfg",
      nomVille: "pariiiisssss",
      departement: "75016",
      loginsInvite: "Jacques,hajar,minhtri3,le.tri2309@gmail.com"
    }
  })
};
</script>