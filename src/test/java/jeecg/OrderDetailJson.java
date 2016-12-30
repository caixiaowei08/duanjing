package jeecg;

import java.io.Serializable;

public class OrderDetailJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID
	 */
	private String ID;
	/**
	 * 订单明细ID
	 */
	private String DetailID;
	/**
	 * 物料ID
	 */
	private String MaterialID;
	/**
	 * 颜色ID
	 */
	private String ColorID;
	/**
	 * 价格
	 */
	private float Price;
	/**
	 * 长度
	 */
	private float Qty;
	/**
	 * 金额
	 */
	private float Total;

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getDetailID() {
		return DetailID;
	}

	public void setDetailID(String DetailID) {
		this.DetailID = DetailID;
	}

	public String getMaterialID() {
		return MaterialID;
	}

	public void setMaterialID(String MaterialID) {
		this.MaterialID = MaterialID;
	}

	public String getColorID() {
		return ColorID;
	}

	public void setColorID(String ColorID) {
		this.ColorID = ColorID;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float Price) {
		this.Price = Price;
	}

	public float getQty() {
		return Qty;
	}

	public void setQty(float Qty) {
		this.Qty = Qty;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

}
