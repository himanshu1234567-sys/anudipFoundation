package DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Demo {

	static void m1(){
		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalTime time = LocalTime.now();
		System.out.println(time);
	}
	
	static void m2(){
		LocalDate date = LocalDate.now();
		int day = date.getDayOfMonth();
		int mon = date.getMonthValue();
		int yyyy = date.getYear();
		System.out.printf("%d-%d-%d", day,mon,yyyy);
	}
	
	static void m3(){
		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		int min = time.getMinute();
		int seconds = time.getSecond();
		int nanoSeconds = time.getNano();
		System.out.printf("%d:%d:%d:%d",hour,min,seconds,nanoSeconds);
	}
	
	static void m4(){
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("Local Date Time: "+dt);
		
		int day = dt.getDayOfMonth();
		int mon = dt.getMonthValue();
		int yyyy = dt.getYear();
		System.out.printf("Date = %d-%d-%d", day,mon,yyyy);
		
		int hour = dt.getHour();
		int min = dt.getMinute();
		int seconds = dt.getSecond();
		int nanoSeconds = dt.getNano();
		System.out.printf("\nTime = %d:%d:%d:%d",hour,min,seconds,nanoSeconds);
	}
	
	static void m5(){
		LocalDateTime dt = LocalDateTime.of(1984, Month.SEPTEMBER, 24, 4, 30);
		System.out.println("Local Date Time: "+dt);
		LocalDateTime dt2 = LocalDateTime.now();
		System.out.println(dt2.minusYears(34));
		System.out.println(dt2.minusMonths((34*12)+3));
		System.out.println(dt2.plusYears(34));
	}
	
	static void m6(){
		LocalDate today = LocalDate.now();
		LocalDate dob = LocalDate.of(1984, 9, 24);
		Period p = Period.between(dob, today);
		System.out.printf("%d-%d-%d",p.getDays(),p.getMonths(),p.getYears());
		
		LocalDate deathDay = LocalDate.of((1984+60), 9, 24);
		Period p2 = Period.between(today, deathDay);
		System.out.printf("\n%d-%d-%d",p2.getDays(),p2.getMonths(),p2.getYears());
	}
	
	static void m7(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any year");
		int yy = sc.nextInt();
		Year year = Year.of(yy);
		if(year.isLeap())System.out.printf("%d : is leap year",yy);
		else System.out.printf("%d : is not leap year",yy);
	}
	
	static void m8(){
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);
		ZoneId loss_angeles = ZoneId.of("America/Los_Angeles");
		ZonedDateTime z = ZonedDateTime.now(loss_angeles);
		System.out.println("America : "+z);
	}
	
	public static void main(String[] args) {
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		//m6();
		//m7();
		//m8();

	}

}
