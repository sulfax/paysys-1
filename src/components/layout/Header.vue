<template>
    <header class="header">
        <h1>PaySys</h1>
        <router-link to="/home">Home</router-link>
        |
        <router-link  to="/wareSelection">Ware Selection</router-link>
        |
        <router-link  to="/about">About</router-link>
    </header>
</template>

<script lang="ts">
    export default {
        name: "Header"
    }
</script>

<style scoped>
.header{
    position: center;
    color: #fffef5;

    background: linear-gradient(233.41deg, #27363f 4.56%, rgba(21, 21, 24, 0) 73.99%), #171d25;
}


</style>