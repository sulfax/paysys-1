<template>
    <div id="app">
        <router-view/>
    </div>
</template>


<script>
    import Login from "./views/Login";

    export default {
        components: {Login}
    }
</script>

<style lang="scss">
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        background: linear-gradient(233.41deg, #32454F 4.56%, rgba(21, 21, 24, 0) 73.99%), #32454F;
    }

    #nav {
        a {
            font-weight: bold;
            color: #42b983;

            &.router-link-exact-active {
                color: #ffffff;
            }
        }
    }

    #app {
        padding: 10px;
        position: relative;
        height: 1024px;
        background: linear-gradient(233.41deg, #32454F 4.56%, rgba(21, 21, 24, 0) 73.99%), #32454F;
    }

    .techyon {
        padding: 10px;
        color: #C9CFC6;
    }

    nav li:hover,
    nav li.router-link-active,
    nav li.router-link-exact-active {
        background-color: #fff400;
        cursor: pointer;
    }
</style>