package com.santa.fleets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santa.fleets.pojo.RequestBodyParam;
import com.santa.fleets.pojo.ResponsePayload;
import com.santa.fleets.service.HoodFillerService;
import com.santa.fleets.util.EndPointConstants;

@RestController
@Validated
@RequestMapping(EndPointConstants.BASE_URL)
public class HoodFillerController {

	@Autowired
	HoodFillerService hoodFillerService;

	@RequestMapping(method = RequestMethod.POST, path = EndPointConstants.HOOD_FILLER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponsePayload> hoodFiller(@RequestBody final RequestBodyParam requestParam) {
		return hoodFillerService.hoodFiller(requestParam);

	}

}
