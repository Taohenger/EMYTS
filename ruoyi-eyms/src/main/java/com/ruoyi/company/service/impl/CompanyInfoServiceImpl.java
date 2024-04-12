package com.ruoyi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.company.mapper.CompanyInfoMapper;
import com.ruoyi.company.domain.CompanyInfo;
import com.ruoyi.company.service.ICompanyInfoService;

/**
 * 企业信息Service业务层处理
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@Service
public class CompanyInfoServiceImpl implements ICompanyInfoService 
{
    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    /**
     * 查询企业信息
     * 
     * @param companyId 企业信息主键
     * @return 企业信息
     */
    @Override
    public CompanyInfo selectCompanyInfoByCompanyId(Long companyId)
    {
        return companyInfoMapper.selectCompanyInfoByCompanyId(companyId);
    }

    /**
     * 查询企业信息列表
     * 
     * @param companyInfo 企业信息
     * @return 企业信息
     */
    @Override
    public List<CompanyInfo> selectCompanyInfoList(CompanyInfo companyInfo)
    {
        return companyInfoMapper.selectCompanyInfoList(companyInfo);
    }

    /**
     * 新增企业信息
     * 
     * @param companyInfo 企业信息
     * @return 结果
     */
    @Override
    public int insertCompanyInfo(CompanyInfo companyInfo)
    {
        return companyInfoMapper.insertCompanyInfo(companyInfo);
    }

    /**
     * 修改企业信息
     * 
     * @param companyInfo 企业信息
     * @return 结果
     */
    @Override
    public int updateCompanyInfo(CompanyInfo companyInfo)
    {
        return companyInfoMapper.updateCompanyInfo(companyInfo);
    }

    /**
     * 批量删除企业信息
     * 
     * @param companyIds 需要删除的企业信息主键
     * @return 结果
     */
    @Override
    public int deleteCompanyInfoByCompanyIds(Long[] companyIds)
    {
        return companyInfoMapper.deleteCompanyInfoByCompanyIds(companyIds);
    }

    /**
     * 删除企业信息信息
     * 
     * @param companyId 企业信息主键
     * @return 结果
     */
    @Override
    public int deleteCompanyInfoByCompanyId(Long companyId)
    {
        return companyInfoMapper.deleteCompanyInfoByCompanyId(companyId);
    }
}
