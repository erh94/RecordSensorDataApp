package android.r173059004.RecordSensorData;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.regex.Pattern;


public class LoginFragment extends Fragment {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    EditText firstname, lastname, age, mobile,email;
    RadioGroup gender;
    Button register;


    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //oncreate is called before oncreateView so all calculations not related to UI can be done here


    } //oncreate closed here

    public static boolean isEmailAddress(EditText editText, boolean required) {
        return isValid(editText, EMAIL_REGEX, "invalid email", required);
    }

    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        if ( required && !hasText(editText) ) return false;

        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        };

        return true;
    }

    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        if (text.length() == 0) {
            editText.setError("required");
            return false;
        }

        return true;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView=inflater.inflate(R.layout.fragment_login, container, false);

        // Inflate the layout for this fragment
        firstname=(EditText)rootView.findViewById(R.id.etRegFirstName);
        lastname=(EditText)rootView.findViewById(R.id.etRegLastName);
        age=(EditText)rootView.findViewById(R.id.etAge);
        mobile=(EditText)rootView.findViewById(R.id.etMobile);
        email=(EditText)rootView.findViewById(R.id.etEmail);
        gender=(RadioGroup)rootView.findViewById(R.id.genderradioGroup);
        register =(Button)rootView.findViewById(R.id.btnRegLogin);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstname.setText("");
                lastname.setText("");
                age.setText("");
                mobile.setText("");
                email.setText("");
                gender.clearCheck();
            }
        });


        age.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(!age.getText().toString().equals("")&& Integer.parseInt(age.getText().toString())>200)
                {
                    age.setText(age.getText().toString().substring(0,3));
                }

                return false;
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            // after every change has been made to this editText, we would like to check validity
            public void afterTextChanged(Editable s) {
                isEmailAddress(email, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


        return rootView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
