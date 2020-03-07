<template>
  <v-container fluid fill-height>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-card-text>
            <form>
              <v-text-field
                prepend-icon="mdi-account-edit"
                v-model="lastname"
                :counter="30"
                :error-messages="lastnameErrors"
                label="Nom"
                required
                @input="$v.lastname.$touch()"
                @blur="$v.lastname.$touch()"
              ></v-text-field>
              <v-text-field
                prepend-icon="mdi-account-edit"
                v-model="firstname"
                :counter="20"
                :error-messages="firstnameErrors"
                label="Prénom"
                required
                @input="$v.firstname.$touch()"
                @blur="$v.firstname.$touch()"
              ></v-text-field>
              <v-text-field
                prepend-icon="mdi-email"
                v-model="email"
                :error-messages="emailErrors"
                label="Email"
                required
                @input="$v.email.$touch()"
                @blur="$v.email.$touch()"
              ></v-text-field>
              <v-text-field
                prepend-icon="mdi-account"
                v-model="username"
                :counter="20"
                :error-messages="usernameErrors"
                label="Nom d'utilisateur"
                required
                @input="$v.username.$touch()"
                @blur="$v.username.$touch()"
              ></v-text-field>
              <v-text-field
                prepend-icon="mdi-lock"
                type="password"
                v-model="password"
                :error-messages="passwordErrors"
                label="Mot de passe"
                required
                @input="$v.password.$touch()"
                @blur="$v.password.$touch()"
              ></v-text-field>
              <v-text-field
                prepend-icon="mdi-lock"
                type="password"
                v-model="confirmation"
                :error-messages="confirmationErrors"
                label="Confirmation mot de passe"
                required
                @input="$v.confirmation.$touch()"
                @blur="$v.confirmation.$touch()"
              ></v-text-field>
            </form>
          </v-card-text>
          <v-card-actions>
            <v-spacer />
            <v-btn @click="submit" color="primary">Inscription</v-btn>
            <v-btn @click="clear" color="primary">Annuler</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { HTTP } from "../http-common";
import { validationMixin } from "vuelidate";
import {
  required,
  maxLength,
  email,
  sameAs,
  minLength
} from "vuelidate/lib/validators";

export default {
  mixins: [validationMixin],

  validations: {
    lastname: { required, maxLength: maxLength(30) },
    firstname: { required, maxLength: maxLength(20) },
    email: { required, email },
    username: { required, maxLength: maxLength(20) },
    password: { required, minLength: minLength(6) },
    confirmation: { sameAsPassword: sameAs("password") }
  },

  data: () => ({
    lastname: "",
    firstname: "",
    email: "",
    username: "",
    password: "",
    confirmation: ""
  }),

  computed: {
    confirmationErrors() {
      const errors = [];
      if (!this.$v.confirmation.$dirty) return errors;
      !this.$v.confirmation.sameAsPassword &&
        errors.push("Les mot de passe doivent être identiques.");
      return errors;
    },
    passwordErrors() {
      const errors = [];
      if (!this.$v.password.$dirty) return errors;
      !this.$v.password.minLength &&
        errors.push(
          "Le mot de passe doit avoir une longueur d'au moins 6 caractères."
        );
      !this.$v.password.required &&
        errors.push("Veuillez saisir un mot de passe.");
      return errors;
    },
    usernameErrors() {
      const errors = [];
      if (!this.$v.username.$dirty) return errors;
      !this.$v.username.maxLength &&
        errors.push("Le nom d'utilisateur ne doit pas dépasser 20 caractères.");
      !this.$v.username.required &&
        errors.push("Veuillez saisir un nom d'utilisateur.");
      return errors;
    },
    emailErrors() {
      const errors = [];
      if (!this.$v.email.$dirty) return errors;
      !this.$v.email.email &&
        errors.push("Veuillez saisir une adresse email valide.");
      !this.$v.email.required &&
        errors.push("Veuillez saisir une adresse email.");
      return errors;
    },
    firstnameErrors() {
      const errors = [];
      if (!this.$v.firstname.$dirty) return errors;
      !this.$v.firstname.maxLength &&
        errors.push("Le prénom ne doit pas dépasser 20 caractères.");
      !this.$v.firstname.required && errors.push("Veuillez saisir un prénom.");
      return errors;
    },
    lastnameErrors() {
      const errors = [];
      if (!this.$v.lastname.$dirty) return errors;
      !this.$v.lastname.maxLength &&
        errors.push("Le nom ne doit pas dépasser 30 caractères.");
      !this.$v.lastname.required && errors.push("Veuillez saisir un nom.");
      return errors;
    }
  },

  methods: {
    submit() {
      this.$v.$touch();
      HTTP.post("register", {
          username: this.username,
          password: this.password,
          passwordConfirmation: this.confirmation,
          mail: this.email,
          nom: this.lastname,
          prenom: this.firstname
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
      this.lastname = "";
      this.firstname = "";
      this.email = "";
      this.username = "";
      this.password = "";
      this.confirmation = "";
    }
  }
};
</script>