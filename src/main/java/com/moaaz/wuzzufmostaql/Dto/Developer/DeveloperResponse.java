package com.moaaz.wuzzufmostaql.Dto.Developer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeveloperResponse {

    private String name;
    private String email;
    private String cvPath;

}
