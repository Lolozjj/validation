package cn.zjj.enums.params;

import cn.zjj.enums.enums.Fruit;
import cn.zjj.validation.Enums;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EnumsParams {
    @Enums(value = Fruit.class)
    private String fruit;
}
