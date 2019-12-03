<template>
  <div class="home">
    <Login></Login>
    <Scoreboard></Scoreboard>

  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Login from "@/views/Login.vue";
import Scoreboard from "@/components/Scoreboard.vue"; // @ is an alias to /src

@Component({
  components: {
    Scoreboard,
    Login,
  },
})
export default class Home extends Vue {}
</script>
