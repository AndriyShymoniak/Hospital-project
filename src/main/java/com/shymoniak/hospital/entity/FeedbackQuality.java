package com.shymoniak.hospital.entity;

import lombok.Getter;

@Getter
public enum FeedbackQuality {
    GREAT("Відмінно"), GOOD("Добре"), SATISFACTORILY("Задовільно"),
        UNSATISFACTORILY("Незадовільно");
    private String translation;

    FeedbackQuality(String translation) {
        this.translation = translation;
    }
}
