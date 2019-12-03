<template>
    <div class="about">
        <h1>This is an about page</h1>

    </div>
</template>

<script lang="ts">
    import {Component, Prop, Vue} from 'vue-property-decorator';
    import Login from "@/views/Login.vue";
    @Component({
        components: {Login}
    })
    export default class Ware extends Vue {



    }


</script>