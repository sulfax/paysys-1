<template>
    <div class="ware" :class="{ soldOut: merchandise.soldOut }">
        <h2>{{ merchandise.title }}</h2>
		<img :src="'/img/' +merchandise.title+ '.png'" alt="""">
        <p>{{ merchandise.price }} NOK</p>
    </div>
</template>

<script lang="ts">
    import {Component, Prop, Vue} from 'vue-property-decorator';


    export interface Merchandise {
        title: string;
        price: number;
        soldOut?: boolean;
    }



    @Component
    export default class Ware extends Vue {
        @Prop() private merchandise!: Merchandise;
    }
</script>

<style lang="scss">
    div.ware {
        background: linear-gradient(224.79deg, rgba(50, 69, 79, 0.9) 2.35%, rgba(104, 142, 134, 0) 140.12%), rgba(135, 183, 157, 0.42);
        box-shadow: 5px 10px 4px rgba(0, 0, 0, 0.25);
        border-radius: 5px;
		width: 80px;
		height: 160px;
		margin:10px;

		float: left;
    }
	.soldOut{
		background: gray;
	}
</style>
