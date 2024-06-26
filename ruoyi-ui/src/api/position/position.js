import request from '@/utils/request'

// 查询职位信息列表
export function listPosition(query) {
  return request({
    url: '/position/position/list',
    method: 'get',
    params: query
  })
}

// 查询职位信息详细
export function getPosition(positionId) {
  return request({
    url: '/position/position/' + positionId,
    method: 'get'
  })
}

// 新增职位信息
export function addPosition(data) {
  return request({
    url: '/position/position',
    method: 'post',
    data: data
  })
}

// 修改职位信息
export function updatePosition(data) {
  return request({
    url: '/position/position',
    method: 'put',
    data: data
  })
}

// 删除职位信息
export function delPosition(positionId) {
  return request({
    url: '/position/position/' + positionId,
    method: 'delete'
  })
}
