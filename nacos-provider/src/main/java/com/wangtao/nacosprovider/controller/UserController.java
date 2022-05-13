package com.wangtao.nacosprovider.controller;

import com.wangtao.nacosprovider.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wangtao
 * Created at 2022/5/13 19:47
 */
@RequestMapping("/api/users")
@RestController
public class UserController {

    private static final Map<Integer, UserVO> MOCK_USERS_MAP;

    static {
        Random random = new Random();
        MOCK_USERS_MAP = IntStream.range(1, 11)
                .mapToObj(i -> new UserVO(i, "user-" + i, random.nextInt(101)))
                .collect(Collectors.toMap(UserVO::getId, u -> u));
    }

    @GetMapping("/{id}")
    public UserVO detailUser(@PathVariable Integer id) {
        return MOCK_USERS_MAP.get(id);
    }
}
