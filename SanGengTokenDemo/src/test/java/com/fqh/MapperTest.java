package com.fqh;

import com.fqh.entity.User;
import com.fqh.mapper.MenuMapper;
import com.fqh.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testMenuMapper() {
        List<String> list = menuMapper.selectPermsByUserId(2L);
        for (String s : list) {
            System.out.println(s);
        }
    }


    @Test
    public void testPasswordEncoder() {
//        String encode1 = passwordEncoder.encode("123456");
//        String encode2 = passwordEncoder.encode("123456");
//        System.out.println(encode1);
//        System.out.println(encode2);

        boolean matches = passwordEncoder.matches("123456",
                "$2a$10$O9QMDJHKhI1vwp6V3QdJ/OCqnC6n6f.9Mfn77xAorM.Uk2hrWQDL.");
        System.out.println(matches);
    }

    @Test
    public void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
