package jeecg;

import java.io.Serializable;
import java.util.List;

public class OrderUpdateJson extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<OrderJson> Data;

	public List<OrderJson> getData() {
		return Data;
	}

	public void setData(List<OrderJson> data) {
		Data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
