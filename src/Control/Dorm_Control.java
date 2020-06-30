package Control;

import Model.Dorm_Model;
import Operation.Dorm_Operation;

public class Dorm_Control {
    public void update(Dorm_Model dModel) throws Exception {
        Dorm_Operation dorm_Operation = new Dorm_Operation();
        dorm_Operation.updateDorm(dModel);
    }

    public Dorm_Model get(String dorm_id) throws Exception {
        Dorm_Operation dorm_Operation = new Dorm_Operation();
        return dorm_Operation.select(dorm_id);
    }
}