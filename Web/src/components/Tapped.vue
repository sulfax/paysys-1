<template>
    <div>
        <h3>Tappet: {{tapped1+tapped2}}</h3>
    </div>
</template>

<script lang="ts">
    import {Component, Prop, Vue} from 'vue-property-decorator';



    @Component
    export default class Tapped extends Vue {

        tapped1:number =0;
        tapped2:number =0;


        created() {
            let socket: WebSocket = new WebSocket("ws://localhost:9001");
            socket.onopen = () => {
                socket.send("start")
                socket.onmessage = ({data})=>{
                    if(data.id ===1) this.tapped1 = data.tapped;
                    if(data.id ===2) this.tapped2 = data.tapped;
                }
            };
        }
    }


</script>

<style scoped>

</style>