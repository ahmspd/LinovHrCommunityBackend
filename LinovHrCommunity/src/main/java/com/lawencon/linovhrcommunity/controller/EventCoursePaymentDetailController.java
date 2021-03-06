package com.lawencon.linovhrcommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.linovhrcommunity.dto.eventcoursepaymentdetail.GetAllEventCoursePaymentDetailDtoRes;
import com.lawencon.linovhrcommunity.service.EventCoursePaymentDetailService;

@RestController
@RequestMapping("event-course-payment-detail")
public class EventCoursePaymentDetailController {
	private EventCoursePaymentDetailService eventCoursePaymentDetailService;

	@Autowired
	public void setEventCoursePaymentDetailService(EventCoursePaymentDetailService eventCoursePaymentDetailService) {
		this.eventCoursePaymentDetailService = eventCoursePaymentDetailService;
	}
	
	@GetMapping
	public ResponseEntity<GetAllEventCoursePaymentDetailDtoRes> getUnpaidEventCourse() throws Exception {
		GetAllEventCoursePaymentDetailDtoRes dataRes = eventCoursePaymentDetailService.getUnpaidEventCourse();
		return new ResponseEntity<GetAllEventCoursePaymentDetailDtoRes>(dataRes, HttpStatus.OK);
	}
	
}
