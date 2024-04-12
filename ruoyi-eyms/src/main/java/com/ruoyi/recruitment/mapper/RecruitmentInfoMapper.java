package com.ruoyi.recruitment.mapper;

import java.util.List;
import com.ruoyi.recruitment.domain.RecruitmentInfo;

/**
 * 招聘信息Mapper接口
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public interface RecruitmentInfoMapper 
{
    /**
     * 查询招聘信息
     * 
     * @param recruitmentId 招聘信息主键
     * @return 招聘信息
     */
    public RecruitmentInfo selectRecruitmentInfoByRecruitmentId(Long recruitmentId);

    /**
     * 查询招聘信息列表
     * 
     * @param recruitmentInfo 招聘信息
     * @return 招聘信息集合
     */
    public List<RecruitmentInfo> selectRecruitmentInfoList(RecruitmentInfo recruitmentInfo);

    /**
     * 新增招聘信息
     * 
     * @param recruitmentInfo 招聘信息
     * @return 结果
     */
    public int insertRecruitmentInfo(RecruitmentInfo recruitmentInfo);

    /**
     * 修改招聘信息
     * 
     * @param recruitmentInfo 招聘信息
     * @return 结果
     */
    public int updateRecruitmentInfo(RecruitmentInfo recruitmentInfo);

    /**
     * 删除招聘信息
     * 
     * @param recruitmentId 招聘信息主键
     * @return 结果
     */
    public int deleteRecruitmentInfoByRecruitmentId(Long recruitmentId);

    /**
     * 批量删除招聘信息
     * 
     * @param recruitmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecruitmentInfoByRecruitmentIds(Long[] recruitmentIds);
}
