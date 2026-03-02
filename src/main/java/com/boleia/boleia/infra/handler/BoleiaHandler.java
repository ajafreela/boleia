package com.boleia.boleia.infra.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.boleia.boleia.infra.shared.Exception.BadRequestException;
import com.boleia.boleia.infra.shared.Exception.ConflictExecption;
import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.shared.Exception.MissingFieldException;
import com.boleia.boleia.infra.shared.error.DomainError;
import com.boleia.boleia.infra.utils.ErrorResponseOutput;

@Component
public class BoleiaHandler {

    private static Map<Class<? extends DomainError>, HttpStatus> ERROR_STATUS_MAP = Map.ofEntries(
        Map.entry(CustomNotFoundException.class, HttpStatus.NOT_FOUND),
        Map.entry(ConflictExecption.class, HttpStatus.CONFLICT),
        Map.entry(BadRequestException.class, HttpStatus.BAD_REQUEST),
        Map.entry(MissingFieldException.class, HttpStatus.BAD_REQUEST)
    );

    public ResponseEntity<ErrorResponseOutput> handleDomain(DomainError err) {
        HttpStatus httpStatus = ERROR_STATUS_MAP.getOrDefault(err.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(httpStatus).body(new ErrorResponseOutput(err.getMsg(), httpStatus.value()));
    }
}
