package com.ruoyi.company.service;

import java.util.List;
import com.ruoyi.company.domain.CompanyInfo;

/**
 * 企业信息Service接口
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public interface ICompanyInfoService 
{
    /**
     * 查询企业信息
     * 
     * @param companyId 企业信息主键
     * @return 企业信息
     */
    public CompanyInfo selectCompanyInfoByCompanyId(Long companyId);

    /**
     * 查询企业信息列表
     * 
     * @param companyInfo 企业信息
     * @return 企业信息集合
     */
    public List<CompanyInfo> selectCompanyInfoList(CompanyInfo companyInfo);

    /**
     * 新增企业信息
     * 
     * @param companyInfo 企业信息
     * @return 结果
     */
    public int insertCompanyInfo(CompanyInfo companyInfo);

    /**
     * 修改企业信息
     * 
     * @param companyInfo 企业信息
     * @return 结果
     */
    public int updateCompanyInfo(CompanyInfo companyInfo);

    /**
     * 批量删除企业信息
     * 
     * @param companyIds 需要删除的企业信息主键集合
     * @return 结果
     */
    public int deleteCompanyInfoByCompanyIds(Long[] companyIds);

    /**
     * 删除企业信息信息
     * 
     * @param companyId 企业信息主键
     * @return 结果
     */
    public int deleteCompanyInfoByCompanyId(Long companyId);
}
