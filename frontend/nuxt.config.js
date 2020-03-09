require('dotenv').config()

export default {
    mode: 'universal',
    /*
    ** Environement variables
    */
    env: {
        mainName: process.env.MAIN_NAME,
        mainTitle: process.env.MAIN_TITLE,
    },
    /*
    ** Headers of the page
    */
    head: {
        titleTemplate: process.env.MAIN_NAME + ' - %s',
        title: process.env.MAIN_TITLE,
        meta: [
            { charset: 'utf-8' },
            { name: 'viewport', content: 'width=device-width, initial-scale=1' },
            { hid: 'description', name: 'description', content: process.env.MAIN_DESCRIPTION }
        ],
        link: [
            { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
            { rel: 'stylesheet', href: 'https://fonts.googleapis.com/css?family=Satisfy&display=swap' },
            { rel: 'stylesheet', href: 'https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap' }
        ]
    },
    /*
    ** Customize the progress-bar color
    */
    loading: { color: '#fff' },
    /*
    ** Global CSS
    */
    css: [
    ],
    /*
    ** Plugins to load before mounting the App
    */
    plugins: [
    ],
    /*
    ** Nuxt.js dev-modules
    */
    buildModules: [
        '@nuxtjs/vuetify'
    ],
    /*
    ** Nuxt.js modules
    */
    modules: [
        // Doc: https://axios.nuxtjs.org/usage
        '@nuxtjs/axios',
        // Doc: https://github.com/nuxt-community/dotenv-module
        '@nuxtjs/dotenv',
        'nuxtjs-mdi-font',
    ],
    /*
    ** Axios module configuration
    ** See https://axios.nuxtjs.org/options
    */
    axios: {
    },
    /*
    ** vuetify module configuration
    ** https://github.com/nuxt-community/vuetify-module
    */
    vuetify: {
        customVariables: ['~/assets/variables.scss'],
        theme: {
            themes: {
                light: {
                    primary: process.env.MAIN_COLOR,
                    secondary: process.env.SECOND_COLOR
                }
            }
        }
    },
    /*
    ** Build configuration
    */
    build: {
        /*
        ** You can extend webpack config here
        */
        extend(config, ctx) {
        }
    }
}
