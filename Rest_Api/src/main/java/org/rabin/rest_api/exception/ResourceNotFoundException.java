package org.rabin.rest_api.exception;


/*
 * @author : rabin
 */

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
