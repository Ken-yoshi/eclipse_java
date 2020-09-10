class janken_Player {
	//定数
	final String HAND_G = "グー";
	final String HAND_C = "チョキ";
	final String HAND_P = "パー";
	
	
	//フィールド
	private String name ;          //名前
	private String handStatus;	   //ジャンケンの手
	
	//コンストラクタ①
	janken_Player(String nm) {
		this.name = nm;  	//名前
	}
	
	//メソッド
	void makeHandStatus() {
		
		int random1To3 = 1 + (int)(Math.random()* 3);
		
		switch(random1To3) {
			case 1:
				this.handStatus = HAND_G;     //グー
				break;
			case 2:
				this.handStatus = HAND_C;	 //チョキ
				break;
			case 3:
				this.handStatus = HAND_P;	 //パー
				break;
		}
	}
	
	public String getName() {
		return this.name; 
	}
	
	public String getHandStatus() {
		return this.handStatus;
	}

}
