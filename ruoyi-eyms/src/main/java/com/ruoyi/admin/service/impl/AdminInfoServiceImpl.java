package com.ruoyi.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.admin.mapper.AdminInfoMapper;
import com.ruoyi.admin.domain.AdminInfo;
import com.ruoyi.admin.service.IAdminInfoService;

/**
 * 管理员信息Service业务层处理
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@Service
public class AdminInfoServiceImpl implements IAdminInfoService 
{
    @Autowired
    private AdminInfoMapper adminInfoMapper;

    /**
     * 查询管理员信息
     * 
     * @param adminId 管理员信息主键
     * @return 管理员信息
     */
    @Override
    public AdminInfo selectAdminInfoByAdminId(Long adminId)
    {
        return adminInfoMapper.selectAdminInfoByAdminId(adminId);
    }

    /**
     * 查询管理员信息列表
     * 
     * @param adminInfo 管理员信息
     * @return 管理员信息
     */
    @Override
    public List<AdminInfo> selectAdminInfoList(AdminInfo adminInfo)
    {
        return adminInfoMapper.selectAdminInfoList(adminInfo);
    }

    /**
     * 新增管理员信息
     * 
     * @param adminInfo 管理员信息
     * @return 结果
     */
    @Override
    public int insertAdminInfo(AdminInfo adminInfo)
    {
        return adminInfoMapper.insertAdminInfo(adminInfo);
    }

    /**
     * 修改管理员信息
     * 
     * @param adminInfo 管理员信息
     * @return 结果
     */
    @Override
    public int updateAdminInfo(AdminInfo adminInfo)
    {
        return adminInfoMapper.updateAdminInfo(adminInfo);
    }

    /**
     * 批量删除管理员信息
     * 
     * @param adminIds 需要删除的管理员信息主键
     * @return 结果
     */
    @Override
    public int deleteAdminInfoByAdminIds(Long[] adminIds)
    {
        return adminInfoMapper.deleteAdminInfoByAdminIds(adminIds);
    }

    /**
     * 删除管理员信息信息
     * 
     * @param adminId 管理员信息主键
     * @return 结果
     */
    @Override
    public int deleteAdminInfoByAdminId(Long adminId)
    {
        return adminInfoMapper.deleteAdminInfoByAdminId(adminId);
    }
}
