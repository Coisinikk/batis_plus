package com.zjy.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.plus.entity.User;
import com.zjy.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PlusApplicationTests {
    @Autowired
    private UserMapper userMapper;




    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("自控力");
        user.setAge(20);
        user.setEmail("9809@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);

    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1537261425854521346L);
        user.setName("Jackson");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }
    @Test
    public void testOptimisticLock(){
        User user = userMapper.selectById(1537268193431187457L);
        user.setName("神州");
        userMapper.updateById(user);
    }

    //多个id批量查询
    @Test
    public void testSelect1() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }
    //简单条件查询
    @Test
    public void testSelect2() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name","Jack");
        columnMap.put("age",20);
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);
    }
    //分页查询
    @Test
    public void testSelectPage() {
        Page<User> page = new Page(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        //返回对象得到分页所有数据
        long pages = userPage.getPages(); //总页数
        long current = userPage.getCurrent(); //当前页
        List<User> records = userPage.getRecords(); //查询数据集合
        long total = userPage.getTotal(); //总记录数
        boolean hasNext = userPage.hasNext();  //下一页
        boolean hasPrevious = userPage.hasPrevious(); //上一页

        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }
    @Test
    public void testSelectMapsPage() {
//Page不需要泛型
        Page<Map<String, Object>> page = new Page<>(1, 5);
        Page<Map<String, Object>> pageParam = userMapper.selectMapsPage(page, null);
        List<Map<String, Object>> records = pageParam.getRecords();
        records.forEach(System.out::println);
        System.out.println(pageParam.getCurrent());
        System.out.println(pageParam.getPages());
        System.out.println(pageParam.getSize());
        System.out.println(pageParam.getTotal());
        System.out.println(pageParam.hasNext());
        System.out.println(pageParam.hasPrevious());
    }
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(1537273460206080001L);
        System.out.println(result);
    }
    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(1537272009694175233L, 1537268193431187457L));
        System.out.println(result);
    }
    @Test
    public void testDeleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen");
        map.put("age", 18);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }


    //mybatis-plus复杂操作
    @Test
    public void testQuery() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.ge("age", 20);
        //queryWrapper.eq("name","Tom");
        //queryWrapper.between("age",20,24);
        //queryWrapper.like("name","K");
        queryWrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


}