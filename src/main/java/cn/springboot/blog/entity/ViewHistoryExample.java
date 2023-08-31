package cn.springboot.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewHistoryExample {
    protected String orderByClause;

    protected String search;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewHistoryExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
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
            criteria = new ArrayList<>();
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

        public Criteria andHIdIsNull() {
            addCriterion("h_id is null");
            return (Criteria) this;
        }

        public Criteria andHIdIsNotNull() {
            addCriterion("h_id is not null");
            return (Criteria) this;
        }

        public Criteria andHIdEqualTo(Integer value) {
            addCriterion("h_id =", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdNotEqualTo(Integer value) {
            addCriterion("h_id <>", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdGreaterThan(Integer value) {
            addCriterion("h_id >", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("h_id >=", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdLessThan(Integer value) {
            addCriterion("h_id <", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdLessThanOrEqualTo(Integer value) {
            addCriterion("h_id <=", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdIn(List<Integer> values) {
            addCriterion("h_id in", values, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdNotIn(List<Integer> values) {
            addCriterion("h_id not in", values, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdBetween(Integer value1, Integer value2) {
            addCriterion("h_id between", value1, value2, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdNotBetween(Integer value1, Integer value2) {
            addCriterion("h_id not between", value1, value2, "hId");
            return (Criteria) this;
        }

        public Criteria andHUidIsNull() {
            addCriterion("h_uid is null");
            return (Criteria) this;
        }

        public Criteria andHUidIsNotNull() {
            addCriterion("h_uid is not null");
            return (Criteria) this;
        }

        public Criteria andHUidEqualTo(Integer value) {
            addCriterion("h_uid =", value, "hUid");
            return (Criteria) this;
        }

        public Criteria andHUidNotEqualTo(Integer value) {
            addCriterion("h_uid <>", value, "hUid");
            return (Criteria) this;
        }

        public Criteria andHUidGreaterThan(Integer value) {
            addCriterion("h_uid >", value, "hUid");
            return (Criteria) this;
        }

        public Criteria andHUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("h_uid >=", value, "hUid");
            return (Criteria) this;
        }

        public Criteria andHUidLessThan(Integer value) {
            addCriterion("h_uid <", value, "hUid");
            return (Criteria) this;
        }

        public Criteria andHUidLessThanOrEqualTo(Integer value) {
            addCriterion("h_uid <=", value, "hUid");
            return (Criteria) this;
        }

        public Criteria andHUidIn(List<Integer> values) {
            addCriterion("h_uid in", values, "hUid");
            return (Criteria) this;
        }

        public Criteria andHUidNotIn(List<Integer> values) {
            addCriterion("h_uid not in", values, "hUid");
            return (Criteria) this;
        }

        public Criteria andHUidBetween(Integer value1, Integer value2) {
            addCriterion("h_uid between", value1, value2, "hUid");
            return (Criteria) this;
        }

        public Criteria andHUidNotBetween(Integer value1, Integer value2) {
            addCriterion("h_uid not between", value1, value2, "hUid");
            return (Criteria) this;
        }

        public Criteria andHTypeIsNull() {
            addCriterion("h_type is null");
            return (Criteria) this;
        }

        public Criteria andHTypeIsNotNull() {
            addCriterion("h_type is not null");
            return (Criteria) this;
        }

        public Criteria andHTypeEqualTo(Byte value) {
            addCriterion("h_type =", value, "hType");
            return (Criteria) this;
        }

        public Criteria andHTypeNotEqualTo(Byte value) {
            addCriterion("h_type <>", value, "hType");
            return (Criteria) this;
        }

        public Criteria andHTypeGreaterThan(Byte value) {
            addCriterion("h_type >", value, "hType");
            return (Criteria) this;
        }

        public Criteria andHTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("h_type >=", value, "hType");
            return (Criteria) this;
        }

        public Criteria andHTypeLessThan(Byte value) {
            addCriterion("h_type <", value, "hType");
            return (Criteria) this;
        }

        public Criteria andHTypeLessThanOrEqualTo(Byte value) {
            addCriterion("h_type <=", value, "hType");
            return (Criteria) this;
        }

        public Criteria andHTypeIn(List<Byte> values) {
            addCriterion("h_type in", values, "hType");
            return (Criteria) this;
        }

        public Criteria andHTypeNotIn(List<Byte> values) {
            addCriterion("h_type not in", values, "hType");
            return (Criteria) this;
        }

        public Criteria andHTypeBetween(Byte value1, Byte value2) {
            addCriterion("h_type between", value1, value2, "hType");
            return (Criteria) this;
        }

        public Criteria andHTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("h_type not between", value1, value2, "hType");
            return (Criteria) this;
        }

        public Criteria andHTIdIsNull() {
            addCriterion("h_t_id is null");
            return (Criteria) this;
        }

        public Criteria andHTIdIsNotNull() {
            addCriterion("h_t_id is not null");
            return (Criteria) this;
        }

        public Criteria andHTIdEqualTo(Integer value) {
            addCriterion("h_t_id =", value, "hTId");
            return (Criteria) this;
        }

        public Criteria andHTIdNotEqualTo(Integer value) {
            addCriterion("h_t_id <>", value, "hTId");
            return (Criteria) this;
        }

        public Criteria andHTIdGreaterThan(Integer value) {
            addCriterion("h_t_id >", value, "hTId");
            return (Criteria) this;
        }

        public Criteria andHTIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("h_t_id >=", value, "hTId");
            return (Criteria) this;
        }

        public Criteria andHTIdLessThan(Integer value) {
            addCriterion("h_t_id <", value, "hTId");
            return (Criteria) this;
        }

        public Criteria andHTIdLessThanOrEqualTo(Integer value) {
            addCriterion("h_t_id <=", value, "hTId");
            return (Criteria) this;
        }

        public Criteria andHTIdIn(List<Integer> values) {
            addCriterion("h_t_id in", values, "hTId");
            return (Criteria) this;
        }

        public Criteria andHTIdNotIn(List<Integer> values) {
            addCriterion("h_t_id not in", values, "hTId");
            return (Criteria) this;
        }

        public Criteria andHTIdBetween(Integer value1, Integer value2) {
            addCriterion("h_t_id between", value1, value2, "hTId");
            return (Criteria) this;
        }

        public Criteria andHTIdNotBetween(Integer value1, Integer value2) {
            addCriterion("h_t_id not between", value1, value2, "hTId");
            return (Criteria) this;
        }

        public Criteria andHDateIsNull() {
            addCriterion("h_date is null");
            return (Criteria) this;
        }

        public Criteria andHDateIsNotNull() {
            addCriterion("h_date is not null");
            return (Criteria) this;
        }

        public Criteria andHDateEqualTo(Date value) {
            addCriterion("h_date =", value, "hDate");
            return (Criteria) this;
        }

        public Criteria andHDateNotEqualTo(Date value) {
            addCriterion("h_date <>", value, "hDate");
            return (Criteria) this;
        }

        public Criteria andHDateGreaterThan(Date value) {
            addCriterion("h_date >", value, "hDate");
            return (Criteria) this;
        }

        public Criteria andHDateGreaterThanOrEqualTo(Date value) {
            addCriterion("h_date >=", value, "hDate");
            return (Criteria) this;
        }

        public Criteria andHDateLessThan(Date value) {
            addCriterion("h_date <", value, "hDate");
            return (Criteria) this;
        }

        public Criteria andHDateLessThanOrEqualTo(Date value) {
            addCriterion("h_date <=", value, "hDate");
            return (Criteria) this;
        }

        public Criteria andHDateIn(List<Date> values) {
            addCriterion("h_date in", values, "hDate");
            return (Criteria) this;
        }

        public Criteria andHDateNotIn(List<Date> values) {
            addCriterion("h_date not in", values, "hDate");
            return (Criteria) this;
        }

        public Criteria andHDateBetween(Date value1, Date value2) {
            addCriterion("h_date between", value1, value2, "hDate");
            return (Criteria) this;
        }

        public Criteria andHDateNotBetween(Date value1, Date value2) {
            addCriterion("h_date not between", value1, value2, "hDate");
            return (Criteria) this;
        }

        public Criteria andHMachineIsNull() {
            addCriterion("h_machine is null");
            return (Criteria) this;
        }

        public Criteria andHMachineIsNotNull() {
            addCriterion("h_machine is not null");
            return (Criteria) this;
        }

        public Criteria andHMachineEqualTo(Byte value) {
            addCriterion("h_machine =", value, "hMachine");
            return (Criteria) this;
        }

        public Criteria andHMachineNotEqualTo(Byte value) {
            addCriterion("h_machine <>", value, "hMachine");
            return (Criteria) this;
        }

        public Criteria andHMachineGreaterThan(Byte value) {
            addCriterion("h_machine >", value, "hMachine");
            return (Criteria) this;
        }

        public Criteria andHMachineGreaterThanOrEqualTo(Byte value) {
            addCriterion("h_machine >=", value, "hMachine");
            return (Criteria) this;
        }

        public Criteria andHMachineLessThan(Byte value) {
            addCriterion("h_machine <", value, "hMachine");
            return (Criteria) this;
        }

        public Criteria andHMachineLessThanOrEqualTo(Byte value) {
            addCriterion("h_machine <=", value, "hMachine");
            return (Criteria) this;
        }

        public Criteria andHMachineIn(List<Byte> values) {
            addCriterion("h_machine in", values, "hMachine");
            return (Criteria) this;
        }

        public Criteria andHMachineNotIn(List<Byte> values) {
            addCriterion("h_machine not in", values, "hMachine");
            return (Criteria) this;
        }

        public Criteria andHMachineBetween(Byte value1, Byte value2) {
            addCriterion("h_machine between", value1, value2, "hMachine");
            return (Criteria) this;
        }

        public Criteria andHMachineNotBetween(Byte value1, Byte value2) {
            addCriterion("h_machine not between", value1, value2, "hMachine");
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