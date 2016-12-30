package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalTest {
	
	public static void main(String[] args) {
		/*BigDecimal b1 = new BigDecimal("10.1111");
        BigDecimal b2 = new BigDecimal("2.111");
       // BigDecimal b3 = b1.divide(b2,2,BigDecimal.ROUND_HALF_EVEN);
        BigDecimal b3 = b1.multiply(b2).divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_EVEN);*/
		
	    DecimalFormat df = new DecimalFormat("#0.00");
		
		
        System.out.println(df.format(1.235));
	}



}
