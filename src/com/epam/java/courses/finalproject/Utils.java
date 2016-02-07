package com.epam.java.courses.finalproject;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public interface Utils {

    static <T> T getEntity(ResultSet resultSet, Class<T> aClass) throws IllegalAccessException, InstantiationException {

        T instance = aClass.newInstance();

        Stream.of(aClass.getDeclaredFields())
                .peek(field -> field.setAccessible(true))
                .filter(field -> true) // TODO: Проверять а-ля JSR-349 аннотации!
                .forEach(field -> setFieldValue(field, instance, resultSet)); // TODO: по-хорошему, тут нужен самостоятельный коллектор, но писать его достаточно долго и сложно

        return instance;
    }

    static <T> void setFieldValue(Field field, T instance, ResultSet resultSet) {
        try {
            String name = field.getName();
            Class<?> type = field.getType();

            if (type == Integer.class || type == int.class) {
                field.setInt(instance, resultSet.getInt(name));
            } else if (type == String.class) {
                field.set(instance, resultSet.getString(name));
            } else if (type == Boolean.class || type == boolean.class) {
                field.setBoolean(instance, resultSet.getBoolean(name));
            } //TODO: Сделать для остальных примитивов
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static <T> Collection<T> getEntities(ResultSet resultSet, Class<T> aClass) {
        try {
            Collection<T> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(getEntity(resultSet, aClass));
            }
            return result;
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

//    static String toCamelCase(String name) {
//        int i = name.indexOf('_');
//        if (i != -1) {
//            char[] chars = name.toCharArray();
//            StringBuffer result = new StringBuffer("");
//            if (chars[i] != '_') {
//                result.append(chars[i++]);
//            } else {
//                i++;
//                if (chars[i] != '_') {
//                    result.append(new Character(chars[i++]).toUpperCase());
//                }
//            }
//
//            if (split.length > 1)
//                for (String s : Arrays.split)
//        } else
//            return name;
//    }

    @SuppressWarnings("unchecked")
    static <T> T localJndiSearch(String name, Class<T> aClass) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            Object o = envContext.lookup(name);
            if (aClass.isInstance(o))
                return (T) o;
            else
                throw new NamingException("Object, founded by " + name + " name is not an instance of class " + aClass.getName());
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
