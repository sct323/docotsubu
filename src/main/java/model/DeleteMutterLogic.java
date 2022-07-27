package model;

import dao.MutterDAO;

public class DeleteMutterLogic {
	public void execute(int id) {
		MutterDAO dao = new MutterDAO();
		dao.delete(id);
	}

}
