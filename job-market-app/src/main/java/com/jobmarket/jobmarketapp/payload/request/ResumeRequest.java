package com.jobmarket.jobmarketapp.payload.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeRequest {
    private MultipartFile resume;
}
