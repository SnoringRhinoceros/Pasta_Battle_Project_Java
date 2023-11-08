package com.example.generaltemplate;

public record Action(String name, ActionGroupings grouping, StatModifier statModifier, String description,
                     int accuracy) {
}
