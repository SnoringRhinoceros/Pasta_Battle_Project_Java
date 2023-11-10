package com.example.generaltemplate;

import java.io.Serializable;

public record Action(String name, ActionGroupings grouping, StatModifier statModifier, String description,
                     int accuracy) implements Serializable {
}
