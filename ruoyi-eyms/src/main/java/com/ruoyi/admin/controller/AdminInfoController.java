package com.ruoyi.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.admin.domain.AdminInfo;
import com.ruoyi.admin.service.IAdminInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 管理员信息Controller
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@RestController
@RequestMapping("/admin/AdminInfo")
public class AdminInfoController extends BaseController
{
    @Autowired
    private IAdminInfoService adminInfoService;

    /**
     * 查询管理员信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin:AdminInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(AdminInfo adminInfo)
    {
        startPage();
        List<AdminInfo> list = adminInfoService.selectAdminInfoList(adminInfo);
        return getDataTable(list);
    }

    /**
     * 导出管理员信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin:AdminInfo:export')")
    @Log(title = "管理员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AdminInfo adminInfo)
    {
        List<AdminInfo> list = adminInfoService.selectAdminInfoList(adminInfo);
        ExcelUtil<AdminInfo> util = new ExcelUtil<AdminInfo>(AdminInfo.class);
        util.exportExcel(response, list, "管理员信息数据");
    }

    /**
     * 获取管理员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:AdminInfo:query')")
    @GetMapping(value = "/{adminId}")
    public AjaxResult getInfo(@PathVariable("adminId") Long adminId)
    {
        return success(adminInfoService.selectAdminInfoByAdminId(adminId));
    }

    /**
     * 新增管理员信息
     */
    @PreAuthorize("@ss.hasPermi('admin:AdminInfo:add')")
    @Log(title = "管理员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdminInfo adminInfo)
    {
        return toAjax(adminInfoService.insertAdminInfo(adminInfo));
    }

    /**
     * 修改管理员信息
     */
    @PreAuthorize("@ss.hasPermi('admin:AdminInfo:edit')")
    @Log(title = "管理员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdminInfo adminInfo)
    {
        return toAjax(adminInfoService.updateAdminInfo(adminInfo));
    }

    /**
     * 删除管理员信息
     */
    @PreAuthorize("@ss.hasPermi('admin:AdminInfo:remove')")
    @Log(title = "管理员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{adminIds}")
    public AjaxResult remove(@PathVariable Long[] adminIds)
    {
        return toAjax(adminInfoService.deleteAdminInfoByAdminIds(adminIds));
    }
}
