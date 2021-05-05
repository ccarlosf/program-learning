package com.ccarlos.rabbit.task.annotation;

import org.springframework.context.annotation.Import;
import com.ccarlos.rabbit.task.autoconfigure.JobParserAutoConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(JobParserAutoConfiguration.class)
public @interface EnableElasticJob {

}
