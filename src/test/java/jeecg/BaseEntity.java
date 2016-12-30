package jeecg;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 基础类型 与webserver对应
 * 
 * @author User
 * @param <T>
 */
public class BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int Status;
	protected int Count;
	protected String Message;
	protected String SyncDate;

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getSyncDate() {
		return SyncDate;
	}

	public void setSyncDate(String syncDate) {
		SyncDate = syncDate;
	}
	
	

}
