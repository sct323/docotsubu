//◆ログインに関するリクエストを行うコントローラ◆

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//index.jspのログインフォームから処理を受け取るdoPostメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//フォームで入力されたリクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		
		//Userインスタンス（ユーザー情報）の生成
		//modelのUserクラスにフォームで取得した値を引数にセット
		User user = new User(name,pass);
		
		
		//ログイン処理
		//ModelのLoginLogicクラスを呼び出す
		LoginLogic LoginLogic = new LoginLogic();
		//LoginLogicクラスのboolean型executeメソッドをboolean型、変数名isLoginに代入
		boolean isLogin = LoginLogic.execute(user);
		
		
		//ログイン成功時の処理
		//isLoginがTrueだったら
		if(isLogin) {
			//セッションスコープに登録ユーザーを保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}
		
		//ログイン結果画面をloginResult.jspにフォワードさせる
		//スコープをJSPファイルに引き継ぐからフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
