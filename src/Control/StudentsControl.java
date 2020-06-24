package Control;

import Model.StudentsModel;
import Operation.StudentsOperation;

public class StudentsControl {

	public StudentsModel get(String student_id) throws Exception {
		StudentsOperation selstudent = new StudentsOperation();
		return selstudent.selectone(student_id);

	}
	
}
