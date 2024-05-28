import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements UserRegistrationFragment.OnUserRegistrationListener {

    private TextView nameTextView;
    private TextView lastNameTextView;
    private TextView emailTextView;
    private TextView phoneTextView;
    private TextView passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.name_text_view);
        lastNameTextView = findViewById(R.id.last_name_text_view);
        emailTextView = findViewById(R.id.email_text_view);
        phoneTextView = findViewById(R.id.phone_text_view);
        passwordTextView = findViewById(R.id.password_text_view);

        UserRegistrationFragment userRegistrationFragment = new UserRegistrationFragment();
        userRegistrationFragment.setOnUserRegistrationListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, userRegistrationFragment)
                .commit();
    }

    @Override
    public void onUserRegistered(UserRegistrationFragment.User user) {
        nameTextView.setText(user.getName());
        lastNameTextView.setText(user.getLastName());
        emailTextView.setText(user.getEmail());
        phoneTextView.setText(user.getPhone());
        passwordTextView.setText(user.getPassword());
    }
}