package com.aocurvelo.crud.services.exceptions;

import com.aocurvelo.crud.utilities.MessageUtil;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NotFoundException() {
		super(MessageUtil.NO_RECORDS_FOUND);
	}

}
