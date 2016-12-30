package jeecg;

import com.google.gson.Gson;

public class testgason {
	
	public static void main(String[] args) {
		String json  ="{\"Status\":1,\"Message\":null,\"Count\":1,\"Data\":[{\"ID\":\"c8ae9d95-aea5-43eb-b7be-d16e9df220c6\",\"ClientID\":\"24F020B8-66F2-40BF-8DD6-76D03A4FD74D\",\"Status\":1,\"SumTotal\":21.000000,\"CreationDate\":\"2016-05-11 06:31:15\",\"Creator\":\"admin\"}],\"SyncDate\":\"2016-05-11 15:02:53\"}";
		
		//{"Status":1,"Message":null,"Count":1,"Data":{"ID":"c8ae9d95-aea5-43eb-b7be-d16e9df220c6","ClientID":"24F020B8-66F2-40BF-8DD6-76D03A4FD74D","Status":1,"SumTotal":21.000000,"CreationDate":"2016-05-11 06:31:15","Creator":"admin","OrderDetails":[]},"SyncDate":"2016-05-11 15:02:53"}
		
		Gson gson = new Gson();
		
		OrderUpdateJson orderUpdateJson = new OrderUpdateJson();
		
		
		
		System.out.println(gson.fromJson(json, OrderUpdateJson.class));
		
		
	}

}
