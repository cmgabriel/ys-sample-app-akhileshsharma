package com.example.yssampleapp.domain;

import com.example.yssampleapp.domain.model.Payload;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class UserClientRequest implements Serializable {

    private static final long serialVersionUID = -597375295732073159L;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("payload")
    private Payload payload;
}
