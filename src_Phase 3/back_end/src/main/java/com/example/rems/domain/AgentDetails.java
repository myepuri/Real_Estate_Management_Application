package com.example.rems.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentDetails {
    private String agid;
    private String name;
    private String job_title;
    private String phone;
    private String agency_name;
}
