package com.lawencon.linovhrcommunity.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lawencon.base.BaseEntity;

@Entity
@Table(name = "t_category_detail")
public class CategoryDetail extends BaseEntity {

	private static final long serialVersionUID = -5196455701225322056L;

	@ManyToOne
	@JoinColumn(name = "id_category", referencedColumnName = "id", nullable = false)
	private Category category;

	@OneToOne
	@JoinColumn(name = "id_thread", referencedColumnName = "id")
	private ThreadModel threadModel;

	@OneToOne
	@JoinColumn(name = "id_event_course", referencedColumnName = "id")
	private EventCourse eventCourse;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ThreadModel getThreadModel() {
		return threadModel;
	}

	public void setThreadModel(ThreadModel threadModel) {
		this.threadModel = threadModel;
	}

	public EventCourse getEventCourse() {
		return eventCourse;
	}

	public void setEventCourse(EventCourse eventCourse) {
		this.eventCourse = eventCourse;
	}

}
