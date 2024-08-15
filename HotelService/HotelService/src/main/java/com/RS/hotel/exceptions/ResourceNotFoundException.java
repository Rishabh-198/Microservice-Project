package com.RS.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String hotelGivenIdNotFound) {
        super(hotelGivenIdNotFound);
    }
    public ResourceNotFoundException()
    {
        super("Resource not found");
    }

}
