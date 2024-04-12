import request from '@/utils/request'

// 查询管理员信息列表
export function listAdminInfo(query) {
  return request({
    url: '/admin/AdminInfo/list',
    method: 'get',
    params: query
  })
}

// 查询管理员信息详细
export function getAdminInfo(adminId) {
  return request({
    url: '/admin/AdminInfo/' + adminId,
    method: 'get'
  })
}

// 新增管理员信息
export function addAdminInfo(data) {
  return request({
    url: '/admin/AdminInfo',
    method: 'post',
    data: data
  })
}

// 修改管理员信息
export function updateAdminInfo(data) {
  return request({
    url: '/admin/AdminInfo',
    method: 'put',
    data: data
  })
}

// 删除管理员信息
export function delAdminInfo(adminId) {
  return request({
    url: '/admin/AdminInfo/' + adminId,
    method: 'delete'
  })
}
