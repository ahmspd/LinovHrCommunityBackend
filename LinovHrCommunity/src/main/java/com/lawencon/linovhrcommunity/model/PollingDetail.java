package com.lawencon.linovhrcommunity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lawencon.base.BaseEntity;

@Entity
@Table(name = "t_polling_detail")
public class PollingDetail extends BaseEntity {
	private static final long serialVersionUID = -9034083546988015483L;

	@ManyToOne
	@JoinColumn(name = "id_polling", nullable = false)
	private Polling idPolling;

	@Column(name = "polling_name")
	private String pollingName;

	public Polling getIdPolling() {
		return idPolling;
	}

	public void setIdPolling(Polling idPolling) {
		this.idPolling = idPolling;
	}

	public String getPollingName() {
		return pollingName;
	}

	public void setPollingName(String pollingName) {
		this.pollingName = pollingName;
	}

}
