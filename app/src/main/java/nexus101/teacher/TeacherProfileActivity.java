package nexus101.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import nexus101.NotificationActivity;
import nexus101.R;

public class TeacherProfileActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_attendance:
                    mTextMessage.setText(R.string.title_attendance);
                    return true;
                case R.id.navigation_notification:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        getSupportActionBar().setTitle("Profile");

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        setBottomNav();
        navigation.setSelectedItemId(R.id.navigation_profile);
    }

    private void setBottomNav() {
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navigation_home:
                        Intent intent = new Intent(getApplicationContext(),TeacherHomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_attendance:
                        intent = new Intent(getApplicationContext(), TeacherAttendanceCourseSelectActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_notification:
                        intent = new Intent(getApplicationContext(), NotificationActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_profile:
                        Toast.makeText(TeacherProfileActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), TeacherHomeActivity.class);
        startActivity(intent);
    }
}
