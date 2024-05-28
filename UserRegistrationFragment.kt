import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UserRegistrationFragment extends Fragment {

    private EditText nameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText passwordEditText;
    private Button submitButton;

    private OnUserRegistrationListener listener;

    public interface OnUserRegistrationListener {
        void onUserRegistered(User user);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_registration, container, false);

        nameEditText = view.findViewById(R.id.name_edit_text);
        lastNameEditText = view.findViewById(R.id.last_name_edit_text);
        emailEditText = view.findViewById(R.id.email_edit_text);
        phoneEditText = view.findViewById(R.id.phone_edit_text);
        passwordEditText = view.findViewById(R.id.password_edit_text);
        submitButton = view.findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                User user = new User(name, lastName, email, phone, password);

                if (listener != null) {
                    listener.onUserRegistered(user);
                }
            }
        });

        return view;
    }

    public void setOnUserRegistrationListener(OnUserRegistrationListener listener) {
        this.listener = listener;
    }

    public static class User {
        private String name;
        private String lastName;
        private String email;
        private String phone;
        private String password;

        public User(String name, String lastName, String email, String phone, String password) {
            this.name = name;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.password = password;
        }

        // Getters and setters
    }
}