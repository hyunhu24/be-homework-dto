package com.springboot.coffee;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CoffeePatchDto {
    private long coffeeId;

    @NotBlank
    //한글만 공백 앞뒤 가운데 공백 없도록
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)(?!.*\\s{1})[ㄱ-ㅎ가-힣\\s]+$")
    private String korName;

    //영어 대소문자만 허용 공백 앞뒤 안되고 가운데 한개이상 안되도록
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)(?!.*\\s{2})[A-Za-z\\s]+$")
    private String engName;

    @Min(value = 100, message = "금액은 100 이상이어야 합니다.")
    @Max(value = 50000, message = "금액은 50000 이하여야 합니다.")
    private int price;
}
