package annotation;

import config.DataSourceConfigRegister;
import enums.SupportDatasourceEnum;
import org.springframework.context.annotation.Import;


import java.lang.annotation.*;

/**
 * 注入数据源
 *
 * @author idea
 * @data 2020/3/7
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DataSourceConfigRegister.class)
public @interface AppDataSource {

    SupportDatasourceEnum[] datasourceType();
}
