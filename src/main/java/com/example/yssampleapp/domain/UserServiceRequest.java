package com.example.yssampleapp.domain;

import com.example.yssampleapp.domain.model.Payload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceRequest implements Serializable {

    private static final long serialVersionUID = -849847585997711087L;

    private String userId;

    private Payload payload;
}
