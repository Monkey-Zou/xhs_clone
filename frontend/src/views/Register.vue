<!-- eslint-disable-next-line vue/multi-word-component-names -->
<template>
  <div class="register-container">
    <el-card class="register-card">
      <h2>注册</h2>
      <el-form :model="form" @submit.native.prevent="onRegister">
        <el-form-item label="用户名">
          <el-input v-model="form.username" autocomplete="off" />
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="form.nickname" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" type="password" autocomplete="off" />
        </el-form-item>
        <el-button type="primary" @click="onRegister">注册</el-button>
        <el-link type="primary" @click="goLogin">已有账号？去登录</el-link>
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
        nickname: '',
        password: ''
      }
    }
  },
  methods: {
    async onRegister() {
      try {
        await api.post('/user/register', this.form)
        Message.success('注册成功，请登录')
        this.$router.push('/login')
      } catch (e) {
        Message.error('注册失败，请检查账号密码或网络情况')
      }
    },
    goLogin() {
      this.$router.push('/login')
    }
  }
}
</script>

<style>
.register-container { display: flex; justify-content: center; align-items: center; height: 100vh; }
.register-card { width: 350px; }
</style>