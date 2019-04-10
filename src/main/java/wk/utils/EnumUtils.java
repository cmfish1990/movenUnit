/*
 * cf
 * FileName: EnumUtils.java
 * Author:   BM
 * Date:     2019-04-03 13:44:37
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 13:44:37> <version> <desc> <source>
 *
 */

package wk.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 枚举工具类。
 */
public class EnumUtils {

    private EnumUtils() {
    }

    /**
     * 该方法可以根据枚举的名称（name）获取枚举对象。<br/>
     * 通过反射进行获取。
     *
     * @param enumType 枚举类型
     * @param str      枚举名称
     * @param <T>      泛型定义枚举类型
     * @return 指定类型的枚举对象，如果内部错误则返回null
     */
    public static <T extends Enum<T>> T getEnumInstance(Class<T> enumType, String str) {
        T enumClass = null;
        try {
            enumClass = Enum.valueOf(enumType, str);
        } catch (Exception e) {
            try {
                T[] enums = enumType.getEnumConstants();
                for (T instance : enums) {
                    if (enumClass != null) {
                        break;
                    }
                    Field[] fields = instance.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (str.equalsIgnoreCase(field.get(instance).toString())) {
                            enumClass = instance;
                            break;
                        }
                    }
                }
            } catch (Exception ex) {
                enumClass = null;
            }
        }
        return enumClass;
    }

    /**
     * 根据枚举名称（name）获取指定字段的值。
     *
     * @param enumType  枚举类型
     * @param enumName  枚举名称
     * @param fieldName 字段名
     * @param <T>       泛型定义枚举类型
     * @return 指定字段的值，如果内部错误则返回null
     */
    public static <T extends Enum<T>> Object getFieldValue(Class<T> enumType, String enumName, String fieldName) {
        Object value = null;
        Object enumClass = null;
        try {
            T[] enums = enumType.getEnumConstants();
            for (T instance : enums) {
                if (enumName.equalsIgnoreCase(instance.name())) {
                    enumClass = instance;
                    break;
                }
            }
            Field[] fields = enumClass.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (fieldName.equalsIgnoreCase(field.getName())) {
                    value = field.get(enumClass);
                    break;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return value;
    }

    /**
     * 判断指定字符串是否是枚举类中的一项。<br/>
     * 比较过程不区分大小写。
     *
     * @param enumType   枚举类型
     * @param enumValue  指定字符串值
     * @param fieldName  需要匹配的字段名称
     * @param ignoreNull 是否忽略null
     * @param <T>        枚举类型泛型
     * @return 如果忽略空，则传入是空则，返回true；如果不忽略空，如果是枚举项则返回true，否则或异常则返回false；
     */
    public static <T extends Enum<T>> boolean isEnumItem(Class<T> enumType, String enumValue, String fieldName, boolean ignoreNull) {
        if (ignoreNull && "null".equals(String.valueOf(enumValue))) {
            return true;
        }
        boolean isEnum = false;
        try {
            T[] enums = enumType.getEnumConstants();
            for (T instance : enums) {
                /*if (enumName.equalsIgnoreCase(instance.name())) {
                    isEnum = true;
                    break;
                }*/
                Field field = instance.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                if (enumValue.equalsIgnoreCase(field.get(instance).toString())) {
                    isEnum = true;
                    break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return isEnum;
    }

    /**
     * 判断指定字符串是否是枚举类中的一项。<br/>
     * 比较过程不区分大小写。
     * @see #isEnumItem(Class, String, String, boolean)
     */
    public static <T extends Enum<T>> boolean isEnumItem(Class<T> enumType, String enumValue, String fieldName) {
        return isEnumItem(enumType, enumValue, fieldName, true);
    }

    /**
     * 判断指定字符串是否是枚举类中的一项，将与code这个字段进行匹配。
     *
     * @see #isEnumItem(Class, String, String, boolean)
     */
    public static <T extends Enum<T>> boolean isEnumItem(Class<T> enumType, String enumValue, boolean ignoreNull) {
        return isEnumItem(enumType, enumValue, "code", ignoreNull);
    }

    /**
     * 判断指定字符串是否是枚举类中的一项，将与code这个字段进行匹配。
     *
     * @see #isEnumItem(Class, String, String)
     */
    public static <T extends Enum<T>> boolean isEnumItem(Class<T> enumType, String enumValue) {
        return isEnumItem(enumType, enumValue, "code");
    }

    /**
     * 判断指定数值是否是枚举类中的一项，将与code这个字段进行匹配。
     *
     * @see #isEnumItem(Class, String, String, boolean)
     */
    public static <T extends Enum<T>> boolean isEnumItem(Class<T> enumType, Integer enumValue, boolean ignoreNull) {
        return isEnumItem(enumType, String.valueOf(enumValue), "code",ignoreNull);
    }

    /**
     * 判断指定数值是否是枚举类中的一项，将与code这个字段进行匹配。
     *
     * @see #isEnumItem(Class, Integer, boolean)
     */
    public static <T extends Enum<T>> boolean isEnumItem(Class<T> enumType, Integer enumValue) {
        return isEnumItem(enumType, String.valueOf(enumValue), "code", true);
    }

    /**
     * 判断指定字符串是否是枚举类中的一项，将与code这个字段进行匹配。
     *
     * @see #isEnumItem(Class, Long, boolean)
     */
    public static <T extends Enum<T>> boolean isEnumItem(Class<T> enumType, Long enumValue, boolean ignoreNull) {
        return isEnumItem(enumType, String.valueOf(enumValue), "code",ignoreNull);
    }

    /**
     * 判断指定字符串是否是枚举类中的一项，将与code这个字段进行匹配。
     *
     * @see #isEnumItem(Class, String, String)
     */
    public static <T extends Enum<T>> boolean isEnumItem(Class<T> enumType, Long enumValue) {
        return isEnumItem(enumType, String.valueOf(enumValue), "code",true);
    }

    /**
     * 获取枚举类中指定属性所有枚举对象对应的值。
     *
     * @param enumType  枚举类
     * @param fieldName 字段名称
     * @param <T>       枚举类型
     * @return 指定字段的所有值集合
     */
    public static <T extends Enum<T>> List<String> getEnumItems(Class<T> enumType, String fieldName) {
        List<String> items = new ArrayList<String>();
        try {
            T[] enums = enumType.getEnumConstants();
            for (T instance : enums) {
                Field[] fields = instance.getClass().getDeclaredFields();
                if (fieldName.equalsIgnoreCase("name")) {
                    fields = Enum.class.getDeclaredFields();
                }
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (fieldName.equalsIgnoreCase(field.getName())) {
                        items.add((String) field.get(instance));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            items.add(e.getMessage());
        }
        return items;
    }

    /**
     * 获取枚举类中指定"code"属性所有枚举对象对应的值。
     *
     * @see #getEnumItems(Class, String)
     */
    public static <T extends Enum<T>> List<String> getEnumItems(Class<T> enumType) {
        return getEnumItems(enumType, "code");
    }

}
