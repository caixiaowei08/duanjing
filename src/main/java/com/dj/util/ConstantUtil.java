package com.dj.util;

public class ConstantUtil {
	
	/**
	 * 人员类别
	 * @author User
	 *
	 */
	public static class PeoType{
		/**
		 * 常住人员
		 */
		public final static String LOCAL_PEOPLE="l";
		/**
		 * 来沪人员
		 */
		public final static String NONLOCAL_PEOPLE="n";
		/**
		 * 境外人员
		 */
		public final static String FOREIGER_PEOPLE="f";
		
	}
	
		/**
		 * 党员类别
		 * @author User
		 *
		 */
	 public static class MemberType{
		/**
		 * 户籍党员
		 */
		public final static String LOCAL_MEMBER="01";
		/**
		 * 来沪党员
		 */
		public final static String NONLOCAL_MEMBER="02";
		/**
		 * 预备党员
		 */
		public final static String PREPARATORY_MEMBER="03";
		/**
		 * 拟预备党员
		 */
		public final static String BEFOREPRE_MEMBER="04";
		/**
		 * 党员变动
		 */
		public final static String CHANGE_MEMBER="05";
		/**
		 * 老龄党员
		 */
		public final static String OLD_MEMBER="06";
		
	}
	 
		/**
		 * 人户分离
		 * @author User
		 *
		 */
		public static class PHouse{
			/**
			 * 户籍人口
			 */
			public final static String P_HOUSE_01="01";
			/**
			 * 户在人不在
			 */
			public final static String P_HOUSE_02="02";
			/**
			 * 人在户不在
			 */
			public final static String P_HOUSE_03="03";
			
		}
		
		/**
		 * 人户分离
		 * @author User
		 *
		 */
		public static class IsYN{
			/**
			 * 户籍人口
			 */
			public final static String YES="Y";
			/**
			 * 户在人不在
			 */
			public final static String NO="N";
			
			
		}
		
		/**
		 * 人户分离
		 * @author User
		 *
		 */
		public static class Attention_Type{
			/**
			 * 服刑人员
			 */
			public final static String Attention_Type_01="01";
			/**
			 * 监外服刑
			 */
			public final static String Attention_Type_02="02";
			/**
			 * 刑释解教
			 */
			public final static String Attention_Type_03="03";
			
			
		}

}
