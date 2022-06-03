package com.eveningbread.demo.common.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //이 어노테이션이 사용되는 범위는 메소드까지
@Retention(RetentionPolicy.RUNTIME) //어노테이션이 유지되는 정책 : 런타임
public @interface LogExecutionTime {
}
