<template>
  <v-container
    fluid
    fill-height
    :style="'background-image: url(' + require('~/assets/background.png') + '); background-size: cover; background-repeat: no-repeat;'"
  >
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card align="center" class="elevation-12">
          <v-img :src="require('~/assets/logo.png')" height="200px" width="200px"></v-img>
          <v-card-text>Planifiez vos évenements en un clin d'œil !</v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>