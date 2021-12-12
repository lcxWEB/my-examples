
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coder.entity.Course;
import com.coder.entity.User;
import com.coder.mapper.CourseMapper;
import com.coder.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShardingJdbcApplicationTest {


    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;


    @Test
    void addUser() {
        User user = new User();
        user.setUsername("lucky");
        user.setUstatus("enable");
        userMapper.insert(user);
    }

    @Test
    void findUser() {
        // LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getUserId, 570597786043547648L);
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().ge(User::getUserId, 570597786043547648L);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCname("python" + i);
            course.setUserId((long) (i + 1));
            course.setCstatus("Normal");
            courseMapper.insert(course);
        }
    }

    @Test
    void findCourse() {
        // LambdaQueryWrapper<Course> queryWrapper = Wrappers.<Course>lambdaQuery().eq(Course::getCid, 570358098166808577L);
        LambdaQueryWrapper<Course> queryWrapper = Wrappers.<Course>lambdaQuery().ge(Course::getCid, 594518267368833025L)
                .le(Course::getCid, 594518267658240001L);
        Course course = courseMapper.selectOne(queryWrapper);
        System.out.println(course);

        LambdaQueryWrapper<Course> queryWrapper1 = Wrappers.<Course>lambdaQuery().like(Course::getCname, "java");
        List<Course> courses = courseMapper.selectList(queryWrapper1);
        System.out.println(courses);
    }

}
