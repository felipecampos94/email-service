package com.api.msemail.response;

import com.api.msemail.enumeration.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailResponse {
    private String sendTo;
    private LocalDateTime sendDateEmail;
    private String statusEmail;
}