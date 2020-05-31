package com.example.viewoptprocessor;

import javax.lang.model.element.TypeElement;

final class ClassValidator {
    static String getClassName(TypeElement type, String packageName) {
        int packageLen = packageName.length() + 1;
        return type.getQualifiedName().toString().substring(packageLen)
                .replace('.', '$');
    }
}