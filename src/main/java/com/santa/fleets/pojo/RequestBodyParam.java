package com.santa.fleets.pojo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class RequestBodyParam {

	@NotNull
	private Integer hood_capacity;

	@NotNull
	private List<Integer> present_weights;

	public RequestBodyParam() {
		super();
	}

	public RequestBodyParam(final Integer hood_capacity, final List<Integer> present_weights) {
		super();
		this.hood_capacity = hood_capacity;
		this.present_weights = present_weights;
	}

	@NotNull
	public Integer getHood_capacity() {
		return hood_capacity;
	}

	@NotNull
	public List<Integer> getPresent_weights() {
		return present_weights;
	}

}
