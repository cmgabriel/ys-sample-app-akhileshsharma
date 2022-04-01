package com.example.yssampleapp.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Payload implements Serializable {

    private static final long serialVersionUID = 7002954278817743147L;

    @JsonProperty("documents")
    List<Document> documents;

}
