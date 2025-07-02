<!-- eslint-disable-next-line vue/multi-word-component-names -->
<template>
  <div class="login-container">
    <el-card class="login-card">
      <h2>登录</h2>
      <el-form :model="form" @submit.native.prevent="onLogin">
        <el-form-item label="用户名">
          <el-input v-model="form.username" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" type="password" autocomplete="off" />
        </el-form-item>
        <el-button type="primary" @click="onLogin">登录</el-button>
        <el-link type="primary" @click="goRegister">没有账号？去注册</el-link>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import api from '../api/request'
import { Message } from 'element-ui'
export default {
  data() {
    return {
      form: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    async onLogin() {
      try {
        const token = await api.post('/user/login', this.form)
        this.$store.commit('setToken', token)
        await this.$store.dispatch('fetchUser')
        Message.success('登录成功')
        this.$router.push('/')
      } catch (e) {
         Message.error('登录失败，请检查账号密码或网络情况')
      }
    },
    goRegister() {
      this.$router.push('/register')
    }
  }
}
</script>

<style>
.login-container { display: flex; justify-content: center; align-items: center; height: 100vh; }
.login-card { width: 350px; }
</style>