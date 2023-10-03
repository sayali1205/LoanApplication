package com.loan.achintya.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponse {

	private int responseStatus;
	private String responseMessage;
	//private Date responseDate;
	
	
	
}
