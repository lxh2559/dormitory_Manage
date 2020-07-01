package Control;

import Model.ManagersModel;
import Operation.ManagersOperation;

public class ManagersControl {

	public ManagersModel get(String manager_id) throws Exception {
		ManagersOperation selmanager = new ManagersOperation();
		return selmanager.selectone(manager_id);

	}
	
}
