<template>
  <h1>All Friends</h1><br />
  <div v-for="person in people" :key="person.id">
    <router-link :to="{ name: 'PeopleDetail', params: { id: person._id } }">
      <div>
        <img :src="person.picture">
        <span>{{ `${person.name.first} ${person.name.last}` }}</span>
      </div><br/>

    </router-link>
  </div>
</template>


<script>
export default {
  data() {
    return {
      people: [
        {
          "_id": "ae736d8f-5a08-4bab-8e30-1eb2079e5dc2",
          "name": {
            "last": "Bass",
            "first": "Bradley"
          },
          "email": "aida.griffith@sybixtex.show",
          "picture": "https://placebear.com/225/210",
          "location": {
            "latitude": 22.38,
            "longitude": null
          }
        },
        {
          "_id": "ae61bba4-4110-45a7-84c5-ab1c08a86a1d",
          "name": {
            "last": "Calhoun",
            "first": "Amparo"
          },
          "email": "sue.patterson@exoteric.press",
          "picture": "https://placebear.com/60/121",
          "location": {
            "latitude": 22.37,
            "longitude": 113.34
          }
        }
      ]
    }
  }
}    
</script>


<style></style>