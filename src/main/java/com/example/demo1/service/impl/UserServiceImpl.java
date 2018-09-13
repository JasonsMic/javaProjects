package com.example.demo1.service.impl;

import com.example.demo1.dao.UserDao;
import com.example.demo1.model.User;
import com.example.demo1.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    /*private static final Logger logger = Logger.getLogger(UserServiceImpl.class);*/

   // private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserDao userDao;

    @Override
    @Transactional
    public int addUser(User user) {
        int flag = 0;
        try{
            flag = userDao.insert(user);
        }catch (Exception e){
            /*logger.info(e.getMessage(),e);*/
        }
        return flag;
    }

    /*
     * 这个方法中用到配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userDao.selectUsers();
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
