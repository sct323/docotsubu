//Model（データモデル）
//◆つぶやきに関する情報をもつJava Beans◆

//Java Beansルール「packageに所属させる」
package model;

//Java Beansルール「直列化させる」
import java.io.Serializable;

public class Mutter implements Serializable{
	//Java Beansルール「カプセル化させる」
	//フィールド・属性
	private int id;
	private String userName;
	private String text;
	
	//Java Beansルール「引数なしコンストラクタの生成」
	//引数なしコンストラクタ
	public Mutter() {
		
	}
	
	//引数ありコンストラクタ
		public Mutter(String userName, String text) {
			this.userName = userName;
			this.text = text;
		}
	
	//引数ありコンストラクタ
	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}
	
	//Java Beansルール「getterのセット」
	//getterの設定
	public int getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getText() {
		return text;
	}
	
	

}
