package nexus101.admin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import nexus101.MainActivity;
import nexus101.R;
import nexus101.admin.course.AdminCourseActivity;
import nexus101.admin.group.AdminGroupActivity;
import nexus101.admin.student.AdminStudentAccountActivity;
import nexus101.admin.teacher.AdminTeacherAccountActivity;

public class AdminProfileActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView navigation;
    private Button log_out;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_group:
                    mTextMessage.setText("Group");
                    return true;
                case R.id.navigation_course:
                    mTextMessage.setText("Course");
                    return true;
                case R.id.navigation_student_account:
                    mTextMessage.setText("Student Acc");
                    return true;
                case R.id.navigation_teacher_account:
                    mTextMessage.setText("Teacher Acc");
                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText("Profile");

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        getSupportActionBar().setTitle("Nexus 101");

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        setBottomNav();
        navigation.setSelectedItemId(R.id.navigation_profile);

        log_out = findViewById(R.id.log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("nexus101", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear().commit();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void setBottomNav(){
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navigation_group:
                        Intent intent = new Intent(getApplicationContext(), AdminGroupActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_course:
                        intent = new Intent(getApplicationContext(), AdminCourseActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_student_account:
                        intent = new Intent(getApplicationContext(), AdminStudentAccountActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_teacher_account:
                        intent = new Intent(getApplicationContext(),AdminTeacherAccountActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_profile:
                        Toast.makeText(AdminProfileActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

}
