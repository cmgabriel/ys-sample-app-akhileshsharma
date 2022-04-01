package com.example.yssampleapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserServiceResponse implements Serializable {

    private static final long serialVersionUID = -6967614266864680031L;

    private boolean success;

    private boolean isAccredited;
}
