package com.ruoyi.recruitment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruitment.mapper.RecruitmentInfoMapper;
import com.ruoyi.recruitment.domain.RecruitmentInfo;
import com.ruoyi.recruitment.service.IRecruitmentInfoService;

/**
 * 招聘信息Service业务层处理
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@Service
public class RecruitmentInfoServiceImpl implements IRecruitmentInfoService 
{
    @Autowired
    private RecruitmentInfoMapper recruitmentInfoMapper;

    /**
     * 查询招聘信息
     * 
     * @param recruitmentId 招聘信息主键
     * @return 招聘信息
     */
    @Override
    public RecruitmentInfo selectRecruitmentInfoByRecruitmentId(Long recruitmentId)
    {
        return recruitmentInfoMapper.selectRecruitmentInfoByRecruitmentId(recruitmentId);
    }

    /**
     * 查询招聘信息列表
     * 
     * @param recruitmentInfo 招聘信息
     * @return 招聘信息
     */
    @Override
    public List<RecruitmentInfo> selectRecruitmentInfoList(RecruitmentInfo recruitmentInfo)
    {
        return recruitmentInfoMapper.selectRecruitmentInfoList(recruitmentInfo);
    }

    /**
     * 新增招聘信息
     * 
     * @param recruitmentInfo 招聘信息
     * @return 结果
     */
    @Override
    public int insertRecruitmentInfo(RecruitmentInfo recruitmentInfo)
    {
        return recruitmentInfoMapper.insertRecruitmentInfo(recruitmentInfo);
    }

    /**
     * 修改招聘信息
     * 
     * @param recruitmentInfo 招聘信息
     * @return 结果
     */
    @Override
    public int updateRecruitmentInfo(RecruitmentInfo recruitmentInfo)
    {
        return recruitmentInfoMapper.updateRecruitmentInfo(recruitmentInfo);
    }

    /**
     * 批量删除招聘信息
     * 
     * @param recruitmentIds 需要删除的招聘信息主键
     * @return 结果
     */
    @Override
    public int deleteRecruitmentInfoByRecruitmentIds(Long[] recruitmentIds)
    {
        return recruitmentInfoMapper.deleteRecruitmentInfoByRecruitmentIds(recruitmentIds);
    }

    /**
     * 删除招聘信息信息
     * 
     * @param recruitmentId 招聘信息主键
     * @return 结果
     */
    @Override
    public int deleteRecruitmentInfoByRecruitmentId(Long recruitmentId)
    {
        return recruitmentInfoMapper.deleteRecruitmentInfoByRecruitmentId(recruitmentId);
    }
}
