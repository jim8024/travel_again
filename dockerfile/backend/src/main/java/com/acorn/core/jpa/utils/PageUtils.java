package com.acorn.core.jpa.utils;

import com.querydsl.core.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Set;

@Component
public class PageUtils {


    private static int page;

    private static int size;

    private static String direction ;


    private static String properties;
    @Value("${pageing.page:0}")
    public void setPage(int page) {
        this.page = page;
    }

    @Value("${pageing.size:10}")
    public void setSize(int size) {
        this.size = size;
    }

    @Value("${pageing.direction:asc}")
    public void setDirection(String direction) {
        this.direction = direction;
    }
    @Value("${pageing.properties")
    public void setProperties(String properties) {
        this.properties = properties;
    }




    public static <T> Pageable getPageable(T source) {
        Set<Field> fields =  ReflectionUtils.getFields(source.getClass());

        int page = PageUtils.page;
        int size = PageUtils.size;
        String direction = PageUtils.direction;
        String[] properties = new String[0];

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if ("page".equals(field.getName())) page = getPageValue(  field,  source );
                if ("size".equals(field.getName())) size = getSizeValue(  field,  source );
                if ("direction".equals(field.getName())) direction = getDirectionValue(  field,  source );
                if ("properties".equals(field.getName()))  properties = getProperties( field,  source );
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        return  PageRequest.of(page, size);
    }

    public static <T> Pageable getPageable() {

        return  PageRequest.of(page, size );
    }

    private static <T> int getPageValue(Field field, T source ) throws IllegalAccessException {
        if ("page".equals(field.getName())) {
            if (Objects.nonNull(field.get(source))) {
                return (int) field.get(source);
            }
        }
        return PageUtils.page;
    }

    private static <T> int getSizeValue(Field field, T source ) throws IllegalAccessException {
        if ("size".equals(field.getName())) {
            if (Objects.nonNull(field.get(source))) {
                return (int) field.get(source);
            }
        }
        return PageUtils.size;
    }

    private static <T> String getDirectionValue(Field field, T source ) throws IllegalAccessException {
        if ("direction".equals(field.getName())) {
            if (Objects.nonNull(field.get(source))) {
                return (String) field.get(source);
            }
        }
        return "ASC";
    }

    private static <T> String[]  getProperties(Field field, T source ) throws IllegalAccessException {
        if ("properties".equals(field.getName())) {
            if (Objects.nonNull(field.get(source))) {
                 return field.get(source).toString().split(",");
            }
        }
        return null;
    }
}
