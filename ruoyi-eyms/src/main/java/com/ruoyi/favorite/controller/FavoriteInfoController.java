package com.ruoyi.favorite.controller;

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
import com.ruoyi.favorite.domain.FavoriteInfo;
import com.ruoyi.favorite.service.IFavoriteInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收藏信息Controller
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@RestController
@RequestMapping("/favorite/favorite")
public class FavoriteInfoController extends BaseController
{
    @Autowired
    private IFavoriteInfoService favoriteInfoService;

    /**
     * 查询收藏信息列表
     */
    @PreAuthorize("@ss.hasPermi('favorite:favorite:list')")
    @GetMapping("/list")
    public TableDataInfo list(FavoriteInfo favoriteInfo)
    {
        startPage();
        List<FavoriteInfo> list = favoriteInfoService.selectFavoriteInfoList(favoriteInfo);
        return getDataTable(list);
    }

    /**
     * 导出收藏信息列表
     */
    @PreAuthorize("@ss.hasPermi('favorite:favorite:export')")
    @Log(title = "收藏信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FavoriteInfo favoriteInfo)
    {
        List<FavoriteInfo> list = favoriteInfoService.selectFavoriteInfoList(favoriteInfo);
        ExcelUtil<FavoriteInfo> util = new ExcelUtil<FavoriteInfo>(FavoriteInfo.class);
        util.exportExcel(response, list, "收藏信息数据");
    }

    /**
     * 获取收藏信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('favorite:favorite:query')")
    @GetMapping(value = "/{favoriteId}")
    public AjaxResult getInfo(@PathVariable("favoriteId") Long favoriteId)
    {
        return success(favoriteInfoService.selectFavoriteInfoByFavoriteId(favoriteId));
    }

    /**
     * 新增收藏信息
     */
    @PreAuthorize("@ss.hasPermi('favorite:favorite:add')")
    @Log(title = "收藏信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FavoriteInfo favoriteInfo)
    {
        return toAjax(favoriteInfoService.insertFavoriteInfo(favoriteInfo));
    }

    /**
     * 修改收藏信息
     */
    @PreAuthorize("@ss.hasPermi('favorite:favorite:edit')")
    @Log(title = "收藏信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FavoriteInfo favoriteInfo)
    {
        return toAjax(favoriteInfoService.updateFavoriteInfo(favoriteInfo));
    }

    /**
     * 删除收藏信息
     */
    @PreAuthorize("@ss.hasPermi('favorite:favorite:remove')")
    @Log(title = "收藏信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{favoriteIds}")
    public AjaxResult remove(@PathVariable Long[] favoriteIds)
    {
        return toAjax(favoriteInfoService.deleteFavoriteInfoByFavoriteIds(favoriteIds));
    }
}
