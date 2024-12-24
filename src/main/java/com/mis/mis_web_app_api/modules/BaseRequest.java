package com.mis.mis_web_app_api.modules;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest {
    private int page;
    private int size;
}
