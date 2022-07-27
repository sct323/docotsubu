package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	//データベースに接続に使用する情報をカプセル化
	private final String JDBC_URL = "jdbc:mysql://localhost/docoTsubu";
	private final String DB_USER = "root";
	private final String DB_PASS = "202202sct";
	
	
	public List<Mutter> findAll(){
		List<Mutter> mutterList = new ArrayList<Mutter>();
		
		
		//データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//Class.forName("com.mysql.jdbc.Driver");
			
			//SELECT文の準備（IDで降順）
			String sql = "SELECT ID, NAME, TEXT FROM MUTTER ORDER BY ID DESC";
			//SQLをDBに届ける（SQLの送信）PreparedStatementインスタンスを取得する
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECT文を実行し、結果表（ResultSet：DBMSから検索結果を受け取る）を取得
			ResultSet rs = pStmt.executeQuery();
			
			//結果に格納されたレコードの内容を表示
			while (rs.next()) {//結果表の取り出し対象レコードを1つ進める
				//取り出し対象のレコードの各列の値を取得する
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
				
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
				//return null;
			}
			return mutterList;
		}
	public boolean create(Mutter mutter) {
		//
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//
			String sql = "INSERT INTO MUTTER(NAME, TEXT) VALUES(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
					
			//INSERT文中の「？」に使用する値を設定しSQLを作成
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			
			
			//
			
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Mutter> search(String keyword){
		List<Mutter> mutterList = new ArrayList<Mutter>();
		//データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文の準備（投稿の文字列のみ取得）
			String sql = "SELECT ID, NAME, TEXT FROM MUTTER WHERE TEXT LIKE ? ORDER BY ID DESC";
			//SQLをDBに届ける（SQLの送信）PreparedStatementインスタンスを取得する
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//INSERT文の「？」に使用する値を設定しSQLを完成
			pStmt.setString(1, "%" + keyword + "%");
			
			//SELECT文を実行し、結果表（ResultSet：DBMSから検索結果を受け取る）を取得
			ResultSet rs = pStmt.executeQuery();
			
			
			//結果に格納されたレコードの内容を表示
			while (rs.next()) {//結果表の取り出し対象レコードを1つ進める
				//取り出し対象のレコードの各列の値を取得する
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
				
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
				//return null;
			}
			return mutterList;
		
	}
	
	public boolean delete(int id) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = "DELETE FROM MUTTER WHERE ID = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, id);
			
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
				
	}
	
	public boolean update(int id, String text) {
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = "UPDATE MUTTER SET TEXT = ? WHERE ID = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, text);
			pStmt.setInt(2, id);
			
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
