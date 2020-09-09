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
		//2名のプレイヤーを場に登場させる
		janken_Player p1 = new janken_Player(name1);
		janken_Player p2 = new janken_Player(name2);
		
		//ジャンケン開始
		System.out.println("ジャンケン・・・ポン！");
		//それぞれのプレイヤーの手を決める
		p1.makeHandStatus();
		p2.makeHandStatus();
	
		//それぞれのプレイヤーのジャンケンの手を表示させる
		System.out.println(p1.name + "の手 : " + p1.handStatus);
		System.out.println(p2.name + "の手 : " + p2.handStatus);
	
		//ジャンケンの判定
		if(	(p1.handStatus).equals(p2.handStatus)	) {
			//あいこの判定
			System.out.println("あいこ! 引き分け");
		} else if(	(p1.handStatus.equals(HAND_G)) && (p2.handStatus.equals(HAND_C))
				  ||(p1.handStatus.equals(HAND_C)) && (p2.handStatus.equals(HAND_P))
				  ||(p1.handStatus.equals(HAND_P)) && (p2.handStatus.equals(HAND_G))	) {
			System.out.println(p1.name + "の勝ち");
		} else if(	(p2.handStatus.equals(HAND_G)) && (p1.handStatus.equals(HAND_C))
				  ||(p2.handStatus.equals(HAND_C)) && (p1.handStatus.equals(HAND_P))
				  ||(p2.handStatus.equals(HAND_P)) && (p1.handStatus.equals(HAND_G))	) {
			System.out.println(p2.name + "の勝ち");
		} else {
			System.out.println("判定エラー");
		}
	}
}
