package ca.qc.cgodin.model;
import java.util.Date;
import java.sql.Timestamp;

public class GetCurrentTS {

	public Timestamp main(String[] args) {
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);	
		ts = Timestamp.valueOf("yyyy-mm-dd HH:mm:ss");
		
		return ts;

	}
}
