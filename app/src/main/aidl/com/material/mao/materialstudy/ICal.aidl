// ICal.aidl
package com.material.mao.materialstudy;

// Declare any non-default types here with import statements

interface ICal {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    int add(int x, int y);
    int min(int x, int y);
}
