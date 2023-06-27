
package tech.example.controller.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.example.controller.config.dto.AppExceptionDto;
import tech.example.service.exception.GenericException;

import java.text.SimpleDateFormat;
import java.util.Date;

import static tech.example.service.exception.ExceptionErrorCode.SOMETHING_WENT_WRONG;

@RestControllerAdvice
@Order(value = 100)
@Slf4j
public class GenericAppExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<AppExceptionDto> handleGenericException(GenericException e) {
        log.error("Exception: {} at: {}", ExceptionUtils.getStackTrace(e), now());

        return ResponseEntity
                .internalServerError()
                .body(new AppExceptionDto(e.errorCode().getShortName(), ExceptionUtils.getStackTrace(e), e.errorCode().getCategory().getShortName(), now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppExceptionDto> handleOtherException(Exception e) {
        log.error("Exception: {} at: {}", ExceptionUtils.getStackTrace(e), now());

        return ResponseEntity
                .internalServerError()
                .body(new AppExceptionDto(SOMETHING_WENT_WRONG.getShortName(), "Something went wrong", SOMETHING_WENT_WRONG.getCategory().getShortName(), now()));
    }

    private static String now() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}