package me.app.sportigov4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


public class profileActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText shortBio;
    private EditText phoneNum;
    private ImageButton uploadPic;
    private Button saveBtn;
    private StorageReference mStorage;
    private DatabaseReference myDatabase;
    private static final int picIntent = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_screen);

        firstName = (EditText) findViewById(R.id.firstNameEt);
        lastName = (EditText) findViewById(R.id.lastNameEt);
        shortBio = (EditText) findViewById(R.id.shortBioEt);
        phoneNum = (EditText) findViewById(R.id.phoneEt);
        uploadPic = (ImageButton) findViewById(R.id.profileImage);
        saveBtn = (Button) findViewById(R.id.saveProfileBtn);

        mStorage = FirebaseStorage.getInstance().getReference();
        myDatabase = FirebaseDatabase.getInstance().getReference();
    }
    public void selectImage(View v){
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityForResult(i,picIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        firstName = (EditText) findViewById(R.id.firstNameEt);
        if(requestCode == picIntent && resultCode == RESULT_OK){
            Uri picUri = data.getData();
            StorageReference filePath = mStorage.child("ProfilePics").child(firstName.getText().toString().trim());
            filePath.putFile(picUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(profileActivity.this, "Upload done", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public void saveProfile(View v){
        String fname = firstName.getText().toString().trim();
        String lname = lastName.getText().toString().trim();
        String bio = shortBio.getText().toString().trim();
        String num = phoneNum.getText().toString().trim();
        String eventIds ="";
        UserData uData = new UserData(fname,lname,bio,num, eventIds);
        myDatabase.child("user_data").push().setValue(uData);

    }
}
