package com.example.yssampleapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class UserClientResponse implements Serializable {

    private static final long serialVersionUID = -2572186387689925022L;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("accredited")
    private boolean accredited;
}
