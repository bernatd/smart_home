package pl.bernatd.smart_home.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SensorNotFoundException.class)
    public ResponseEntity<Object> handleSensorNotFoundException(SensorNotFoundException exception) {
        return new ResponseEntity<>("Sensor with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException exception) {
        return new ResponseEntity<>("Data with given id does not exist", HttpStatus.BAD_REQUEST);
    }
}
