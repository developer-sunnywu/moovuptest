<template>
    <h1>PeopleDetail</h1><br />
    <p>The people id is {{ id }}</p>
</template>

<script>
export default {
  data() {
    return {
      id: this.$route.params.id
    }
  }
}    
</script>