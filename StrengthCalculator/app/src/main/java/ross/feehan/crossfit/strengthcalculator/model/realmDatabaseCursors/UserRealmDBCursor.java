package ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import ross.feehan.crossfit.strengthcalculator.model.objects.User;

/**
 * Created by Ross Feehan on 01/05/2015.
 * Copyright Ross Feehan
 */
public class UserRealmDBCursor {

    public static User getUserDetails(Context ctx){

        User userDetails;
        Realm realm = Realm.getInstance(ctx);

        RealmQuery query = realm.where(User.class);
        RealmObject userRealmObject = query.findFirst();

        return userDetails= (User)userRealmObject;
    }

    public static void setUserDetails(Context ctx, User user){

        Realm realm = Realm.getInstance(ctx);

        realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();
    }
}
