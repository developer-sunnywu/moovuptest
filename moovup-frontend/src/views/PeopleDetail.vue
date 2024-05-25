<template>
  <h1>Your Friend</h1><br />

  <div ref="mapContainer" style="width: 400px;height:400px;"></div>

  <div v-if="person">

    <div>
      <img :src="person.picture">
      <span>{{ `${person.name.first} ${person.name.last}` }}</span>
    </div><br />
    <p>Email: {{ person.email }}</p>
  </div>

</template>

<script>
import { ref, onMounted } from "vue"
import L from "leaflet"


export default {
  props: ['id'],
  data() {
    return {
      person: null,
      map: null
    }
  },

  // TODO: find another to get the data instead of calling API again
  mounted() {
    console.log('id is ' + this.id)
    // Fetch data from api server
    const headers = { "Authorization": "Bearer b2atclr0nk1po45amg305meheqf4xrjt9a1bo410" }
    fetch('https://api.json-generator.com/templates/-xdNcNKYtTFG/data', { headers })
      .then(res => res.json())
      .then(data => {
        const person = data.filter(person => person._id == this.id).shift() || null
        this.person = person

      })
      .catch(err => console.log(err.message))

    this.map = L.map(this.$refs.mapContainer).setView([51.505, -0.09], 13)
    L.tileLayer("https://tile.openstreetmap.org/{z}/{x}/{y}.png", {
      maxZoom: 19,
      attribution:
        '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>',
    }).addTo(this.map)
    L.marker([51.505, -0.09], { draggable: true })
      .addTo(this.map)
      .on('dragend', (event) => {
        console.log(event);
      })
  }
}    
</script>