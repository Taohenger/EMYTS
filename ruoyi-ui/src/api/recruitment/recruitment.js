import request from '@/utils/request'

// 查询招聘信息列表
export function listRecruitment(query) {
  return request({
    url: '/recruitment/recruitment/list',
    method: 'get',
    params: query
  })
}

// 查询招聘信息详细
export function getRecruitment(recruitmentId) {
  return request({
    url: '/recruitment/recruitment/' + recruitmentId,
    method: 'get'
  })
}

// 新增招聘信息
export function addRecruitment(data) {
  return request({
    url: '/recruitment/recruitment',
    method: 'post',
    data: data
  })
}

// 修改招聘信息
export function updateRecruitment(data) {
  return request({
    url: '/recruitment/recruitment',
    method: 'put',
    data: data
  })
}

// 删除招聘信息
export function delRecruitment(recruitmentId) {
  return request({
    url: '/recruitment/recruitment/' + recruitmentId,
    method: 'delete'
  })
}
