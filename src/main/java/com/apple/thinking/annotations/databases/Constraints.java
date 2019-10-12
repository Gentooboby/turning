package com.apple.thinking.annotations.databases;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 修饰字段注解
 * 注解@Constraints允许处理器数据库表的元数据。@Constraints代表了数据库通常提供的约束的一小部分，但是他所要表达的思想已经很清楚
 * primary()，allowNull()和unique()元素明显的提供了默认值，从而使得在大多数情况下，该注解的使用者不需要输入太多东西。
 *
 *
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    boolean primaryKey() default false;

    boolean allowNull() default true;

    boolean unique() default false;
}
