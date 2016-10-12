package coml.example.administrator.exercise23;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private final static String TAG="myTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册
        getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI,
                true,new ContactsObserver(new Handler()));
        }
        //重写OnChange
        private final class ContactsObserver extends ContentObserver {
            public ContactsObserver(Handler handler) {
                super(handler);
            }

            @Override
            public void onChange(boolean selfChange) {
                Log.v(TAG, "Contact data is changed.");
            }
        }
}
