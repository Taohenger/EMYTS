package com.ruoyi.systemInfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.systemInfo.mapper.SystemInfoMapper;
import com.ruoyi.systemInfo.domain.SystemInfo;
import com.ruoyi.systemInfo.service.ISystemInfoService;

/**
 * 系统信息Service业务层处理
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@Service
public class SystemInfoServiceImpl implements ISystemInfoService 
{
    @Autowired
    private SystemInfoMapper systemInfoMapper;

    /**
     * 查询系统信息
     * 
     * @param systemId 系统信息主键
     * @return 系统信息
     */
    @Override
    public SystemInfo selectSystemInfoBySystemId(Long systemId)
    {
        return systemInfoMapper.selectSystemInfoBySystemId(systemId);
    }

    /**
     * 查询系统信息列表
     * 
     * @param systemInfo 系统信息
     * @return 系统信息
     */
    @Override
    public List<SystemInfo> selectSystemInfoList(SystemInfo systemInfo)
    {
        return systemInfoMapper.selectSystemInfoList(systemInfo);
    }

    /**
     * 新增系统信息
     * 
     * @param systemInfo 系统信息
     * @return 结果
     */
    @Override
    public int insertSystemInfo(SystemInfo systemInfo)
    {
        return systemInfoMapper.insertSystemInfo(systemInfo);
    }

    /**
     * 修改系统信息
     * 
     * @param systemInfo 系统信息
     * @return 结果
     */
    @Override
    public int updateSystemInfo(SystemInfo systemInfo)
    {
        return systemInfoMapper.updateSystemInfo(systemInfo);
    }

    /**
     * 批量删除系统信息
     * 
     * @param systemIds 需要删除的系统信息主键
     * @return 结果
     */
    @Override
    public int deleteSystemInfoBySystemIds(Long[] systemIds)
    {
        return systemInfoMapper.deleteSystemInfoBySystemIds(systemIds);
    }

    /**
     * 删除系统信息信息
     * 
     * @param systemId 系统信息主键
     * @return 结果
     */
    @Override
    public int deleteSystemInfoBySystemId(Long systemId)
    {
        return systemInfoMapper.deleteSystemInfoBySystemId(systemId);
    }
}
