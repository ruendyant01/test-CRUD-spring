package org.vascoom.vascoomspring.responses;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class ListResponse<T> {

    private final int code;

    private final String message;

    private final List<T> data;
}
