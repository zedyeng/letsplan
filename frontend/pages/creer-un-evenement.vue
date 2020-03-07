<template>
  <v-container fluid fill-height>
    <v-card class="elevation-12 mx-auto" width="600">
      <v-card-text>
        <form>
          <v-text-field
            prepend-icon="mdi-format-title"
            v-model="libelle"
            :counter="20"
            :error-messages="libelleErrors"
            label="Libellé"
            required
            @input="$v.libelle.$touch()"
            @blur="$v.libelle.$touch()"
          ></v-text-field>
          <v-text-field
            prepend-icon="mdi-help"
            v-model="nature"
            :counter="30"
            :error-messages="natureErrors"
            label="Nature"
            required
            @input="$v.nature.$touch()"
            @blur="$v.nature.$touch()"
          ></v-text-field>
          <v-menu
            ref="menuDate"
            v-model="menuDate"
            :close-on-content-click="false"
            :return-value.sync="date"
            transition="scale-transition"
            offset-y
            min-width="290px"
          >
            <template v-slot:activator="{ on }">
              <v-text-field
                v-model="date"
                prepend-icon="mdi-calendar-question"
                label="Date"
                readonly
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker v-model="date" no-title scrollable>
              <v-spacer></v-spacer>
              <v-btn text color="primary" @click="menuDate = false">Cancel</v-btn>
              <v-btn text color="primary" @click="$refs.menuDate.save(date)">OK</v-btn>
            </v-date-picker>
          </v-menu>
          <v-menu
            ref="menuDuree"
            v-model="menuDuree"
            :close-on-content-click="false"
            :return-value.sync="duree"
            transition="scale-transition"
            offset-y
            min-width="290px"
          >
            <template v-slot:activator="{ on }">
              <v-text-field
                v-model="duree"
                prepend-icon="mdi-calendar-clock"
                label="Durée"
                readonly
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker v-model="duree" no-title scrollable>
              <v-spacer></v-spacer>
              <v-btn text color="primary" @click="menuDuree = false">Cancel</v-btn>
              <v-btn text color="primary" @click="$refs.menuDuree.save(duree)">OK</v-btn>
            </v-date-picker>
          </v-menu>
          <v-text-field
            prepend-icon="mdi-map-marker"
            v-model="libelleLieu"
            :counter="30"
            :error-messages="libelleLieuErrors"
            label="Lieu"
            required
            @input="$v.libelleLieu.$touch()"
            @blur="$v.libelleLieu.$touch()"
          ></v-text-field>
          <v-text-field
            prepend-icon="mdi-road"
            v-model="nomRue"
            :counter="50"
            :error-messages="nomRueErrors"
            label="Nom de la rue"
            required
            @input="$v.nomRue.$touch()"
            @blur="$v.nomRue.$touch()"
          ></v-text-field>
          <v-text-field
            prepend-icon="mdi-counter"
            v-model="numRue"
            :counter="3"
            :error-messages="numRueErrors"
            label="Numéro de la rue"
            required
            type="number"
            @input="$v.numRue.$touch()"
            @blur="$v.numRue.$touch()"
          ></v-text-field>
          <v-text-field
            prepend-icon="mdi-home-city"
            v-model="nomVille"
            :counter="30"
            :error-messages="nomVilleErrors"
            label="Ville"
            required
            @input="$v.nomVille.$touch()"
            @blur="$v.nomVille.$touch()"
          ></v-text-field>
          <v-text-field
            prepend-icon="mdi-counter"
            v-model="departement"
            :counter="5"
            :error-messages="departementErrors"
            label="Département"
            required
            type="number"
            @input="$v.departement.$touch()"
            @blur="$v.departement.$touch()"
          ></v-text-field>
          <v-textarea
            prepend-icon="mdi-account-edit"
            v-model="loginsInvite"
            :counter="1000"
            :error-messages="loginsInviteErrors"
            label="Nom d'utilisateur des invités séparé par une virgule. Ex: 'jean-pierre,eric42,gaston38'"
            required
            @input="$v.loginsInvite.$touch()"
            @blur="$v.loginsInvite.$touch()"
          ></v-textarea>
        </form>
      </v-card-text>
      <v-card-actions>
        <v-spacer />
        <v-btn @click="submit" color="primary">Créer</v-btn>
        <v-btn @click="clear" color="primary">Annuler</v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
import axios from "axios";
import { validationMixin } from "vuelidate";
import { required, maxLength } from "vuelidate/lib/validators";

export default {
  mixins: [validationMixin],

  validations: {
    libelle: { required, maxLength: maxLength(20) },
    nature: { required, maxLength: maxLength(30) },
    libelleLieu: { required, maxLength: maxLength(30) },
    nomRue: { required, maxLength: maxLength(50) },
    numRue: { required, maxLength: maxLength(3) },
    nomVille: { required, maxLength: maxLength(30) },
    departement: { required, maxLength: maxLength(5) },
    loginsInvite: { required, maxLength: maxLength(1000) }
  },

  data: () => ({
    date: new Date().toISOString().substr(0, 10),
    duree: new Date().toISOString().substr(0, 10),
    menuDate: false,
    menuDuree: false,
    libelle: "",
    nature: "",
    libelleLieu: "",
    nomRue: "",
    numRue: "",
    nomVille: "",
    departement: "",
    loginsInvite: ""
  }),

  computed: {
    loginsInviteErrors() {
      const errors = [];
      if (!this.$v.loginsInvite.$dirty) return errors;
      !this.$v.loginsInvite.maxLength &&
        errors.push(
          "Les noms d'utilisateur des invités ne doit pas dépasser 1000 caractères."
        );
      !this.$v.loginsInvite.required &&
        errors.push("Veuillez saisir au moins un nom d'utilisateur.");
      return errors;
    },
    departementErrors() {
      const errors = [];
      if (!this.$v.departement.$dirty) return errors;
      !this.$v.departement.maxLength &&
        errors.push(
          "Le numéro de département ne doit pas dépasser 5 chiffres."
        );
      !this.$v.departement.required &&
        errors.push("Veuillez saisir un numéro de département.");
      return errors;
    },
    nomVilleErrors() {
      const errors = [];
      if (!this.$v.nomVille.$dirty) return errors;
      !this.$v.nomVille.maxLength &&
        errors.push("Le nom de la ville ne doit pas dépasser 30 caractères.");
      !this.$v.nomVille.required &&
        errors.push("Veuillez saisir un nom de ville.");
      return errors;
    },
    numRueErrors() {
      const errors = [];
      if (!this.$v.numRue.$dirty) return errors;
      !this.$v.numRue.maxLength &&
        errors.push("Le numéro de la rue ne peut pas dépasser 3 chiffres.");
      !this.$v.numRue.required &&
        errors.push("Veuillez saisir un numéro de rue.");
      return errors;
    },
    nomRueErrors() {
      const errors = [];
      if (!this.$v.nomRue.$dirty) return errors;
      !this.$v.nomRue.maxLength &&
        errors.push("Le nom de la rue ne peut pas dépasser 50 caractères.");
      !this.$v.nomRue.required && errors.push("Veuillez saisir un nom de rue.");
      return errors;
    },
    libelleLieuErrors() {
      const errors = [];
      if (!this.$v.libelleLieu.$dirty) return errors;
      !this.$v.libelleLieu.maxLength &&
        errors.push("Le nom du lieu ne peut pas dépasser 30 caractères.");
      !this.$v.libelleLieu.required &&
        errors.push("Veuillez saisir un nom de lieu.");
      return errors;
    },
    natureErrors() {
      const errors = [];
      if (!this.$v.nature.$dirty) return errors;
      !this.$v.nature.maxLength &&
        errors.push("La nature ne peut pas dépasser 30 caractères.");
      !this.$v.nature.required && errors.push("Veuillez saisir une nature.");
      return errors;
    },
    libelleErrors() {
      const errors = [];
      if (!this.$v.libelle.$dirty) return errors;
      !this.$v.libelle.maxLength &&
        errors.push("Le libellé ne peut pas dépasser 20 caractères.");
      !this.$v.libelle.required && errors.push("Veuillez saisir un libellé.");
      return errors;
    }
  },

  methods: {
    submit() {
      this.$v.$touch();
      axios
        .post("http://localhost:8080/jesaiaspasencore", {
          libelle: this.libelle,
          nature: this.nature,
          libelleLieu: this.libelleLieu,
          nomRue: this.nomRue,
          numRue: this.numRue,
          nomVille: this.nomVille,
          departement: this.departement,
          loginsInvite: this.loginsInvite,
          date: this.date,
          duree: this.duree,
          auth: {
            username: "my-trusted-client",
            password: "secret"
          }
        })
        .then(response => {
          console.log(response);
        })
        .catch(error => {
          console.log(error);
        });
    },
    clear() {
      this.$v.$reset();
      this.libelle = "";
      this.nature = "";
      this.libelleLieu = "";
      this.nomRue = "";
      this.numRue = "";
      this.nomVille = "";
      this.departement = "";
      this.loginsInvite = "";
      this.date = new Date().toISOString().substr(0, 10);
      this.duree = new Date().toISOString().substr(0, 10);
    }
  }
};
</script>