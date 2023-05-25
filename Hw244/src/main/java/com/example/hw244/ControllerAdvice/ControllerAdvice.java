package com.example.hw244.ControllerAdvice;

import com.example.hw244.ApiException.ApiException;
import com.example.hw244.ApiResponse.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.zip.DataFormatException;

@org.springframework.web.bind.annotation.ControllerAdvice


public class ControllerAdvice {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> APIException(ApiException apiException) {
        String message = apiException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        String message = methodArgumentNotValidException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
        String message = methodArgumentTypeMismatchException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));

    }

    @ExceptionHandler(value = DataFormatException.class)
    public ResponseEntity<ApiResponse> DataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
        String message = dataIntegrityViolationException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<ApiResponse> TransactionSystemException(TransactionSystemException transactionSystemException) {
        String message = transactionSystemException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }
}



