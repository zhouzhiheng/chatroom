package com.opsigte.chatroom.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CUserRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CUserRelationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSourceUidIsNull() {
            addCriterion("source_uid is null");
            return (Criteria) this;
        }

        public Criteria andSourceUidIsNotNull() {
            addCriterion("source_uid is not null");
            return (Criteria) this;
        }

        public Criteria andSourceUidEqualTo(String value) {
            addCriterion("source_uid =", value, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidNotEqualTo(String value) {
            addCriterion("source_uid <>", value, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidGreaterThan(String value) {
            addCriterion("source_uid >", value, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidGreaterThanOrEqualTo(String value) {
            addCriterion("source_uid >=", value, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidLessThan(String value) {
            addCriterion("source_uid <", value, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidLessThanOrEqualTo(String value) {
            addCriterion("source_uid <=", value, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidLike(String value) {
            addCriterion("source_uid like", value, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidNotLike(String value) {
            addCriterion("source_uid not like", value, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidIn(List<String> values) {
            addCriterion("source_uid in", values, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidNotIn(List<String> values) {
            addCriterion("source_uid not in", values, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidBetween(String value1, String value2) {
            addCriterion("source_uid between", value1, value2, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andSourceUidNotBetween(String value1, String value2) {
            addCriterion("source_uid not between", value1, value2, "sourceUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidIsNull() {
            addCriterion("target_uid is null");
            return (Criteria) this;
        }

        public Criteria andTargetUidIsNotNull() {
            addCriterion("target_uid is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUidEqualTo(String value) {
            addCriterion("target_uid =", value, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidNotEqualTo(String value) {
            addCriterion("target_uid <>", value, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidGreaterThan(String value) {
            addCriterion("target_uid >", value, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidGreaterThanOrEqualTo(String value) {
            addCriterion("target_uid >=", value, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidLessThan(String value) {
            addCriterion("target_uid <", value, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidLessThanOrEqualTo(String value) {
            addCriterion("target_uid <=", value, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidLike(String value) {
            addCriterion("target_uid like", value, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidNotLike(String value) {
            addCriterion("target_uid not like", value, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidIn(List<String> values) {
            addCriterion("target_uid in", values, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidNotIn(List<String> values) {
            addCriterion("target_uid not in", values, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidBetween(String value1, String value2) {
            addCriterion("target_uid between", value1, value2, "targetUid");
            return (Criteria) this;
        }

        public Criteria andTargetUidNotBetween(String value1, String value2) {
            addCriterion("target_uid not between", value1, value2, "targetUid");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}