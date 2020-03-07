<template>
  <v-container fluid fill-height>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-card-text>
            <v-form>
              <v-text-field
                prepend-icon="mdi-account"
                v-model="username"
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
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer />
            <v-btn @click="submit" color="primary">Connexion</v-btn>
            <v-btn @click="clear" color="primary">Annuler</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { validationMixin } from "vuelidate";
import {
  required,
  maxLength,
  minLength
} from "vuelidate/lib/validators";

export default {
  mixins: [validationMixin],

  validations: {
    username: { required, maxLength: maxLength(20) },
    password: { required, minLength: minLength(6) }
  },

  data: () => ({
    username: "",
    password: ""
  }),

  computed: {
    passwordErrors() {
      const errors = [];
      if (!this.$v.password.$dirty) return errors;
      !this.$v.password.minLength &&
        errors.push(
          "Voitre mot de passe a au moins 6 caractères."
        );
      !this.$v.password.required &&
        errors.push("Veuillez saisir votre mot de passe.");
      return errors;
    },
    usernameErrors() {
      const errors = [];
      if (!this.$v.username.$dirty) return errors;
      !this.$v.username.maxLength &&
        errors.push("Votre nom d'utilisateur ne peut pas dépasser 20 caractères.");
      !this.$v.username.required &&
        errors.push("Veuillez saisir votre nom d'utilisateur.");
      return errors;
    }
  },

  methods: {
    submit() {
      this.$v.$touch();
    },
    clear() {
      this.$v.$reset();
      this.username = "";
      this.password = "";
    }
  }
};
</script>