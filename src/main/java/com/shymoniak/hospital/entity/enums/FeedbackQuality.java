package com.shymoniak.hospital.entity.enums;

import lombok.Getter;

@Getter
public enum FeedbackQuality {
    GREAT("Відмінно"), GOOD("Добре"), SATISFACTORILY("Задовільно"),
        UNSATISFACTORILY("Незадовільно");
    private final String translation;

    FeedbackQuality(String translation) {
        this.translation = translation;
    }
}
