package com.lawencon.linovhrcommunity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.lawencon.base.BaseEntity;

@Entity
@Table(name = "t_event_course_type", uniqueConstraints = {@UniqueConstraint(name = "event_course_type_bk", columnNames = "code"), 
		@UniqueConstraint(name="event_course_type_ck", columnNames = { "id", "code" })})
public class EventCourseType extends BaseEntity {

	private static final long serialVersionUID = -5196455701225322056L;

	@Column(name = "code", length = 10, nullable = false)
	private String code;

	@Column(name = "event_course_type_name", length = 30, nullable = false)
	private String eventTypeName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEventTypeName() {
		return eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

}
