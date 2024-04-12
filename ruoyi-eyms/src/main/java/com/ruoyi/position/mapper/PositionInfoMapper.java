package com.ruoyi.position.mapper;

import java.util.List;
import com.ruoyi.position.domain.PositionInfo;

/**
 * 职位信息Mapper接口
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public interface PositionInfoMapper 
{
    /**
     * 查询职位信息
     * 
     * @param positionId 职位信息主键
     * @return 职位信息
     */
    public PositionInfo selectPositionInfoByPositionId(Long positionId);

    /**
     * 查询职位信息列表
     * 
     * @param positionInfo 职位信息
     * @return 职位信息集合
     */
    public List<PositionInfo> selectPositionInfoList(PositionInfo positionInfo);

    /**
     * 新增职位信息
     * 
     * @param positionInfo 职位信息
     * @return 结果
     */
    public int insertPositionInfo(PositionInfo positionInfo);

    /**
     * 修改职位信息
     * 
     * @param positionInfo 职位信息
     * @return 结果
     */
    public int updatePositionInfo(PositionInfo positionInfo);

    /**
     * 删除职位信息
     * 
     * @param positionId 职位信息主键
     * @return 结果
     */
    public int deletePositionInfoByPositionId(Long positionId);

    /**
     * 批量删除职位信息
     * 
     * @param positionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePositionInfoByPositionIds(Long[] positionIds);
}
