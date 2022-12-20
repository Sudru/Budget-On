package com.sudru.BudgetOn.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@RequiredArgsConstructor
public class BudgetAmount {
    private double normal;
    private double pending;
}
