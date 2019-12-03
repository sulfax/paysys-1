<template>
    <div id="wareSelection" >
        <!-- <button @click="toggleShowSoldOut">{{ showSoldOut ? 'Hide' : 'Show' }} Show sold out wares</button> ></!-->
        <div class="tap">
            <h2 style="position: center">Bare begynn å tappe øl, eller scan en av varene under...</h2>
            <Tapped></Tapped>
        </div>
        <div class="wares">
            <Ware v-for="ware in allWares" :merchandise="ware" :key="ware.id"/>
        </div>
        <input type="text" id="scanned-text" ref="scannedField" autoFocus="autofocus" v-on:keyup.enter="handleScannedPress"/>
    </div>
</template>

<script lang="ts">
    import {Component, Prop,  Vue} from 'vue-property-decorator';
    import Ware, {Merchandise} from '../components/Ware.vue';
    import Tapped from "@/components/Tapped.vue";
    import {User} from "@/components/ScoreboardEntry.vue";
    import router from "@/router";

    interface Purchase {
        tapped :number,
        indexedArray: {[key: string]: number}
    }

    @Component({
        components: {
            Tapped,
            Ware,
        },
    })
    export default class WareSelection extends Vue {

        @Prop() private  user : User;

        public showSoldOut: boolean = true;

        purchased:Purchase = {tapped:0,indexedArray:{}}

        private wares: Merchandise[] = [];

        get selection() {
            return this.wares.filter((merchandise: Merchandise) => merchandise.soldOut === undefined || merchandise.soldOut !== this.showSoldOut);
        }
        get allWares(){
            return this.wares;
        }

        public toggleShowSoldOut() {
            this.showSoldOut = !this.showSoldOut;
        }

        public handleScannedPress(e:any){

            let scanned = e.target.value.trim();
            if(scanned == this.user.id)

            fetch("api/login", {
                method: "PUT",
                headers: {'userId': this.user.id},
                body: e.target.value.trim()

            })
                .then(response => {
                    switch(response.status){
                        case 405: {

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

        created() {
            fetch("api/merchandise", {
                method: "GET",

            })
                .then(response => response.json())
                .then(data => {
                    // noinspection TypeScriptValidateTypes
                    this.wares=data
                });
        }
    }
</script>
<style scoped>
    div.wares{

    }
    div.tap {
        position: center;
        background: linear-gradient(224.79deg, rgba(50, 69, 79, 0.9) 2.35%, rgba(104, 142, 134, 0) 140.12%), rgba(135, 183, 157, 0.42);
        box-shadow: 5px 10px 4px rgba(0, 0, 0, 0.25);
        border-radius: 5px;
        width: 90%;
        margin:10px;
        color: #d4d4d4;

    }
    #scanned-text{
        position: absolute;
        top: -100px;
    }

</style>