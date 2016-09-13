package com.sakila.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hand.Util.SpringBeanFactory;
import com.sakila.Entity.Customer;
import com.sakila.MybatisImpl.CustomerDaoSp;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(value = "/do_login", method = RequestMethod.POST)
	public String do_login(@RequestParam(value = "name") String name,
			HttpSession session)
			throws BeansException, SQLException, UnsupportedEncodingException {
		Customer[] c = SpringBeanFactory.getBeanFactory().getBean("CustomerDao", CustomerDaoSp.class)
				.getByFirstName_Customer(name);
		if (c.length <= 0) {
			return "redirect:/component/message.jsp?message=" + URLEncoder.encode("��¼ʧ��", "UTF-8")
					+ "&redir=/Exam7/821/login.html";
		}
		session.setAttribute("username", name);
		session.setAttribute("UID", c[0].getID());
		return "redirect:/821/index.jsp";
	}

	@RequestMapping(value = "/do_logout", method = RequestMethod.GET)
	public String do_logout(HttpSession session) throws UnsupportedEncodingException {
		session.invalidate();
		return "redirect:/component/message.jsp?message=" + URLEncoder.encode("ע���ɹ�", "UTF-8")
				+ "&redir=/Exam7/821/login.html";
	}
}
