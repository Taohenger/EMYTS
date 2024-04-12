package com.ruoyi.systemInfo.service;

import java.util.List;
import com.ruoyi.systemInfo.domain.SystemInfo;

/**
 * 系统信息Service接口
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public interface ISystemInfoService 
{
    /**
     * 查询系统信息
     * 
     * @param systemId 系统信息主键
     * @return 系统信息
     */
    public SystemInfo selectSystemInfoBySystemId(Long systemId);

    /**
     * 查询系统信息列表
     * 
     * @param systemInfo 系统信息
     * @return 系统信息集合
     */
    public List<SystemInfo> selectSystemInfoList(SystemInfo systemInfo);

    /**
     * 新增系统信息
     * 
     * @param systemInfo 系统信息
     * @return 结果
     */
    public int insertSystemInfo(SystemInfo systemInfo);

    /**
     * 修改系统信息
     * 
     * @param systemInfo 系统信息
     * @return 结果
     */
    public int updateSystemInfo(SystemInfo systemInfo);

    /**
     * 批量删除系统信息
     * 
     * @param systemIds 需要删除的系统信息主键集合
     * @return 结果
     */
    public int deleteSystemInfoBySystemIds(Long[] systemIds);

    /**
     * 删除系统信息信息
     * 
     * @param systemId 系统信息主键
     * @return 结果
     */
    public int deleteSystemInfoBySystemId(Long systemId);
}
