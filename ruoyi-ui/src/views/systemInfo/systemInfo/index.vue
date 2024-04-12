<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="系统名称" prop="systemName">
        <el-input
          v-model="queryParams.systemName"
          placeholder="请输入系统名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="系统Logo路径" prop="systemLogo">
        <el-input
          v-model="queryParams.systemLogo"
          placeholder="请输入系统Logo路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="轮播图路径" prop="systemCarousel">
        <el-input
          v-model="queryParams.systemCarousel"
          placeholder="请输入轮播图路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['systemInfo:systemInfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['systemInfo:systemInfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['systemInfo:systemInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['systemInfo:systemInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="systemInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="系统信息ID" align="center" prop="systemId" />
      <el-table-column label="系统名称" align="center" prop="systemName" />
      <el-table-column label="系统Logo路径" align="center" prop="systemLogo" />
      <el-table-column label="轮播图路径" align="center" prop="systemCarousel" />
      <el-table-column label="关于我们" align="center" prop="systemAboutus" />
      <el-table-column label="联系我们" align="center" prop="systemContactus" />
      <el-table-column label="隐私政策" align="center" prop="systemPrivacypolicy" />
      <el-table-column label="服务条款" align="center" prop="systemTermsofservice" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['systemInfo:systemInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['systemInfo:systemInfo:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改系统信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="系统名称" prop="systemName">
          <el-input v-model="form.systemName" placeholder="请输入系统名称" />
        </el-form-item>
        <el-form-item label="系统Logo路径" prop="systemLogo">
          <el-input v-model="form.systemLogo" placeholder="请输入系统Logo路径" />
        </el-form-item>
        <el-form-item label="轮播图路径" prop="systemCarousel">
          <el-input v-model="form.systemCarousel" placeholder="请输入轮播图路径" />
        </el-form-item>
        <el-form-item label="关于我们" prop="systemAboutus">
          <el-input v-model="form.systemAboutus" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="联系我们" prop="systemContactus">
          <el-input v-model="form.systemContactus" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="隐私政策" prop="systemPrivacypolicy">
          <el-input v-model="form.systemPrivacypolicy" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="服务条款" prop="systemTermsofservice">
          <el-input v-model="form.systemTermsofservice" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSystemInfo, getSystemInfo, delSystemInfo, addSystemInfo, updateSystemInfo } from "@/api/systemInfo/systemInfo";

export default {
  name: "SystemInfo",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 系统信息表格数据
      systemInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        systemName: null,
        systemLogo: null,
        systemCarousel: null,
        systemAboutus: null,
        systemContactus: null,
        systemPrivacypolicy: null,
        systemTermsofservice: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询系统信息列表 */
    getList() {
      this.loading = true;
      listSystemInfo(this.queryParams).then(response => {
        this.systemInfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        systemId: null,
        systemName: null,
        systemLogo: null,
        systemCarousel: null,
        systemAboutus: null,
        systemContactus: null,
        systemPrivacypolicy: null,
        systemTermsofservice: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.systemId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加系统信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const systemId = row.systemId || this.ids
      getSystemInfo(systemId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改系统信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.systemId != null) {
            updateSystemInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSystemInfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const systemIds = row.systemId || this.ids;
      this.$modal.confirm('是否确认删除系统信息编号为"' + systemIds + '"的数据项？').then(function() {
        return delSystemInfo(systemIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('systemInfo/systemInfo/export', {
        ...this.queryParams
      }, `systemInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
