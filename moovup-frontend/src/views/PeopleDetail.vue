<template>
    <h1>Your Friend</h1><br />
    <p>The people id is {{ id }}</p>
    <!-- <p>The people id is {{ id }}</p> -->
    <!-- <p>The people Email is {{ email }}</p> -->
</template>

<script>
export default {
  props: ['id'],
  data() {
    // return {
    //     email: this.$route.params.email
    // }
  }
}    
</script>