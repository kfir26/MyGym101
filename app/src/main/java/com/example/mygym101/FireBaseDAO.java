package com.example.mygym101;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseDAO {
    public static final String USERS = "users";

    //singleton: share a single object across the entire app:
    private FireBaseDAO(){} //hide the constructor:
    public static FireBaseDAO shared = new FireBaseDAO();




//    public void saveUser(User user){
//        FirebaseDatabase.getInstance().
//                getReference(USERS).
//                push().
//                setValue(user);
//    }


public void saveUsers(User user){
    //new database listing:
    DatabaseReference newUserRef = FirebaseDatabase.getInstance().
            getReference(USERS).
            push();

    //message.setID(newMessageRef.id) (not null anymore)
    user.setUserName(newUserRef.getKey());

    //save the data:
    newUserRef.setValue(user);
    }
}
