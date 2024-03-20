package com.example.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.entity.Transcation;
import com.example.User.model.TranscationRequest;
import com.example.User.service.TranscationService;

@RestController
@RequestMapping("/transcation")
public class TranscationController {
	@Autowired
	private TranscationService transcationService;
	
	@PostMapping("/transferMoney")
	public ResponseEntity<TranscationRequest> transferMoney(@RequestBody TranscationRequest request){
		TranscationRequest transcation = transcationService
				.transferMoney(request.getAmount(),request.getSenderAccountNumber(),request.getReceiverAccountNumber());
		if(transcation != null) {
			return ResponseEntity.ok(transcation);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
