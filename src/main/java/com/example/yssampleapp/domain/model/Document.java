package com.example.yssampleapp.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document implements Serializable {

    private static final long serialVersionUID = -6729198015372544271L;

    @JsonProperty("name")
    String name;

    @JsonProperty("mime_type")
    String mimeType;

    @JsonProperty("content")
    String content;

}
