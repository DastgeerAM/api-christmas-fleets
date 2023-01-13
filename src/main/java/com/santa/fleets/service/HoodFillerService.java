package com.santa.fleets.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santa.fleets.pojo.RequestBodyParam;
import com.santa.fleets.pojo.ResponsePayload;

@Service
public interface HoodFillerService {
	
	public ResponseEntity<ResponsePayload> hoodFiller(final RequestBodyParam requestParam);

}
