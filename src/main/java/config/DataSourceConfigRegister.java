package config;

import annotation.AppDataSource;
import com.bearfang.DataSourceContextHolder;
import enums.SupportDatasourceEnum;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * 注册器：把AppDataSource的类型都配置好
 */
@Slf4j
@Component
public class DataSourceConfigRegister implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(AppDataSource.class.getName()));
        System.out.println("#######  datasource import #######");
        if (null != attributes) {
            Object object = attributes.get("datasourceType");
            SupportDatasourceEnum[] supportDatasourceEnums = (SupportDatasourceEnum[]) object;
            for (SupportDatasourceEnum supportDatasourceEnum : supportDatasourceEnums) {
                DataSourceContextHolder.addDatasource(supportDatasourceEnum);
            }
        }
        return new String[0];
    }


}