package org.vascoom.vascoomspring.responses;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class SingleResponse<T> {

    private final int code;

    private final String message;

    private final T data;
}
