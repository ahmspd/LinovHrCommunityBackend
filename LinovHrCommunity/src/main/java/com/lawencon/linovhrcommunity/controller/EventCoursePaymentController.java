package com.lawencon.linovhrcommunity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lawencon.linovhrcommunity.dto.eventcoursepayment.GetAllEventCoursePaymentDtoRes;
import com.lawencon.linovhrcommunity.dto.eventcoursepayment.InsertEventCoursePaymentDtoRes;
import com.lawencon.linovhrcommunity.dto.eventcoursepayment.UpdateEventCoursePaymentDtoReq;
import com.lawencon.linovhrcommunity.dto.eventcoursepayment.UpdateEventCoursePaymentDtoRes;
import com.lawencon.linovhrcommunity.service.EventCoursePaymentService;

@RestController
@RequestMapping("event-course-payment")
public class EventCoursePaymentController {
	private EventCoursePaymentService eventCoursePaymentService;

	@Autowired
	public void setEventCoursePaymentService(EventCoursePaymentService eventCoursePaymentService) {
		this.eventCoursePaymentService = eventCoursePaymentService;
	}

	@PostMapping(consumes = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE
	})
	public ResponseEntity<InsertEventCoursePaymentDtoRes> pay(@RequestPart(name="content") String content, 
			@RequestPart(required = false) MultipartFile file) throws Exception {
		InsertEventCoursePaymentDtoRes response = eventCoursePaymentService.pay(content, file);
		return new ResponseEntity<InsertEventCoursePaymentDtoRes>(response, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<UpdateEventCoursePaymentDtoRes> confirmPayment(@RequestBody @Valid UpdateEventCoursePaymentDtoReq dataReq) throws Exception {
		UpdateEventCoursePaymentDtoRes dataRes = eventCoursePaymentService.confirmPayment(dataReq);
		return new ResponseEntity<UpdateEventCoursePaymentDtoRes>(dataRes, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<GetAllEventCoursePaymentDtoRes> getAllUnAccepted(@RequestParam Boolean isAccept,@RequestParam int start, @RequestParam int max) throws Exception {
		GetAllEventCoursePaymentDtoRes res = eventCoursePaymentService.getAllUnAccepted(isAccept, start, max);
		return new ResponseEntity<GetAllEventCoursePaymentDtoRes>(res, HttpStatus.OK);
	}
}







