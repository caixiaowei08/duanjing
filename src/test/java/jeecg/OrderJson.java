package jeecg;

import java.io.Serializable;
import java.util.List;

public class OrderJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID
	 */
	private String ID;
	/**
	 * 订单编号
	 */
	private String Code;
	/**
	 * 客户ID
	 */
	private String ClientID;
	/**
	 * 状态(0未上传，1已上传，2已关闭)
	 */
	private int Status;
	/**
	 * 订单总金额
	 */
	private float SumTotal;
	/**
	 * 创建日期
	 */
	private String CreationDate;
	/**
	 * 创建人
	 */
	private String Creator;
	/**
	 * 修改日期
	 */
	private String ModificationDate;
	/**
	 * 修改人
	 */
	private String Modifier;

	//private List<OrderDetailJson> OrderDetails;

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}

	public String getClientID() {
		return ClientID;
	}

	public void setClientID(String ClientID) {
		this.ClientID = ClientID;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int Status) {
		this.Status = Status;
	}

	public float getSumTotal() {
		return SumTotal;
	}

	public void setSumTotal(float SumTotal) {
		this.SumTotal = SumTotal;
	}

	public String getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}

	public String getCreator() {
		return Creator;
	}

	public void setCreator(String Creator) {
		this.Creator = Creator;
	}

	public String getModificationDate() {
		return ModificationDate;
	}

	public void setModificationDate(String ModificationDate) {
		this.ModificationDate = ModificationDate;
	}

	public String getModifier() {
		return Modifier;
	}

	public void setModifier(String Modifier) {
		this.Modifier = Modifier;
	}

	/*public List<OrderDetailJson> getOrderDetailJsons() {
		return OrderDetails;
	}

	public void setOrderDetailJsons(List<OrderDetailJson> OrderDetails) {
		this.OrderDetails = OrderDetails;
	}*/

}
