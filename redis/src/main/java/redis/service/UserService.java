package redis.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import redis.entity.UserEntity;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @Author Li Hui
 * @Date 2019/1/29 14:09
 **/

@Service
public class UserService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    public void addUser(long id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName("test");
        userEntity.setPassword("test");

        String key1 = String.format("test:string:%d", id);
        //stringRedisTemplate.opsForValue().set(key1, JSON.toJSONString(userEntity));
        System.out.println(stringRedisTemplate.opsForValue().get(key1));

        redisCacheTemplate.opsForValue().set(key1,userEntity,2, TimeUnit.MINUTES);
    }
}
