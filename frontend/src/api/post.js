import api from './request'

// 发布内容
export function createPost(data) {
    return api.post('/post/create', data)
}

// 编辑内容
export function updatePost(data) {
    return api.post('/post/update', data)




}

// 删除内容
export function deletePost(id) {
    return api.post(`/post/delete/${id}`)
}

// 获取所有内容
export function fetchAllPosts() {
    return api.get('/post/all')
}

// 获取单个内容
export function fetchPost(id) {
    return api.get(`/post/${id}`)
}

// 获取我的内容
export function fetchMyPosts() {
    return api.get('/post/my')
}