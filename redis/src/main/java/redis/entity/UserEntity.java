package redis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Li Hui
 * @Date 2019/1/29 13:59
 **/

@Data
public class UserEntity implements Serializable {

    private Long id;

    private String name;

    private String password;
}
