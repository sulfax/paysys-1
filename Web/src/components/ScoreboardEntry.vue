<template>
    <div>
        <div class="scoreboard-entry">
            <div class="scoreboard-username">
                {{user.name}}
            </div>
            <div class="scoreboard-score">
                <div class="scoreboard-score-text">{{user.score}}</div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import {Component, Prop, Vue} from 'vue-property-decorator';

    export interface User {
        id: number;
        name: string;
        score?: number;
    }

    @Component
    export default class ScoreboardEntry extends Vue {
        @Prop() private user!: User;
        @Prop() private loggedIn?: Boolean;
    }
</script>

<style lang="scss">
    div.scoreboard-entry {
        height: 36px;
        width: 80%;
        border: grey solid 3px;
        border-radius: 10px;
        padding: 10px;
        margin: 5px auto;
        text-align: center;
        background-color: #f0f0f0;
        font-size: 25px;
        display: flex;
        justify-content: space-between;
    }

    div.scoreboard-username {
        display: inline;
        margin: 0 10px;
    }

    div.scoreboard-score {
        width: 32px;
        display: inline;
        float: right;
    }

    div.scoreboard-score-text {
        width: max-content;
        float: right;
        margin-top: 0 !important;
    }
</style>
