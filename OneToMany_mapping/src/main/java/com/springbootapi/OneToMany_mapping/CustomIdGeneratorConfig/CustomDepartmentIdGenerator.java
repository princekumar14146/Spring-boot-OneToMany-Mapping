package com.springbootapi.OneToMany_mapping.CustomIdGeneratorConfig;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomDepartmentIdGenerator implements IdentifierGenerator {

    private static Integer count=1;
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        return "Dept_" + count++;
    }
}
