import android.app.Application;

import com.myself.app.model.greendao.helper.GreenDaoHelper;
import com.myself.app.utils.Utils;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public class MyselfApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        GreenDaoHelper.getInstance(this, Utils.DB_NAME);
    }
}
