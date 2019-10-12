package com.apple.thinking.annotations.databases;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.apple.util.Print.print;

/**
 * 处理器
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        handle(args);
    }

    public static void handle(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            print("arguments: annotated classes");
            System.exit(0);
        }

        for (String className : args) {
            Class<?> clazz = Class.forName(className);
            DBTable dbTable = clazz.getAnnotation(DBTable.class);
            if (dbTable == null) {
                print("No DBTable annotations in class" + className);
                continue;
            }

            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                // if the name is empty, use class name
                tableName = clazz.getSimpleName().toUpperCase();
            }

            List<String> columDefs = new ArrayList<>();
            for (Field field : clazz.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    print("arguments: annotated field");
                    continue;
                }

                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];

                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }

                    columDefs.add(columnName + " INT " + getConstraints(sInt.constraints()));
                }

                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }

                    columDefs.add(columnName + " VARCHAR(" + sString.value() + ") " + getConstraints(sString.constraints()));
                }
            }

            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columDef : columDefs) {
                createCommand.append("\n" + columDef + ",");
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                print("Table Create SQL for " + className + "is:\n" + tableCreate);
            }
        }

    }


    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }

        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }

        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
