class janken {
	public static void main(String args[]) {
		
		
	//定数
	final String HAND_G = "グー";
	final String HAND_C = "チョキ";
	final String HAND_P = "パー";
	
	//シナリオ　
		//コマンドライン引数より２つの文字列を受け取る
		String name1 = args[0];    //1人目のプレイヤー
		String name2 = args[1];	   //2人目のプレイヤー
		String name3 = args[2];	   //審判
		
		//3名のプレイヤーを場に登場させる
		janken_Player p1 = new janken_Player(name1);
		janken_Player p2 = new janken_Player(name2);
		refly refly = new refly(name3);
		
		//ジャンケン開始
		refly.startJanken();
		
		//それぞれのプレイヤーの手を決める
		p1.makeHandStatus();
		p2.makeHandStatus();
	
		//審判がそれぞれの手を言う
		refly.checkHand(p1);
		refly.checkHand(p2);
	
	
		//ジャンケンの判定
		refly.jugejanken(p1, p2);
	}
}
