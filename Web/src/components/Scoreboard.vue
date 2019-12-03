<template>
    <div id="wareSelection" >
        <div class="scoreboard">
            <ScoreboardEntry v-for="scoreboardEntry in allScoreboardEntries" :user="scoreboardEntry" :key="scoreboardEntry.name"/>
        </div>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from 'vue-property-decorator';
    import ScoreboardEntry, {User} from './ScoreboardEntry.vue';

    interface Purchase {
        tapped :number,
        indexedArray: {[key: string]: number}
    }

    @Component({
        components: {
            ScoreboardEntry,
        },
    })
    export default class Scoreboard extends Vue {

        private scoreboardEntries: User[] = [];

        get allScoreboardEntries(){
            return this.scoreboardEntries;
        }



        created() {
            fetch("api/costumers/score", {
                method: "GET",

            })
                .then(response => response.json())
                .then(data => {
                    // noinspection TypeScriptValidateTypes
                    this.scoreboardEntries=data
                })
                .then(data=> console.log(data));
        }
    }
</script>
<style scoped>

</style>