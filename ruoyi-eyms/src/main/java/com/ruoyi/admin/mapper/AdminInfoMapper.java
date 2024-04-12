package com.ruoyi.admin.mapper;

import java.util.List;
import com.ruoyi.admin.domain.AdminInfo;

/**
 * 管理员信息Mapper接口
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public interface AdminInfoMapper 
{
    /**
     * 查询管理员信息
     * 
     * @param adminId 管理员信息主键
     * @return 管理员信息
     */
    public AdminInfo selectAdminInfoByAdminId(Long adminId);

    /**
     * 查询管理员信息列表
     * 
     * @param adminInfo 管理员信息
     * @return 管理员信息集合
     */
    public List<AdminInfo> selectAdminInfoList(AdminInfo adminInfo);

    /**
     * 新增管理员信息
     * 
     * @param adminInfo 管理员信息
     * @return 结果
     */
    public int insertAdminInfo(AdminInfo adminInfo);

    /**
     * 修改管理员信息
     * 
     * @param adminInfo 管理员信息
     * @return 结果
     */
    public int updateAdminInfo(AdminInfo adminInfo);

    /**
     * 删除管理员信息
     * 
     * @param adminId 管理员信息主键
     * @return 结果
     */
    public int deleteAdminInfoByAdminId(Long adminId);

    /**
     * 批量删除管理员信息
     * 
     * @param adminIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdminInfoByAdminIds(Long[] adminIds);
}
