package com.davidoladeji.park.service.util;


/**
 * Created by Daveola on 25-Nov-14.
 * Exception handles Runtime Exceptions related actions
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

}
