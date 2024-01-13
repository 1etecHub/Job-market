package com.jobmarket.jobmarketapp.payload.response;


import com.jobmarket.jobmarketapp.payload.response.jobpostresponse.JobPostResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponsePage {
    private List<JobPostResponse> content;
    private int pageNo;
    private int pageSize;
    private long totalElement;
    private int totalPages;
    private boolean last;
}
