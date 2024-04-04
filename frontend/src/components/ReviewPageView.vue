<template>

    <v-data-table
        :headers="headers"
        :items="reviewPage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReviewPageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            reviewPage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/reviewPages'))

            temp.data._embedded.reviewPages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.reviewPage = temp.data._embedded.reviewPages;
        },
        methods: {
        }
    }
</script>

