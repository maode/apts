package com.shanghai.our.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @create date 2012-08-27
 * @author 耿文强
 * @class description 用户处理时间对象和时间字符串的工具类
 */
public class DateUtil {

	/**
	 * 将字符串转化成日期对象
	 * 
	 * @param dateStr
	 * @return Date时间对象
	 */
	public static Date StringToDate(String dateStr) {

		// 构造时间格式对象
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			// 将字符串转化成时间对象
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static String  DoubleToDate(Double d){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 String str=format.format(d);
		 return str;
	}

	
	/**
	 * 将日期对象转化成yyyy-MM-dd格式的字符串
	 * 
	 * @param date
	 * @return string:yyyy-MM-dd格式的时间字符串
	 */
	public static String DateToString(Date date) {
		// 构造时间格式对象
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 格式化时间对象
		String dateStr = format.format(date);
		return dateStr;
	}
	

	/**
	 * 将字符串转化成日期对象
	 * 
	 * @param dateStr
	 *            字符串对象
	 * @param strFormat
	 *            格式
	 * @return Date
	 */
	public static Date StringToDate(String dateStr, String strFormat) {
		// 构造时间格式对象
		SimpleDateFormat format = new SimpleDateFormat(strFormat);
		Date date = null;
		try {
			// 将字符串转化成时间对象
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将日期对象转化成某种格式的字符串
	 * 
	 * @param date
	 *            日期对象
	 * @param strFormat
	 *            格式
	 * @return 返回指定时间格式的字符串
	 */
	public static String DateToString(Date date, String strFormat) {
		// 构造时间格式对象
		SimpleDateFormat format = new SimpleDateFormat(strFormat);
		// 格式化时间对象
		String dateStr = format.format(date);
		return dateStr;
	}

	/**
	 * 获得本周一的日期
	 * @return
	 */
	public static Date getDateOfMonday(){
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();
		return monday;
	}
	
	/**
	 * 获取本周日的日期
	 * @return
	 */
	public static Date getDateOfSunday(){
		Date monday = getDateOfMonday();
		Calendar sunday = Calendar.getInstance();
		sunday.setTime(monday);
		sunday.add(Calendar.DAY_OF_MONTH, 6);
		return sunday.getTime();
	}

	/**
	 *  获得当前日期与本周日相差的天数
	 * @return
	 */
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 0) {
			dayOfWeek = 7;
		}
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	/**
	 * 获取当月第一天
	 * @param bs
	 * @return
	 */
	public static Date getFirstDayOfMonth() {
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		return lastDate.getTime();
	}
	
	/**
	 * 取得最后一天
	 * @return
	 */
	public static Date getLastDayOfMonth(){
        Calendar cal = Calendar.getInstance(); 
		cal.setTime(getFirstDayOfMonth()); 
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
		cal.set(Calendar.DAY_OF_MONTH, value); 
		return cal.getTime(); 
	}
	
	/**
	 * 将时间设置为23点59分59秒
	 * @param dt
	 * @return
	 */
	public static Date setTime_235959(Date dt){
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * 设置时间为00：00：00
	 * @param dt
	 * @return
	 */
	public static Date setTime_000000(Date dt){
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取开始时间和结束时间之间的工期
	 * @param start
	 * @param end
	 * @return
	 */
	public static long getDurationByStartToEnd(Date start,Date end){
		String st=DateUtil.DateToString(start,"yyyy-MM-dd");
		String et=DateUtil.DateToString(end,"yyyy-MM-dd");
		start=DateUtil.StringToDate(st+" 08:00:00", "yyyy-MM-dd hh:mm:ss");
		end=DateUtil.StringToDate(et+" 17:00:00", "yyyy-MM-dd hh:mm:ss");
		long diff = end.getTime() - start.getTime();
	    long days = diff / (1000 * 60 * 60 * 24)+1;
		return days;
	}
	/**
	 * 获取开始时间和结束时间之间的工期
	 * @param start
	 * @param end
	 * @return
	 */
	public   static   Date   formatDate(Date   dt)
    {
        String   format= "yyyyMMdd ";
        SimpleDateFormat   dateFormat=new   SimpleDateFormat(format);
        Date   date=null;
        try   {
            date=dateFormat.parse(dateFormat.format(dt));;
        }
        catch   (Exception   ex)   {
            System.out.println( " "+ex);
        }
        return   date;
    } 
	//date的往后一个月
	public   static   Date   afterOnMonth(Date   date,int mcount)
    {
        date=formatDate(date);
        Calendar   cal=Calendar.getInstance();
        cal.setTime(formatDate(date));
        cal.add(Calendar.MONTH,mcount);
        Date   oneMonthAfter=cal.getTime();
       
        cal=null;
        return   oneMonthAfter;
    }
	//date 往前一个月
	public static Date beforeOnMonth(Date date,int mcount){
		date=formatDate(date);
        Calendar   cal=Calendar.getInstance();
        cal.setTime(formatDate(date));
        cal.add(Calendar.MONTH,-mcount);
        Date   oneMonthBefore=cal.getTime();
        cal=null;
        return   oneMonthBefore;
	}
	
	public static Date beforeOnDay(Date date,int count){
		date=formatDate(date);
        Calendar   cal=Calendar.getInstance();
        cal.setTime(formatDate(date));
        cal.add(Calendar.DAY_OF_MONTH,-count);
        Date   oneMonthBefore=cal.getTime();
        cal=null;
        return   oneMonthBefore;
		
	};

	
	public static String getIntervalDays(Date fDate, Date oDate) {

	       if (null == fDate || null == oDate) {

	           return "暂无";

	       }

	       long intervalMilli = oDate.getTime() - fDate.getTime();

	       int  day= (int) (intervalMilli / (24 * 60 * 60 * 1000));
	       String str="暂无";
	       if(day<1)
	    	   str="当天";
			else if(day>=1&&day<2)
				 str="昨天";
			else if(day>=2&&day<3)
				 str="前天";
			else if(day>=3&&day<4)
				 str="三天前";
			else if(day>=4&&day<5)
				 str="四天前";
			else if(day>=5&&day<6)
				 str="五天前";
			else if(day>=6&&day<7)
				 str="六天前";
			else
				 str="一周前";
	       return str;
	    }
	
	public static boolean isValidDate(String s)
    {
		SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
	        // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
	        dateFormat.setLenient(false);
        try
        {
             dateFormat.parse(s);
             return true;
         }
        catch (Exception e)
        {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }
	

	
}
