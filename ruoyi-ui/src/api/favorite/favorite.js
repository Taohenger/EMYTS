import request from '@/utils/request'

// 查询收藏信息列表
export function listFavorite(query) {
  return request({
    url: '/favorite/favorite/list',
    method: 'get',
    params: query
  })
}

// 查询收藏信息详细
export function getFavorite(favoriteId) {
  return request({
    url: '/favorite/favorite/' + favoriteId,
    method: 'get'
  })
}

// 新增收藏信息
export function addFavorite(data) {
  return request({
    url: '/favorite/favorite',
    method: 'post',
    data: data
  })
}

// 修改收藏信息
export function updateFavorite(data) {
  return request({
    url: '/favorite/favorite',
    method: 'put',
    data: data
  })
}

// 删除收藏信息
export function delFavorite(favoriteId) {
  return request({
    url: '/favorite/favorite/' + favoriteId,
    method: 'delete'
  })
}
