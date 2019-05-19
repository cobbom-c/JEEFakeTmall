package top.ourck.beans;
// Generated 2019-3-17 22:07:24 by Hibernate Tools 5.3.6.Final

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 * 订单(Order)的意思是，你清空购物车，结账的时候，上面会打印时间，消费总额<br>
 * 订单项(OrderItem)的意思是，这一次清空购物车，你消费了蜡烛2根，皮鞭1条，冰火两重天3次<br>
 * <br>
 * Order generated by hbm2java
 * @author ourck
 */
@SuppressWarnings("serial")
public class Order implements java.io.Serializable {

	private Integer id;
	private User user; 			// TODO 数据库里这个冗余了！order_表和这里二选一就OK
	private String orderCode; 	// 订单号
	private String address;
	private String post;		// 邮编
	private String receiver;	// 收货人信息（真实名字）
	private String mobile;		// 手机号码
	private String userMessage;	// 用户备注信息
	private Date createDate;
	private Date payDate;
	private Date deliveryDate;	// 发货日期
	private Date confirmDate;	// 确认收货日期
	private String status;		// 订单状态

	private List<OrderItem> itemList;
	private Double totalAmount;
	private Integer totalCount;
	
	public Order() {
	}

	public Order(User user, String orderCode, String address, String post, String receiver, String mobile,
			String userMessage, Date createDate, Date payDate, Date deliveryDate, Date confirmDate, String status) {
		this.user = user;
		this.orderCode = orderCode;
		this.address = address;
		this.post = post;
		this.receiver = receiver;
		this.mobile = mobile;
		this.userMessage = userMessage;
		this.createDate = createDate;
		this.payDate = payDate;
		this.deliveryDate = deliveryDate;
		this.confirmDate = confirmDate;
		this.status = status;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserMessage() {
		return this.userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getConfirmDate() {
		return this.confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// OURCK: Business relative below.
	public List<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

}
