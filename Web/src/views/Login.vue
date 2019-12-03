<template>
    <div id="login">
        <h3>{{message}}</h3>
        <input type="text" id="login-text" ref="loginField" autoFocus="autofocus" v-on:keyup.enter="handleLoginPress"/>
    </div>

</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';
    import router from "@/router";
    import Scoreboard from "@/components/Scoreboard.vue";

    @Component({
        components: {
            Scoreboard
        },
    })
    export default class Login extends Vue {
        public message:string = "Scan ditt kort for å begynne å handle"

        public handleLoginPress(e:any){

           fetch("api/login", {
                method: "PUT",
                body: e.target.value.trim()

            })
                .then(response => {
                    switch(response.status){
                        case 405: {
                            this.message = "Ditt kort er ikke gjenkjent. Ta kontakt med Martin for å benytte tjenesten"

                            throw response
                        }
                    }
                    return response;
                })
                .then(response => response.text())
                .then(data => {
                    router.push({ path: 'wareSelection', params:{data}})
                });
        }
    }
</script>

<style scoped>

    #login-text{
        position: absolute;
        top: -100px;
    }
</style>