package cn.lpc.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lpc.domain.User;
import cn.lpc.service.UserService;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	//模型驱动
	private User user = new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String login() throws Exception {
		List<User> result = userService.findOne(user);
		if (result != null && result.size() > 0) {
			ServletActionContext.getRequest().setAttribute("user", result.get(0));
			return "success";
		}else {
			ServletActionContext.getRequest().setAttribute("error", "账号密码错误或不存在");
			return "logindefeat";
		}
	}
	
	public String findAll() throws Exception {
		List<User> list = userService.finAll();
		String json = JSON.toJSONString(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return NONE;
	}
}
