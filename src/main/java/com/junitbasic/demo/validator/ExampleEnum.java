package com.junitbasic.demo.validator;

public enum ExampleEnum {
    VALUE_01("01"),
    VALUE_02("02"),
    VALUE_03("03"),
    VALUE_04("04"),
    VALUE_99("99");

    private final String key;

    ExampleEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static boolean isValidKey(String key) {
        for (ExampleEnum e : ExampleEnum.values()) {
            if (e.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
}
