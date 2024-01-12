package com.moaaz.wuzzufmostaql.Dto;

import com.moaaz.wuzzufmostaql.Dto.Developer.DeveloperResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ApplicationResponse {
    private LocalDateTime time;
    private DeveloperResponse developer;
}
