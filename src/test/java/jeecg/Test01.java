package jeecg;

import org.junit.Test;

public class Test01 {

	@Test
	public void test01() {

		String str0 = "月浦镇段泾村泗塘宅13号306室";
		int i0 = str0.indexOf("宅");
		int i1 = str0.indexOf("号");
		int i2 = str0.indexOf("室");
		
		System.out.println(str0.substring(6,i0+1));
		System.out.println(str0.substring(i0+1,i1+1));
		//System.out.println(str0.substring((i1+1,i2)).substring(0, 1));
		
		/*String str1 = "月浦镇段泾村支家楼宅16号";
		String str2 = "月浦镇段泾村西北宅32号";
		String str3 = "月浦镇段泾村泗塘宅17号";
		String str4 = "月浦镇段泾村陆家宅40号";

		int i0 = str0.indexOf("宅");
		int i1 = str1.indexOf("宅");
		int i2 = str2.indexOf("宅");
		int i3 = str3.indexOf("宅");
		int i4 = str4.indexOf("宅");
		

		System.out.println(i0);
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		
		System.out.println(str0.substring(6,i0+1));
		System.out.println(str1.substring(6,i1+1));
		System.out.println(str2.substring(6,i2+1));
		System.out.println(str3.substring(6,i3+1));
		System.out.println(str4.substring(6,i4+1));
		
		System.out.println(str0.substring(i0+1));
		System.out.println(str1.substring(i1+1));
		System.out.println(str2.substring(i2+1));
		System.out.println(str3.substring(i3+1));
		System.out.println(str4.substring(i4+1));
*/
	}
}
