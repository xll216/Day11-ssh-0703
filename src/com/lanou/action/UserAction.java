package com.lanou.action;

import com.lanou.domain.User;
import com.lanou.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport
        implements ModelDriven<User> {
    private User user;//接收表单提交数据

    /**
     * 使用spring的属性注解完成service层的装载
     **/
    @Qualifier("userService")
    @Autowired
    private UserService userService;

    public String login() {
        //调用业务层的登录
        if (userService.login(user.getName(), user.getPassword())) {
            return SUCCESS;
        }

        return ERROR;
    }

    /**
     * 针对登录动作进行验证
     **/
    public void validateLogin() {
        if (StringUtils.isBlank(user.getName()) ||
                StringUtils.isBlank(user.getPassword())) {
            addActionError(
                    "用户名或密码不能为空，请重新输入！");
        }
    }

    @Override
    public User getModel() {
        user = new User();
        return user;//返回要接收数据的对象
    }
}
