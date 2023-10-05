package fr.gestionformation.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus
@Getter
public class ResourceNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = -5065109181605649015L;

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}