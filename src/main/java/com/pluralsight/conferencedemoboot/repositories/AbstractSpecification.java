package com.pluralsight.conferencedemoboot.repositories;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;

abstract public class AbstractSpecification<T> implements Specification<T> {
    @Override
    public boolean isSatisfiedBy(T t) {
        throw new NotImplementedException();
    }

    @Override
    public Predicate toPredicate(Root<T> poll, CriteriaBuilder cb) {
        throw new NotImplementedException();
    }

    @Override
    public Class<T> getType() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) type.getActualTypeArguments()[0];
    }
}