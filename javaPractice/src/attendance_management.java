import EX.readfile;
import java.sql.Time;

public class attendance_management {

	public static void main(String[] args) {
		
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
		Time startTime = Time.valueOf(args[0]);
		Time finishTime = Time.valueOf(args[1]);
		
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
					System.out.println("休憩時間は" +  restTime60 + "分でした。");
				} else {
					salary = restAdditionWorking * hourly_wage / 60;
					System.out.println("休憩時間は" +  restTime60 + "分でした。");
				}
				//８時間以上の時間に残業代(時給 x 1.25)で計算
			} else {				
				int restAdditionWorking = working_Hour_min - restTime45;
				salary = restAdditionWorking * hourly_wage / 60;
				System.out.println("休憩時間は" +  restTime45 + "分でした。");
			}
		} else {
			
			salary = working_Hour_min *  hourly_wage / 60 ;
		}
		System.out.println("本日の労働時間は" + workingHour + "時間" + workingMin + "分です。");
		
		System.out.println("時給900円で、本日の給料は、" + salary + "円です。お疲れ様でした。");
		
		
		
		
		
		
		
		
		
		
	}
}
