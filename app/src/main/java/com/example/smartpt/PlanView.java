package com.example.smartpt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;



public class PlanView extends AppCompatActivity {
    private Button buttonSat;
    private Button buttonSun;
    private Button buttonMon;
    private Button buttonTue;
    private Button buttonWed;
    private Button buttonFri;
    private Button buttonThu;
    private Button buttonALeart;

    private TextView TextviewEx1;
    private TextView TextviewEx2;
    private TextView TextviewEx3;


    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private DocumentReference ex1=db.collection("Exercise").document("9kfu4LzQIe8ZF9PxHTur");
    private DocumentReference ex2=db.collection("Exercise").document("2");
    private DocumentReference ex3=db.collection("Exercise").document("3");

    private static final String TAG = "PlanView";

    private static final String KEY_Name = "name";
    private static final String KEY_TARGET = "targetedMuscle";

   // private TrainingDays tDays =((TrainingDays)getApplicationContext());
    //private ArrayList<String> tDay=tDays.gettDays();
   // private TrainingDays trainingDays=new TrainingDays();
//List<String> testd=new ArrayList<>();
    //DatabaseRefernce databaseRefernce;
    //private FirebaseFirestore db;

private ArrayList<String> days=TrainingDays.gettDays();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_view);

        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),PlanView.class));
                        overridePendingTransition(0,0);
                        return true;
//                     (update profile activity)
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),updateProfile.class));
                        overridePendingTransition(0,0);
                        return true;
//
//                    case R.id.progress:
//                        startActivity(new Intent(getApplicationContext(),progress.class));
//                        overridePendingTransition(0,0);
//                        return true;
                }
                return false;
            }
        });

        LinearLayout exFrame = (LinearLayout) findViewById(R.id.ExFrame);
        buttonALeart = (Button) findViewById(R.id.alertButton);
        FrameLayout alertFrame = (FrameLayout) findViewById(R.id.alertFrame);


        //trainingDays=new TrainingDays();
        //ArrayList<String> days= trainingDays.gettDays();
        //int len=days.size();
        //ex
        TextviewEx1 = findViewById(R.id.textViewex1);
        TextviewEx2 = findViewById(R.id.textViewex2);
        TextviewEx3 = findViewById(R.id.textViewex3);



        buttonALeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.alertText);
                text.setVisibility(View.GONE);
                alertFrame.setVisibility(View.GONE);
                v.setVisibility(View.GONE);




            }
        });


        buttonMon = (Button) findViewById(R.id.buttonMon);
        buttonMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonSun.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonMon.setBackgroundColor(Color.parseColor("#24c8fe"));

                buttonMon.setTextColor(getResources().getColor(R.color.white));

                buttonTue.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonWed.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonThu.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonFri.setBackgroundColor(Color.parseColor("#f1f3fa"));


                buttonSat.setTextColor( Color.parseColor("#696969"));

                buttonSun.setTextColor( Color.parseColor("#696969"));

                buttonTue.setTextColor( Color.parseColor("#696969"));

                buttonWed.setTextColor( Color.parseColor("#696969"));

                buttonThu.setTextColor( Color.parseColor("#696969"));

                buttonFri.setTextColor( Color.parseColor("#696969"));



               for (int i=0;i<days.size();i++){
                   String day =days.get(i);
                if (day.contains("Mon")) {
                    mon.setText("My Exercises for today");
                    exFrame.setVisibility(View.VISIBLE);
                    loadEx1(v);
                    loadEx2(v);
                    loadEx3(v);
                    break;
                } else {

                    mon.setText("There is no exercises for today");
                    exFrame.setVisibility(View.INVISIBLE);
                }

            }// end for

            }
        });


        buttonSat = (Button) findViewById(R.id.buttonSat);
        buttonSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackgroundColor(Color.parseColor("#24c8fe"));

                buttonSat.setTextColor(getResources().getColor(R.color.white));

                buttonSun.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonMon.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonTue.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonWed.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonThu.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonFri.setBackgroundColor(Color.parseColor("#f1f3fa"));



                buttonMon.setTextColor( Color.parseColor("#696969"));

                buttonSun.setTextColor( Color.parseColor("#696969"));

                buttonTue.setTextColor( Color.parseColor("#696969"));

                buttonWed.setTextColor( Color.parseColor("#696969"));

                buttonThu.setTextColor( Color.parseColor("#696969"));

                buttonFri.setTextColor( Color.parseColor("#696969"));




                for (int i=0;i<days.size();i++){
                    String day =days.get(i);
                    if (day.contains("Sat")) {
                        mon.setText("My Exercises for today");
                        exFrame.setVisibility(View.VISIBLE);
                        loadEx1(v);
                        loadEx2(v);
                        loadEx3(v);
                        break;

                    } else {

                        mon.setText("There is no exercises for today");
                        exFrame.setVisibility(View.INVISIBLE);
                    }

                }// end for


            }
        });

        buttonSun = (Button) findViewById(R.id.buttonSun);
        buttonSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonSun.setBackgroundColor(Color.parseColor("#24c8fe"));
                buttonSun.setTextColor(getResources().getColor(R.color.white));

                buttonMon.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonTue.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonWed.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonThu.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonFri.setBackgroundColor(Color.parseColor("#f1f3fa"));
               
                
                buttonMon.setTextColor( Color.parseColor("#696969"));
                buttonSat.setTextColor( Color.parseColor("#696969"));

                buttonTue.setTextColor( Color.parseColor("#696969"));

                buttonWed.setTextColor( Color.parseColor("#696969"));

                buttonThu.setTextColor( Color.parseColor("#696969"));

                buttonFri.setTextColor( Color.parseColor("#696969"));



                for (int i=0;i<days.size();i++){
                    String day =days.get(i);
                    if (day.contains("Sun")) {
                        mon.setText("My Exercises for today");
                        exFrame.setVisibility(View.VISIBLE);
                        loadEx1(v);
                        loadEx2(v);
                        loadEx3(v);
                        break;

                    } else {

                        mon.setText("There is no exercises for today");
                        exFrame.setVisibility(View.INVISIBLE);
                    }

                }// end for


            }
        });
        buttonTue = (Button) findViewById(R.id.buttonTue);
        buttonTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonSun.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonMon.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonTue.setBackgroundColor(Color.parseColor("#24c8fe"));
                buttonTue.setTextColor(getResources().getColor(R.color.white));

                buttonWed.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonThu.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonFri.setBackgroundColor(Color.parseColor("#f1f3fa"));


                buttonMon.setTextColor( Color.parseColor("#696969"));

                buttonSat.setTextColor( Color.parseColor("#696969"));

                buttonSun.setTextColor( Color.parseColor("#696969"));

                buttonWed.setTextColor( Color.parseColor("#696969"));

                buttonThu.setTextColor( Color.parseColor("#696969"));

                buttonFri.setTextColor( Color.parseColor("#696969"));


                for (int i=0;i<days.size();i++){
                    String day =days.get(i);
                    if (day.contains("Tue")) {
                        mon.setText("My Exercises for today");
                        exFrame.setVisibility(View.VISIBLE);
                        loadEx1(v);
                        loadEx2(v);
                        loadEx3(v);
                        break;

                    } else {

                        mon.setText("There is no exercises for today");
                        exFrame.setVisibility(View.INVISIBLE);
                    }

                }// end for


            }
        });


        buttonWed = (Button) findViewById(R.id.buttonWed);
        buttonWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonSun.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonMon.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonTue.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonWed.setBackgroundColor(Color.parseColor("#24c8fe"));

                buttonWed.setTextColor(getResources().getColor(R.color.white));

                buttonThu.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonFri.setBackgroundColor(Color.parseColor("#f1f3fa"));



                buttonMon.setTextColor( Color.parseColor("#696969"));

                buttonSat.setTextColor( Color.parseColor("#696969"));

                buttonSun.setTextColor( Color.parseColor("#696969"));

                buttonTue.setTextColor( Color.parseColor("#696969"));

                buttonThu.setTextColor( Color.parseColor("#696969"));

                buttonFri.setTextColor( Color.parseColor("#696969"));


                for (int i=0;i<days.size();i++){
                    String day =days.get(i);
                    if (day.contains("Wed")) {
                        mon.setText("My Exercises for today");
                        exFrame.setVisibility(View.VISIBLE);
                        loadEx1(v);
                        loadEx2(v);
                        loadEx3(v);
                        break;

                    } else {

                        mon.setText("There is no exercises for today");
                        exFrame.setVisibility(View.INVISIBLE);
                    }

                }// end for


            }
        });

        buttonThu = (Button) findViewById(R.id.buttonThu);
        buttonThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonSun.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonMon.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonTue.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonWed.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonThu.setBackgroundColor(Color.parseColor("#24c8fe"));

                buttonThu.setTextColor(getResources().getColor(R.color.white));

                buttonFri.setBackgroundColor(Color.parseColor("#f1f3fa"));


                buttonMon.setTextColor( Color.parseColor("#696969"));

                buttonSat.setTextColor( Color.parseColor("#696969"));

                buttonSun.setTextColor( Color.parseColor("#696969"));

                buttonTue.setTextColor( Color.parseColor("#696969"));

                buttonWed.setTextColor( Color.parseColor("#696969"));

                buttonFri.setTextColor( Color.parseColor("#696969"));


                for (int i=0;i<days.size();i++){
                    String day =days.get(i);
                    if (day.contains("Thu")) {
                        mon.setText("My Exercises for today");
                        exFrame.setVisibility(View.VISIBLE);
                        loadEx1(v);
                        loadEx2(v);
                        loadEx3(v);
                        break;

                    } else {

                        mon.setText("There is no exercises for today");
                        exFrame.setVisibility(View.INVISIBLE);
                    }

                }// end for


            }
        });

        buttonFri = (Button) findViewById(R.id.buttonFri);
        buttonFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonSun.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonMon.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonTue.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonWed.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonThu.setBackgroundColor(Color.parseColor("#f1f3fa"));

                buttonFri.setBackgroundColor(Color.parseColor("#24c8fe"));

                buttonFri.setTextColor(getResources().getColor(R.color.white));

                buttonMon.setTextColor( Color.parseColor("#696969"));

                buttonSat.setTextColor( Color.parseColor("#696969"));

                buttonSun.setTextColor( Color.parseColor("#696969"));

                buttonTue.setTextColor( Color.parseColor("#696969"));

                buttonWed.setTextColor( Color.parseColor("#696969"));

                buttonThu.setTextColor( Color.parseColor("#696969"));


                for (int i=0;i<days.size();i++){
                    String day =days.get(i);
                    if (day.contains("Fri")) {
                        mon.setText("My Exercises for today");
                        exFrame.setVisibility(View.VISIBLE);
                        loadEx1(v);
                        loadEx2(v);
                        loadEx3(v);
                        break;

                    } else {

                        mon.setText("There is no exercises for today");
                        exFrame.setVisibility(View.INVISIBLE);
                    }

                }// end for


            }
        });

    }

//               Data Exercise

    public void loadEx1(View v){
        ex1.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            String name =documentSnapshot.getString(KEY_Name);
                            String target=documentSnapshot.getString(KEY_TARGET);

                            TextviewEx1.setText(name+"\n"+"Targe Muscle: "+target);

                        }else {
                            Toast.makeText(PlanView.this,"Document not exist",Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PlanView.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());

                    }
                });


    }


    public void loadEx2(View v) {
        ex2.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String name = documentSnapshot.getString(KEY_Name);
                            String target = documentSnapshot.getString(KEY_TARGET);

                            TextviewEx2.setText(name + "\n" + "Targe Muscle: " + target);

                        } else {
                            Toast.makeText(PlanView.this, "Document not exist", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PlanView.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());

                    }
                });
    }


        public void loadEx3(View v){
            ex3.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()){
                                String name =documentSnapshot.getString(KEY_Name);
                                String target=documentSnapshot.getString(KEY_TARGET);

                                TextviewEx3.setText(name+"\n"+"Targe Muscle: "+target);

                            }else {
                                Toast.makeText(PlanView.this,"Document not exist",Toast.LENGTH_SHORT).show();
                            }

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(PlanView.this, "Error!", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, e.toString());

                        }
                    });


        }









}