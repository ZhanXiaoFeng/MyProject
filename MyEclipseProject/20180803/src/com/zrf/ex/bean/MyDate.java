
/**
* @Title: MyDate.java
* @Package com.zrf.ex.bean
* @Description: 日期转化
* @author ZRF
* @date 2018年8月3日
* @version V1.0  
*/

package com.zrf.ex.bean;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.hadoop.io.WritableComparable;

/**
 * @ClassName: MyDate
 * @Description: 日期转化
 * @author ZRF
 * @date 2018年8月3日
 */

public class MyDate implements WritableComparable<MyDate> {
	private LocalDateTime ldt;
	private DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;

	public LocalDateTime getLdt() {
		return ldt;
	}

	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}

	public MyDate() {
		super();
	}

	public MyDate(LocalDateTime ldt) {
		super();
		this.ldt = ldt;
	}
	
	

	@Override
	public String toString() {
		return "MyDate [ldt=" + ldt + "]";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @param arg0
	 * @throws IOException
	 * @see org.apache.hadoop.io.Writable#readFields(java.io.DataInput)
	 */

	@Override
	public void readFields(DataInput input) throws IOException {
		String str = input.readUTF();
		this.ldt = dtf.parse(str, LocalDateTime::from);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @param arg0
	 * @throws IOException
	 * @see org.apache.hadoop.io.Writable#write(java.io.DataOutput)
	 */

	@Override
	public void write(DataOutput output) throws IOException {
		String str = dtf.format(ldt);
		output.writeBytes(str);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @param o
	 * @return
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */

	@Override
	public int compareTo(MyDate o) {
		return -(this.getLdt().compareTo(o.getLdt()));
	}

}
