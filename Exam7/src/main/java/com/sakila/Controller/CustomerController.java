package com.sakila.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hand.Util.JsonUtil;
import com.hand.Util.SpringBeanFactory;
import com.sakila.Entity.Address;
import com.sakila.Entity.Customer;
import com.sakila.MybatisImpl.AddressDaoSp;
import com.sakila.MybatisImpl.CustomerDaoSp;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	@RequestMapping(value="/index.do",method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mav=new ModelAndView("customer_index");
		List<Address> al=SpringBeanFactory.getBeanFactory().getBean("AddressDao",AddressDaoSp.class).getAllAddress();
		mav.addObject("address_list",al);
		return mav;
	}
	
	@RequestMapping(value="/ajaxGetCustomerInPage",method=RequestMethod.POST)
	public void ajaxGetCustomerInPage(@RequestParam(value="pageNum",required=true)Integer pageNum,
									HttpServletResponse response) throws SQLException, IOException{
		List<Customer> cl=SpringBeanFactory.getBeanFactory().getBean("CustomerDao",CustomerDaoSp.class).getCustomerInPage(pageNum, 10);
		List<Address> al=SpringBeanFactory.getBeanFactory().getBean("AddressDao",AddressDaoSp.class).getAllAddress();
		Map<Integer,String> am=new HashMap<Integer,String>();
		for(Address a : al){
			am.put((int) a.getID(), a.getAddress());
		}
		List<CustomerTransHelper> cthl=new ArrayList<CustomerTransHelper>();
		CustomerTransHelper temp=null;
		for(Customer c:cl){
			temp=new CustomerTransHelper();
			temp.setID((int) c.getID());
			temp.setFirst_name(c.getFirst_name());
			temp.setLast_name(c.getLast_name());
			temp.setEmail(c.getEmail());
			temp.setAddress(am.get(c.getAddress_id()));
			temp.setLast_update(c.getLast_update().toString());//new java.util.Date (c.getLast_update().getTime()).toGMTString()
			cthl.add(temp);
		}
		String res=JsonUtil.toJson(cthl);
		response.getWriter().write(res);
	}
	
	@RequestMapping(value="/ajaxGetCustomerCount",method=RequestMethod.POST)
	public void ajaxGetCustomerCount(HttpServletResponse response) throws SQLException, IOException{
		Integer count=SpringBeanFactory.getBeanFactory().getBean("CustomerDao",CustomerDaoSp.class).getCustomerCount();
		response.getWriter().write(count.toString());
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.GET)
	public ModelAndView addCustomer(){
		ModelAndView mav=new ModelAndView("add_customer");
		List<Address> al=SpringBeanFactory.getBeanFactory().getBean("AddressDao",AddressDaoSp.class).getAllAddress();
		mav.addObject("address_list", al);
		return mav;
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public String addCustomer(Customer c) throws UnsupportedEncodingException{
		try{
			c.setStore_id(1);
			SpringBeanFactory.getBeanFactory().getBean("CustomerDao",CustomerDaoSp.class).AddIdEntity(c);
		}catch(Exception ex){
			return "redirect:/component/message.jsp?message=" + URLEncoder.encode("添加失败："+ex.getMessage(), "UTF-8")
			+ "&redir=/SpringMVCExam/customer/index.do";
		}
		return "redirect:/component/message.jsp?message=" + URLEncoder.encode("添加成功：", "UTF-8")
		+ "&redir=/SpringMVCExam/customer/index.do";
	}
	
	@RequestMapping(value="/ajaxDeleteCustomer",method=RequestMethod.POST)
	public void ajaxDeleteCustomer(@RequestParam(value="cid",required=true)Integer cid,HttpServletResponse response) throws SQLException, IOException{
		try{
			SpringBeanFactory.getBeanFactory().getBean("CustomerDao",CustomerDaoSp.class).delByID(cid);
		}catch(Exception ex){
			response.getWriter().write("FALSE");
		}
		response.getWriter().write("OK");
	}
	
	@RequestMapping(value="/ajaxGetCustomer",method=RequestMethod.POST)
	public void ajaxGetCustomer(@RequestParam(value="cid",required=true)Integer cid,HttpServletResponse response) throws SQLException, IOException{
		Customer c=(Customer) SpringBeanFactory.getBeanFactory().getBean("CustomerDao",CustomerDaoSp.class).getByID(cid);
		String res=JsonUtil.toJson(c);
		response.getWriter().write(res);
	}
	
	@RequestMapping(value="/ajaxEditCustomer",method=RequestMethod.POST)
	public void ajaxEditCustomer(Customer c,HttpServletResponse response) throws SQLException, IOException{
		try{
			long cid=c.getID();
			CustomerDaoSp cdao=SpringBeanFactory.getBeanFactory().getBean("CustomerDao",CustomerDaoSp.class);
			Customer newc=(Customer)cdao.getByID(cid);
			newc.setAddress_id(c.getAddress_id());
			newc.setFirst_name(c.getFirst_name());
			newc.setLast_name(c.getLast_name());
			newc.setEmail(c.getEmail());
			cdao.ModifyIdEntity(newc);
		}catch(Exception ex){
			response.getWriter().write("FALSE");
		}
		response.getWriter().write("OK");
	}
}

class CustomerTransHelper{
	private int ID;
	private String first_name;
	private String last_name;
	private String email;
	private String address;
	private String last_update;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "CustomerTransHelper [ID=" + ID + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", address=" + address + ", last_update=" + last_update + "]";
	}
}
