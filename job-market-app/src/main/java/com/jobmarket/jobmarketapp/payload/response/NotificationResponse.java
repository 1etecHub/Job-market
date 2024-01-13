package com.jobmarket.jobmarketapp.payload.response;


import com.jobmarket.jobmarketapp.payload.response.jobpostresponse.JobPostResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private Long id;
    private String message;
    private boolean read;
    private Long jobPostId;
    private String logo;
    private String companyName;
    private String createTime;
    private JobPostResponse jobPostResponse;
}
