package com.dolgov.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.StringJoiner;

// "SELECT person_id, person_name, salary FROM Persons;";
public class QueryGenerator {

    public String getAll(Class clazz) {
        Annotation classAnnotation = clazz.getAnnotation(Table.class);
        Table tableAnnotation = (Table) classAnnotation;

        if (tableAnnotation == null) {
            throw new IllegalArgumentException("@Table is not present");
        }

        String tableName = tableAnnotation.name().isEmpty() ?
                clazz.getName() : tableAnnotation.name();

        // person_id, person_name, salary
        StringJoiner columns = new StringJoiner(", ");
        for (Field field : clazz.getDeclaredFields()) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                String columnName = columnAnnotation.name().isEmpty() ?
                        field.getName() : columnAnnotation.name();
                columns.add(columnName);
            }
        }

        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        stringBuilder.append(columns.toString());
        stringBuilder.append(" FROM ");
        stringBuilder.append(tableName);
        stringBuilder.append(";");

        return stringBuilder.toString();
    }

    public String insert(Object value) throws IllegalAccessException {

        Class objClass = value.getClass();

        Annotation classAnnotation = objClass.getAnnotation(Table.class);
        Table tableAnnotation      = (Table) classAnnotation;

        if (tableAnnotation == null) {
            throw new IllegalArgumentException("@Table is not present");
        }

        String tableName = tableAnnotation.name().isEmpty() ? objClass.getName() : tableAnnotation.name();

        // person_id, person_name, salary
        StringJoiner columns = new StringJoiner(", ");
        StringJoiner values  = new StringJoiner(", ");

        for (Field classField : objClass.getDeclaredFields()) {

            Column columnAnnotation = classField.getAnnotation(Column.class);
            // get column string
            if (columnAnnotation != null) {
                String columnName = columnAnnotation.name().isEmpty() ? classField.getName() : columnAnnotation.name();
                columns.add(columnName);

                // get values string
                if ( classField.getType() == String.class) {
                    values.add("'" + classField.get(value).toString() + "'");
                } else {
                    values.add(classField.get(value).toString());
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder("INSERT INTO ");
        stringBuilder.append(tableName);
        stringBuilder.append(" ( ");
        stringBuilder.append(columns.toString());
        stringBuilder.append(" ) VALUES ( ");
        stringBuilder.append(values);
        stringBuilder.append(" );");

        return stringBuilder.toString();
    }

    public String getById(Class clazz, Object id) throws NoSuchFieldException, IllegalAccessException {

        Annotation classAnnotation = clazz.getAnnotation(Table.class);
        Table      tableAnnotation = (Table) classAnnotation;

        if (tableAnnotation == null) {
            throw new IllegalArgumentException("@Table is not present");
        }

        String tableName        = tableAnnotation.name().isEmpty() ? clazz.getName() : tableAnnotation.name();

        String filterColumnName = "";
        StringJoiner columns    = new StringJoiner(", ");

        for (Field classField : clazz.getDeclaredFields()) {

            Column columnAnnotation = classField.getAnnotation(Column.class);
            // get column string
            if (columnAnnotation != null) {
                String columnName = columnAnnotation.name().isEmpty() ? classField.getName() : columnAnnotation.name();
                columns.add(columnName);

                if ( classField.getName() == "id") {
                    filterColumnName = columnAnnotation.name().isEmpty() ? classField.getName() : columnAnnotation.name();
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        stringBuilder.append(columns.toString());
        stringBuilder.append(" FROM ");
        stringBuilder.append(tableName);
        stringBuilder.append(" WHERE ");
        stringBuilder.append(filterColumnName);
        stringBuilder.append(" = ");
        stringBuilder.append(id.toString());
        stringBuilder.append(";");

        return stringBuilder.toString();
    }

    public String delete(Class clazz, Object id) {
        Annotation classAnnotation = clazz.getAnnotation(Table.class);
        Table      tableAnnotation = (Table) classAnnotation;

        if (tableAnnotation == null) {
            throw new IllegalArgumentException("@Table is not present");
        }

        String tableName = tableAnnotation.name().isEmpty() ? clazz.getName() : tableAnnotation.name();

        Class objClass = id.getClass();
        String columnName = "";

        for (Field classField : clazz.getDeclaredFields()) {

            Column columnAnnotation = classField.getAnnotation(Column.class);
            // get column string
            if (columnAnnotation != null && classField.getName() == "id") {
                columnName = columnAnnotation.name().isEmpty() ? classField.getName() : columnAnnotation.name();

            }
        }
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM ");
        stringBuilder.append(tableName);
        stringBuilder.append(" WHERE ");
        stringBuilder.append(columnName);
        stringBuilder.append(" = ");
        stringBuilder.append(id.toString());
        stringBuilder.append(";");

        return stringBuilder.toString();
    }
}