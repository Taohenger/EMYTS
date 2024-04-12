package com.ruoyi.systemInfo.controller;

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
import com.ruoyi.systemInfo.domain.SystemInfo;
import com.ruoyi.systemInfo.service.ISystemInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统信息Controller
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@RestController
@RequestMapping("/systemInfo/systemInfo")
public class SystemInfoController extends BaseController
{
    @Autowired
    private ISystemInfoService systemInfoService;

    /**
     * 查询系统信息列表
     */
    @PreAuthorize("@ss.hasPermi('systemInfo:systemInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SystemInfo systemInfo)
    {
        startPage();
        List<SystemInfo> list = systemInfoService.selectSystemInfoList(systemInfo);
        return getDataTable(list);
    }

    /**
     * 导出系统信息列表
     */
    @PreAuthorize("@ss.hasPermi('systemInfo:systemInfo:export')")
    @Log(title = "系统信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SystemInfo systemInfo)
    {
        List<SystemInfo> list = systemInfoService.selectSystemInfoList(systemInfo);
        ExcelUtil<SystemInfo> util = new ExcelUtil<SystemInfo>(SystemInfo.class);
        util.exportExcel(response, list, "系统信息数据");
    }

    /**
     * 获取系统信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('systemInfo:systemInfo:query')")
    @GetMapping(value = "/{systemId}")
    public AjaxResult getInfo(@PathVariable("systemId") Long systemId)
    {
        return success(systemInfoService.selectSystemInfoBySystemId(systemId));
    }

    /**
     * 新增系统信息
     */
    @PreAuthorize("@ss.hasPermi('systemInfo:systemInfo:add')")
    @Log(title = "系统信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SystemInfo systemInfo)
    {
        return toAjax(systemInfoService.insertSystemInfo(systemInfo));
    }

    /**
     * 修改系统信息
     */
    @PreAuthorize("@ss.hasPermi('systemInfo:systemInfo:edit')")
    @Log(title = "系统信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SystemInfo systemInfo)
    {
        return toAjax(systemInfoService.updateSystemInfo(systemInfo));
    }

    /**
     * 删除系统信息
     */
    @PreAuthorize("@ss.hasPermi('systemInfo:systemInfo:remove')")
    @Log(title = "系统信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{systemIds}")
    public AjaxResult remove(@PathVariable Long[] systemIds)
    {
        return toAjax(systemInfoService.deleteSystemInfoBySystemIds(systemIds));
    }
}
