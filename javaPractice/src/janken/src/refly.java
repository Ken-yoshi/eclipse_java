
public class refly {

	//定数
		final String HAND_G = "グー";
		final String HAND_C = "チョキ";
		final String HAND_P = "パー";
		
	//フィールド
	private String name;   //レフリーの名前
	
	//コンストラクタ
	refly(String nam) {
		this.name = nam;
	}
	
	//メソッド
	
	//ジャンケン開始を宣言
	void startJanken() {
		messageRefly("ジャンケン・・・ぽん！");
	}
	
	//審判が手を確認
	void checkHand(janken_Player p) {
		
		if(	(p.getHandStatus()).equals(HAND_G)	) {
			
			messageRefly(p.getName() + "さんの手はグーでした!");
			
		} else if(	(p.getHandStatus()).equals(HAND_C)	) {
			
			messageRefly(p.getName() + "さんの手はチョキでした!");
			
		}  else if(	(p.getHandStatus()).equals(HAND_P)	) {
			
			messageRefly(p.getName() + "さんの手はパーでした!");
		} 
	}
	
	//審判が判定
	void jugejanken(janken_Player p1, janken_Player p2) {
		
		messageRefly("結果は・・・");
		
		if( 	(p1.getHandStatus()).equals(p2.getHandStatus())	)	{
			
			messageRefly("あいこっ！　勝負つかず！");
			
		}else if( 	(p1.getHandStatus()).equals(HAND_G)  && (p2.getHandStatus()).equals(HAND_C)
				  ||(p1.getHandStatus()).equals(HAND_C)  && (p2.getHandStatus()).equals(HAND_P)
				  ||(p1.getHandStatus()).equals(HAND_P)  && (p2.getHandStatus()).equals(HAND_G) ) {
			
			messageRefly(p1.getName() + "の勝ち! ");
			
		}else if( 	(p2.getHandStatus()).equals(HAND_G)  && (p1.getHandStatus()).equals(HAND_C)
				  ||(p2.getHandStatus()).equals(HAND_C)  && (p1.getHandStatus()).equals(HAND_P)
				  ||(p2.getHandStatus()).equals(HAND_P)  && (p1.getHandStatus()).equals(HAND_G) ) {
			
			messageRefly(p2.getName() + "の勝ち! ");
		}
	}
	
	public String getName() {
		return this.name; 
	}
	
	
	
	
	
	void messageRefly(String msg) {
		
		System.out.println(this.name + "「 " + msg + " 」" );
	}
	
}
