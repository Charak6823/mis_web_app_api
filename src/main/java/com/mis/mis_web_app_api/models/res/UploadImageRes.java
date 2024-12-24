package com.mis.mis_web_app_api.models.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
public class UploadImageRes {

    @Getter
    @Setter
    @JsonProperty("data")
    private String fileName;
}