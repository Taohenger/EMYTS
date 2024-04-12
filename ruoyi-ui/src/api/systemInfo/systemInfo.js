import request from '@/utils/request'

// 查询系统信息列表
export function listSystemInfo(query) {
  return request({
    url: '/systemInfo/systemInfo/list',
    method: 'get',
    params: query
  })
}

// 查询系统信息详细
export function getSystemInfo(systemId) {
  return request({
    url: '/systemInfo/systemInfo/' + systemId,
    method: 'get'
  })
}

// 新增系统信息
export function addSystemInfo(data) {
  return request({
    url: '/systemInfo/systemInfo',
    method: 'post',
    data: data
  })
}

// 修改系统信息
export function updateSystemInfo(data) {
  return request({
    url: '/systemInfo/systemInfo',
    method: 'put',
    data: data
  })
}

// 删除系统信息
export function delSystemInfo(systemId) {
  return request({
    url: '/systemInfo/systemInfo/' + systemId,
    method: 'delete'
  })
}
