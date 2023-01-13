package com.santa.fleets.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponsePayload {

	private List<Integer> minimised_hood;

	public ResponsePayload() {
		super();
	}

	public ResponsePayload(final List<Integer> minimised_hood) {
		super();
		this.minimised_hood = minimised_hood;
	}

	public List<Integer> getMinimised_hood() {
		return minimised_hood;
	}

	public void setMinimised_hood(List<Integer> minimised_hood) {
		this.minimised_hood = minimised_hood;
	}

}
