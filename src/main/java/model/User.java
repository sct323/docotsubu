//Model（データモデル）
//◆ユーザーに関する情報をもつJava Beans◆

//Java Beansルール「packageに所属させる」
package model;

//Java Beansルール「直列化させる」
import java.io.Serializable;

public class User implements Serializable{
	//Java Beansルール「カプセル化させる」
	//フィールド・属性
	private String name;
	private String pass;
	//Java Beansルール「引数なしコンストラクタの生成」
	//引数なしコンストラクタ
	public User() {
		
	}
	
	
	//引数ありコンストラクタ
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	
	//Java Beansルール「getterのセット」
	//getterの設定
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
		
	}
	

}
