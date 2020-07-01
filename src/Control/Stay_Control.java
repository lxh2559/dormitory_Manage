package Control;

import Model.Stay_Model;
import Operation.Stay_Operation;

public class Stay_Control {
    public void update(Stay_Model sModel) throws Exception {
        Stay_Operation stay_Operation = new Stay_Operation();
        stay_Operation.updateStay(sModel);
    }

    public void delete(Stay_Model sModel) throws Exception {
        Stay_Operation stay_Operation = new Stay_Operation();
        stay_Operation.deleteStay(sModel);
    }

    public void add(Stay_Model sModel) throws Exception {
        Stay_Operation stay_Operation = new Stay_Operation();
        stay_Operation.addStay(sModel);
    }

    public Stay_Model get(String dorm_id, Integer bed_id) throws Exception {
        Stay_Operation stay_Operation = new Stay_Operation();
        return stay_Operation.select(dorm_id, bed_id);
    }
}
