package com.fatehole.blog;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * MyBatis-Plus的代码生成器
 * @author helaos
 * @version 1.0.0
 * @date Create in 2021/03/08/20:39
 */
public class CodeGenerator {

    /**
     * 代码生成
     */
    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        gc.setOutputDir(projectPath + "/src/main/java");
        // 设置作者
        gc.setAuthor("helaos");
        // 生成后是否打开资源管理器
        gc.setOpen(false);
        // 重新生成时文件是否覆盖
        gc.setFileOverride(false);
        // 去掉Service接口的首字母I
        gc.setServiceName("%sService");
        // 主键策略
        gc.setIdType(IdType.ASSIGN_ID);
        // 定义生成的实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // url
        dsc.setUrl("jdbc:mysql://localhost:3306/anchor_blog?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        // 数据库驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // 用户名
        dsc.setUsername("root");
        // 密码
        dsc.setPassword("12138");
        // 设置数据库类型
        dsc.setDbType(DbType.MYSQL);

        mpg.setDataSource(dsc);

        // 包名策略配置
        PackageConfig pc = new PackageConfig();

        pc.setParent("com.fatehole.blog");
        // 模块名
        // pc.setModuleName("pms");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        /*
         * TODO: 提交的时候不要提交这个代码生成器
         */
        // 要生成的表名
        strategy.setInclude("t_blog", "t_user", "t_comment", "t_blog_tags", "t_tag", "t_type");
        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 生成实体时去掉表前缀
        strategy.setTablePrefix("t" + "_");
        // 数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // @Accessors(chain = true) setter链式操作
        strategy.setChainModel(true);
        // lombok 模型
        strategy.setEntityLombokModel(true);
        // Boolean类型字段是否移除is前缀, 数据库字段名称 : 'is_xxx',类型为 : tinyint. 在映射实体的时候则会去掉is,在实体类中映射最终结果为 xxx
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        // 设置逻辑删除字段的名字
        strategy.setLogicDeleteFieldName("deleted");
        // restful api风格控制器
        strategy.setRestControllerStyle(true);
        // url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntitySerialVersionUID(true);
        // 实体生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);

        // 自动填充策略
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);

        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);

        strategy.setTableFillList(tableFills);

        // 乐观锁的配置
        strategy.setVersionFieldName("version");
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);

        // 执行
        mpg.execute();

    }

}
