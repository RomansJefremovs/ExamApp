package com.example.myapplication.Repository;
import com.example.myapplication.Model.Info;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class FirebseRepo {

    public DatabaseReference getReference() {
        DatabaseReference reference = FirebaseDatabase.getInstance("https://my-application-cb6c3-default-rtdb.firebaseio.com/").getReference("texts");
        return reference;
    }

    public void addToDatabase(String path, Info value){
        getReference().child(path).setValue(value);
    }


}
