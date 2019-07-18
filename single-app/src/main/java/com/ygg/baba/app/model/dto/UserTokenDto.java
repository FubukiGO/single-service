package com.ygg.baba.app.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserTokenDto implements Serializable {

    private Integer id;

    private String token;

}
