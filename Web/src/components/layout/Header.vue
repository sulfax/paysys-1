<template>
    <header class="header">
        <h1>PaySys</h1>
        <h1></h1>
    </header>
</template>

<script lang="ts">
    import {Component, Prop, Vue} from 'vue-property-decorator';
    import router from "@/router";

    export interface Costumer{
        id: number,
        balance: number,
        name: string,
        phone: number,
        score: number
    }

    @Component({
        components: {
        },
    })
    export default class Header extends Vue {
        @Prop() costumer! :Costumer;

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
                    router.push({ path: 'wareSelection', params:{data} })
                });
        }
    }
</script>

<style scoped>
.header{
    position: center;
    color: #fffef5;

    background: linear-gradient(233.41deg, #27363f 4.56%, rgba(21, 21, 24, 0) 73.99%), #171d25;
}


</style>