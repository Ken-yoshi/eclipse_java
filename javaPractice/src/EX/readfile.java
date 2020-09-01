package EX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class readfile {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		final String WORKING_RESULT_FILE_PATH = "/Users/kensuke/Desktop/final/WorkingResult.csv";
		
		final String COMMA = ",";
		
		final long HOUR_MILLI_SECOND = 1000 * 60 * 60; // 1時間のミリ秒換算
		final long MIN_MILLI_SECOND = 1000 * 60;  //1分の
		final int HOUR_MILLI = 60;  //1時間の分換算
		
		List<String> workingResult = new ArrayList<String>();
		
		try {
			
			File workingResultFile = new File(WORKING_RESULT_FILE_PATH);
			BufferedReader br = new BufferedReader(new FileReader(workingResultFile));
			
			String recode = br.readLine();
			while(recode != null) {
				workingResult.add(recode);
				recode = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		int current_month_salary = 0;
		
		for(int i = 0; i < workingResult.size(); i++) {
			
			String workingRecode = workingResult.get(i);
			String[] workingRecodeAr = workingRecode.split(",");
			
			current_month_salary += salary_month(workingRecodeAr[1], workingRecodeAr[2] );
		}
		System.out.println("今月の給料は、" + current_month_salary + "円です。お疲れ様でした。");
	}
	
public static int salary_month(String st, String ed) {
		
		final long HOUR_MILLI_SECOND = 1000 * 60 * 60; // 1時間のミリ秒換算
		final long MIN_MILLI_SECOND = 1000 * 60;  //1分の
		final int HOUR_MILLI = 60;  //1時間の分換算
		final int hourly_wage = 900;  //時給900円
		final int restBorder_Down = 360;  // 休憩が必要な下限時間（分）
		final int restBorder_Up = 480;  //休憩が必要な上限時間(分)
		final int restTime45 = 45;    //休憩時間
		final int restTime60 = 60;    //休憩時間
		final int overtime_work_hourly_wage = (int)(hourly_wage * 1.25); //残業時間の時給
		
		//バイトの開始時間と終了時間をコマンドライン引数から受け取る
		Time startTime = Time.valueOf( st);
		Time finishTime = Time.valueOf( ed);
		
		long workingTime = finishTime.getTime() - startTime.getTime();
		
		int workingHour = (int)( workingTime / HOUR_MILLI_SECOND); //時間に換算
		int workingMin = (int)( (workingTime / MIN_MILLI_SECOND) % HOUR_MILLI);  //分に換算
		int working_Hour_min = (int)(workingTime / MIN_MILLI_SECOND); //労働時間を分に変換
		int salary = 0 ;   //給料
		
		//もし労働時間６時間以上、８時間未満なら４５分の休憩
		if(working_Hour_min >= restBorder_Down ) {
			//もし労働時間が８時間を超えている場合
			
			if(working_Hour_min > restBorder_Up) {
				int restAdditionWorking = working_Hour_min -  restTime60;  //休憩１時間
				if(restAdditionWorking > restBorder_Up) {
					salary = (int)((restBorder_Up *  hourly_wage / 60 ) + ((restAdditionWorking - restBorder_Up)  * overtime_work_hourly_wage / HOUR_MILLI )) ;					
//					System.out.println("休憩時間は" +  restTime60 + "分でした。");
				} else {
					salary = restAdditionWorking * hourly_wage / 60;
//					System.out.println("休憩時間は" +  restTime60 + "分でした。");
				}
				//８時間以上の時間に残業代(時給 x 1.25)で計算
			} else {				
				int restAdditionWorking = working_Hour_min - restTime45;
				salary = restAdditionWorking * hourly_wage / 60;
//				System.out.println("休憩時間は" +  restTime45 + "分でした。");
			}
		} else {
			
			salary = working_Hour_min *  hourly_wage / 60 ;
		}
//		System.out.println("本日の労働時間は" + workingHour + "時間" + workingMin + "分です。");
//		
//		System.out.println("時給900円で、本日の給料は、" + salary + "円です。お疲れ様でした。");
		
		
		
		return salary;
		
	}
		
}
