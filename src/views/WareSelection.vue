<template>
    <div id="wareSelection" >
        <!-- <button @click="toggleShowSoldOut">{{ showSoldOut ? 'Hide' : 'Show' }} Show sold out wares</button> ></!-->
        <div class="tap">
            <h3>Bare begynn å tappe øl, eller scan en av varene under...</h3>
        </div>
        <div class="wares">
            <Ware v-for="ware in allWares" :merchandise="ware" :key="ware.title"/>
        </div>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from 'vue-property-decorator';
    import Ware, {Merchandise} from '../components/Ware.vue';

    @Component({
        components: {
            Ware,
        },
    })
    export default class WareSelection extends Vue {

        public showSoldOut: boolean = true;

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

        created() {
            let ware1: Merchandise = {
                title: "Test1",
                price: 10,
                soldOut: false,
            };
            let ware2: Merchandise = {
                title: "Test2",
                price: 30,
                soldOut: false,
            };
            let ware3: Merchandise = {
                title: "Test3",
                price: 20,
                soldOut: true,
            };

            this.wares.push(ware1);
            this.wares.push(ware2);
            this.wares.push(ware3);
            this.wares.push(ware1);
            this.wares.push(ware2);
            this.wares.push(ware3);
            this.wares.push(ware1);
            this.wares.push(ware2);
            this.wares.push(ware3);
            this.wares.push(ware1);
            this.wares.push(ware2);
            this.wares.push(ware3);

            console.log(this.wares)
        }
    }
</script>
<style scoped>
    div.wares{

    }
    div.tap {
        background: linear-gradient(224.79deg, rgba(50, 69, 79, 0.9) 2.35%, rgba(104, 142, 134, 0) 140.12%), rgba(135, 183, 157, 0.42);
        box-shadow: 5px 10px 4px rgba(0, 0, 0, 0.25);
        border-radius: 5px;
        width: 90%;
        margin:10px;

    }

</style>