package com.bjpowernode.p2p.server.impl.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.p2p.mapper.user.FinanceAccountMapper;
import com.bjpowernode.p2p.mapper.user.UserMapper;
import com.bjpowernode.p2p.model.FinanceAccount;
import com.bjpowernode.p2p.model.User;
import com.bjpowernode.p2p.server.loan.BidInfoService;
import com.bjpowernode.p2p.server.user.UserService;
import com.bjpowernode.springboot.cons.Constans;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = UserService.class,version = "1.0.0",timeout=15000)
public class UserServiceImpl implements UserService {
    @Resource
     UserMapper userMapper;
    @Resource
     RedisTemplate redisTemplate;
    @Resource
     FinanceAccountMapper financeAccountMapper;
    @Override
    public Integer querryCountUser() {
        Integer countUser = (Integer) redisTemplate.opsForValue().get(Constans.COUNT_USER);
         if(!ObjectUtils.allNotNull(countUser)){
             synchronized (this){
                 countUser = (Integer) redisTemplate.opsForValue().get(Constans.COUNT_USER);
                 if(!ObjectUtils.allNotNull(countUser)){
                     countUser = userMapper.selectCountUser();
                     redisTemplate.opsForValue().set(Constans.COUNT_USER,countUser,7, TimeUnit.DAYS);
                 }
             }
         }
        return countUser;
    }

    @Override
    public User querryPhone(String phone) {
        User phone1=userMapper.selectPhone(phone);
        return phone1;
    }

    @Override
    public User register(String phone, String password) throws Exception {
        User user = new User();
        user.setAddTime(new Date());
        //?????????????????????????????????????????????
//        user.setName();
//        user.setHeaderImage();
        user.setLastLoginTime(new Date());
        user.setPhone(phone);
        user.setLoginPassword(password);
        int i = userMapper.insertSelective(user);
        if(i==0){
            throw new Exception("??????????????????");

        }
        //????????????????????????????????????id??????uid
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.setUid(user.getId());
        financeAccount.setAvailableMoney(88888.0);
        int i1 = financeAccountMapper.insertSelective(financeAccount);
        if(i1==0){
            throw new Exception("??????????????????");
        }
        return user;
    }

    @Override
    public int updateUser(User user) {

        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User QuerryUser(String phone ,String passWord) {

        return  userMapper.selectUser(phone,passWord);
    }


}
