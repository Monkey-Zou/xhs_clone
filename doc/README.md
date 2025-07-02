# 仿小红书全栈教学项目

## 技术栈
- 后端：SpringBoot、MyBatis、MySQL、JWT、Spring Security
- 前端：Vue2、Vuex、Vue Router、Element UI
- 通信：RESTful API，前后端分离

## 项目结构
参见项目结构树

## 部署指南

### 1. 数据库初始化
1. 新建数据库 `xhs`
2. 执行 `/docs/init.sql` 脚本初始化表和测试数据

### 2. 启动后端
```bash
cd backend
mvn clean spring-boot:run
```
默认端口：8080

### 3. 启动前端
```bash
cd frontend
npm install
npm run serve
```
默认端口：8081

### 4. 访问项目
- 前端入口：http://localhost:8081
- 后端接口：http://localhost:8080/api

## 功能模块
- 用户注册、登录、个人信息管理
- 内容发布、浏览、推荐、发现
- 社交互动（点赞、评论、收藏、转发）
- 搜索功能
- 关注与粉丝管理
- 通知系统
- 内容管理
- 举报与审核
- 安全机制（防刷、敏感词过滤）

后续每个模块均有详细代码与说明。