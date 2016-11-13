package com.ignite.HQLite.utils;

/**
 * Created by Mansour on 03/11/2016.
 */

public class CriteriaBuilder {

    private String whereQuery = "";

    public String query() {
        return whereQuery;
    }

    public CriteriaBuilder isNull (String key) {
        whereQuery += " " + key + " IS NULL";
        return this;
    }

    public CriteriaBuilder isNotNull (String key) {
        whereQuery += " " + key + " IS NOT NULL";
        return this;
    }

    public CriteriaBuilder equals (String key, Object value) {
        whereQuery += " " + key + " = '" + value.toString() + "'";
        return this;
    }

    public CriteriaBuilder notEquals (String key, Object value) {
        whereQuery += " " + key + " != '" + value.toString() + "'";
        return this;
    }

    public CriteriaBuilder greaterThan (String key, Object value) {
        whereQuery += " " + key + " > '" + value.toString() + "'";
        return this;
    }

    public CriteriaBuilder greaterOrEquals (String key, Object value) {
        whereQuery += " " + key + " >= '" + value.toString() + "'";
        return this;
    }

    public CriteriaBuilder lowerThan (String key, Object value) {
        whereQuery += " " + key + " < '" + value.toString() + "'";
        return this;
    }

    public CriteriaBuilder lowerOrEquals (String key, Object value) {
        whereQuery += " " + key + " <= '" + value.toString() + "'";
        return this;
    }

    public CriteriaBuilder between (String key, Object smallValue, Object largeValue) {
        whereQuery += " " + key + " BETWEEN '" + smallValue.toString() + "' AND '" + largeValue.toString() + "'";
        return this;
    }

    public CriteriaBuilder like (String key, Object value) {
        whereQuery += " " + key + " LIKE '" + value.toString() + "'";
        return this;
    }

    public CriteriaBuilder inList (String key, Object[] values) {
        String inClause = "(";
        for(int i = 0; i < values.length; i++){
            inClause += "'" + values[i].toString() + "'";
            if(i != (values.length - 1)){
                inClause += ",";
            }
        }
        inClause += ")";
        whereQuery += " " + key + " IN " + inClause;
        return this;
    }

    public CriteriaBuilder and () {
        whereQuery += " AND";
        return this;
    }

    public CriteriaBuilder and (CriteriaBuilder expression) {
        whereQuery = "(" + whereQuery + ") AND (" + expression.query() + ")";
        return this;
    }

    public CriteriaBuilder or () {
        whereQuery += " OR";
        return this;
    }

    public CriteriaBuilder or (CriteriaBuilder expression) {
        whereQuery = "(" + whereQuery + ") OR (" + expression.query() + ")";
        return this;
    }

}
