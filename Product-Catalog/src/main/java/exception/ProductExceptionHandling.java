package exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandling {
	
	@ExceptionHandler(Exception.class)
	public String Exception() {
		return "Please contact helpdesk";
		
	}
	

}
