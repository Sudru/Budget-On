package com.sudru.BudgetOn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class BudgetAmount {
    private double normal;
    private double pending;
}
