package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteMutterLogic;

/**
 * Servlet implementation class DeleteMutter
 */
@WebServlet("/DeleteMutter")
public class DeleteMutter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMutter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメータからIDを取得
		request.setCharacterEncoding("UTF-8");	
		int id = Integer.parseInt(request.getParameter("id"));
		
		//DeleteMutterLogicインスタンスの生成
		DeleteMutterLogic deleteMutterLogic = new DeleteMutterLogic();
		
		//DeleteMutterLogicの処理を実行
		deleteMutterLogic.execute(id);
		
		// リダイレクト
		response.sendRedirect("/dokoTsubuMysql/Main");
		
		
	}

}
