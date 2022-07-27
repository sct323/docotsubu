//◆つぶやきに関するリクエストを処理するコントローラ◆

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//つぶやきを取得してリクエストスコープに保存
			GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
			List<Mutter> mutterList = getMutterListLogic.execute();
			request.setAttribute("mutterList", mutterList);
			
			//ログインしているか確認するため、セッションスコープ（User.java）から情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			if(loginUser == null) {//ログインしていない場合はindex.jspにリダイレクトさせる
				response.sendRedirect("/dokoTsubuMysql/");
			}else {
				//ログイン済みの場合はmain.jspへフォワードさせる
				//スコープをJSPファイルに引き継ぐからフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);
		}
		
	
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		//入力チェック
		if(text != null && text.length() !=0) {
			//アプリケーションスコープに保存されたつぶやきリストを取得
			//ServletContext application = this.getServletContext();
			//List<Mutter>mutterList = (List<Mutter>)application.getAttribute("mutterList");
			
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);
			
			
		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		
		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic=new GetMutterListLogic();
		List<Mutter>mutterList=getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
		
		//メイン画面にフォワード
		//スコープをJSPファイルに引き継ぐからフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
