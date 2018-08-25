package ru.ioleksiv.telegram.bot.api.model.annotation;

public enum AnnotationState {
    ON,
    OFF;

    public boolean isActive() {
        return this == ON;
    }
}