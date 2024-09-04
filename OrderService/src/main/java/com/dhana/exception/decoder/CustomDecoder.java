package com.dhana.exception.decoder;

import java.io.IOException;

import com.dhana.exception.ErrorResponse;
import com.dhana.exception.OrderServiceCustomException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			ErrorResponse errorResponse = mapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			return new OrderServiceCustomException(errorResponse.getMessage(), errorResponse.getErrorCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OrderServiceCustomException("Internal server exception", "SERVICE_EXCEPTION");
	}

}
