//ロジックモデル
//◆つぶやきの投稿に関する処理を行うモデル◆
package model;

import dao.MutterDAO;

public class PostMutterLogic {
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
		
		//最新の投稿が要素番号「０番目」にくるようにする
		//mutterList.add(0, mutter);
	}

}
