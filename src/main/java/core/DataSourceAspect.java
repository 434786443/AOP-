package core;

import annotation.UsingDataSource;
import com.bearfang.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Aspect
@Configuration
public class DataSourceAspect {

    public DataSourceAspect(){
        System.out.println("this is init");
    }



    @Pointcut("@within(annotation.UsingDataSource) || " +
            "@annotation(annotation.UsingDataSource)")
    public void pointCut(){

    }

    @Before("pointCut() && @annotation(usingDataSource)")
    public void doBefore(UsingDataSource usingDataSource){
        log.debug("select dataSource---"+usingDataSource.type());
        DataSourceContextHolder.setDatabaseHolder(usingDataSource.type());
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clear();
    }

}
