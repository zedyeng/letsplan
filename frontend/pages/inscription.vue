<template>
  <v-container fluid fill-height>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-card-text>
            <form>
              <v-text-field
                v-model="name"
                :counter="20"
                :error-messages="nameErrors"
                label="Nom"
                required
                @input="$v.name.$touch()"
                @blur="$v.name.$touch()"
              ></v-text-field>
              <v-text-field
                v-model="email"
                :error-messages="emailErrors"
                label="Email"
                required
                @input="$v.email.$touch()"
                @blur="$v.email.$touch()"
              ></v-text-field>
              <v-text-field
                v-model="phone"
                :error-messages="phoneErrors"
                label="Téléphone"
                required
                @input="$v.phone.$touch()"
                @blur="$v.phone.$touch()"
              ></v-text-field>
              <v-text-field
                v-model="subject"
                :counter="30"
                :error-messages="subjectErrors"
                label="Objet"
                required
                @input="$v.subject.$touch()"
                @blur="$v.subject.$touch()"
              ></v-text-field>
              <v-textarea
                v-model="message"
                :counter="1000"
                :error-messages="messageErrors"
                label="Message"
                required
                @input="$v.message.$touch()"
                @blur="$v.message.$touch()"
              ></v-textarea>
              <v-checkbox
                v-model="checkbox"
                :error-messages="checkboxErrors"
                required
                @change="$v.checkbox.$touch()"
                @blur="$v.checkbox.$touch()"
              >
                <template
                  v-slot:label
                >J'ai lu et accepte la politique de confidentialité RGPD de la Let's Plan.</template>
              </v-checkbox>
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
import { validationMixin } from "vuelidate";
import { required, maxLength, email } from "vuelidate/lib/validators";

export default {
  mixins: [validationMixin],

  validations: {
    name: { required, maxLength: maxLength(20) },
    email: { required, email },
    phone: { required }, // TODO
    subject: { required, maxLength: maxLength(30) },
    message: { required, maxLength: maxLength(1000) },
    checkbox: {
      checked(val) {
        return val;
      }
    }
  },

  data: () => ({
    name: "",
    email: "",
    phone: "",
    subject: "",
    message: "",
    checkbox: false
  }),

  computed: {
    checkboxErrors() {
      const errors = [];
      if (!this.$v.checkbox.$dirty) return errors;
      !this.$v.checkbox.checked &&
        errors.push("Veuillez accepter pour continuer."); //TODO
      return errors;
    },
    messageErrors() {
      const errors = [];
      if (!this.$v.message.$dirty) return errors;
      !this.$v.message.maxLength &&
        errors.push("Le message ne doit pas dépasser 1000 caractères.");
      !this.$v.message.required && errors.push("Veuillez saisir un message.");
      return errors;
    },
    subjectErrors() {
      const errors = [];
      if (!this.$v.subject.$dirty) return errors;
      !this.$v.subject.maxLength &&
        errors.push("L'objet ne doit pas dépasser 30 caractères.");
      !this.$v.subject.required && errors.push("Veuillez saisir un objet.");
      return errors;
    },
    phoneErrors() {
      const errors = [];
      if (!this.$v.phone.$dirty) return errors;
      //!this.$v.phone.maxLength &&
      //  errors.push("L'objet ne doit pas dépasser 30 caractères."); //TODO
      !this.$v.phone.required &&
        errors.push("Veuillez saisir un numéro de téléphone.");
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
    nameErrors() {
      const errors = [];
      if (!this.$v.name.$dirty) return errors;
      !this.$v.name.maxLength &&
        errors.push("Le nom ne doit pas dépasser 20 caractères.");
      !this.$v.name.required && errors.push("Veuillez saisir un nom.");
      return errors;
    }
  },

  methods: {
    submit() {
      this.$v.$touch();
    },
    clear() {
      this.$v.$reset();
      this.name = "";
      this.email = "";
      this.phone = "";
      this.subject = "";
      this.message = "";
      this.checkbox = false;
    }
  }
};
</script>