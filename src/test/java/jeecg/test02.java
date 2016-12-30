package jeecg;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.dj.health.banquet.entity.DjMarriageFuneralBanquetEntity;
import com.dj.renthouse.renthouseinfo.entity.DjHouseInfoEntity;

public class test02 {
	
	public void tesxt(){
		int i=0;
		//i=2,3;
		
		Integer [] L1={new Integer(2),new Integer(3)};
		Integer [] L2=new Integer[2],L11;
		
	}
	
	
	
	
/*	Criteria criteria_delte = djHouseInfoService.getSession().createCriteria(DjHouseInfoEntity.class);
	
	criteria_delte.add(Restrictions.eq("district", djHouse.getDistrict()));
	criteria_delte.add(Restrictions.eq("town", djHouse.getTown()));
	criteria_delte.add(Restrictions.eq("village", djHouse.getVillage()));
	criteria_delte.add(Restrictions.eq("ridgeNo", djHouse.getRidgeNo()));*/
	@SuppressWarnings({ "unchecked", "rawtypes"})
    public static <S> Criteria copyPropertys(Criteria criteria,S s) {
		
		
        if(s == null){
            return criteria;
        }
        
        Field[] sfields = s.getClass().getDeclaredFields();
        
        System.out.println(sfields);
        
        Class scls = s.getClass();
		return criteria;
        
       /* try {
            for (Field sfield : sfields) {
            	
                String sName = sfield.getName();
                Class sType = sfield.getType();
                String sfieldName = sName.substring(0, 1).toUpperCase()
                        + sName.substring(1);
                Method sGetMethod = scls.getMethod("get" + sfieldName);
                
                Object value = sGetMethod.invoke(s);
                
                for (Field dfield : dfields) {
                    String dName = dfield.getName();
                    Class dType = dfield.getType();
                    if (dName.equals(sName)
                            && sType.toString().equals(dType.toString())) {
                        Method dSetMethod = dcls.getMethod("set" + sfieldName,
                                sType);
                        dSetMethod.invoke(d, value);
                        break;
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e1) {
            e1.printStackTrace();
        }
        return d;*/
        
    }
	
	//String str[] =
	
	@Test
	public <S> void test03(S s){
		
		DjMarriageFuneralBanquetEntity  banquetEntity = new DjMarriageFuneralBanquetEntity();
		Field[] sfields = banquetEntity.getClass().getDeclaredFields();
		for (Field field : sfields) {
			
		}
		
		System.out.println(sfields);
		
		
	}

}
