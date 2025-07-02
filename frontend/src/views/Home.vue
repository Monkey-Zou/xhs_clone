<!-- eslint-disable-next-line vue/multi-word-component-names -->
<template>
  <div class="home">
    <el-card>
      <h2>欢迎来到小红书仿真项目！</h2>
      <div v-if="user">
        <p>你好，{{ user.nickname }}</p>
        <el-link type="primary" @click="logout">退出登录</el-link> |
        <el-link type="primary" @click="goProfile">个人中心</el-link>
      </div>
      <div v-else>
        <el-link type="primary" @click="$router.push('/login')">去登录</el-link>
        <el-link type="primary" @click="$router.push('/register')">去注册</el-link>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  computed: {
    user() {
      return this.$store.state.user
    }
  },
  methods: {
    logout() {
      this.$store.commit('logout')
      this.$router.push('/login')
    },
    goProfile() {
      this.$router.push('/profile')
    }
  }
}
</script>