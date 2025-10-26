package com.eatexpress.app.common.utils;

import java.util.Arrays;

public class EnumUtils {

    private EnumUtils() {}

    public static String[] enumToStringArray(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants())
            .map(Enum::name)
            .toArray(String[]::new);
    }

    public static String[] enumToStringArrayDisplayName(
        Class<? extends Enum<?>> enumClass
    ) {
        return Arrays.stream(enumClass.getEnumConstants())
            .map(enumConstant -> {
                try {
                    // try common getter name
                    return (String) enumClass
                        .getMethod("getDisplayName")
                        .invoke(enumConstant);
                } catch (Exception ex) {
                    // fallback to toString()
                    return enumConstant.toString();
                }
            })
            .toArray(String[]::new);
    }
}
