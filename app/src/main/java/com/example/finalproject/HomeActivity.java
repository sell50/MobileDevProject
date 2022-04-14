package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore = 0, questionsAttempted = 1, currentPos, quizChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizChoice = getIntent().getIntExtra("QUIZ CHOICE", 1);
        quizModelArrayList = new ArrayList<>();
        random = new Random();

        if (quizChoice == 1) getQuiz1Question(quizModelArrayList);
        else if (quizChoice == 2) getQuiz2Question(quizModelArrayList);
        else if (quizChoice == 3) getQuiz3Question(quizModelArrayList);

        currentScore = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }


        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(HomeActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        Button quizMenuBtn = bottomSheetView.findViewById(R.id.idBtnMenu);
        Button signoutBtn = bottomSheetView.findViewById(R.id.idBtnSignOut);
        scoreTV.setText("Your score is\n"+currentScore + "/10"); //change if number of questions change

        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questionsAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });

        quizMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuizMenuActivity.class);
                startActivity(intent);
            }
        });

        signoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    private void setDataToViews(int currentPos){
        questionNumberTV.setText("Questions Attempted: "+questionsAttempted + "/10" ); //change if number of questions change
        if(questionsAttempted == 10){
            showBottomSheet();
        }
        else{
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuiz1Question(ArrayList<QuizModel> quizModelArrayList){ //questions, options, and answers stored here. can add more if needed
        quizModelArrayList.add(new QuizModel("What languages does Android Studio support?","Java, Kotlin & C++", "python", "PHP", "Swift", "Java, Kotlin & C++"));
        quizModelArrayList.add(new QuizModel("Which folder do you copy and paste an image into?","Java", "Resources", "Layout", "Drawable", "Drawable"));
        quizModelArrayList.add(new QuizModel("How to pass the data between activities in Android?","Intent", "Content Provider", "Broadcast Receiver", "None of the above", "Intent"));
        quizModelArrayList.add(new QuizModel("What is DDMS in android?","Dalvik memory server", "Device memory server", "Dalvik monitoring services", "Dalvik debug monitor services", "Dalvik debug monitor services"));
        quizModelArrayList.add(new QuizModel("Android is developed by?","Google", "Android Inc", "Microsoft", "Apple", "Android Inc"));
        quizModelArrayList.add(new QuizModel("What does AAPT stand for?","Android Asset Processing Tool", "Android Asset Providing Tool", "Android Asset Packaging Tool", "Android Asset Technique", "Android Asset Packaging Tool"));
        quizModelArrayList.add(new QuizModel("Android is based off which Kernel?","Linux", "Windows", "Mac", "Redhat", "Linux"));
        quizModelArrayList.add(new QuizModel("What is the latest version of android?","Android 8", "Android 12", "Android 10", "Android 11", "Android 12"));
        quizModelArrayList.add(new QuizModel("The package of compiled Java codes with some other resources is called?","IDE", "APK", "JDK", "IDE", "APK"));
        quizModelArrayList.add(new QuizModel("The property that is used for formatting font is?","Color", "typeface", "ImageView", "Mip Map", "typeface"));
    }

    private void getQuiz2Question(ArrayList<QuizModel> quizModelArrayList) { //questions, options, and answers stored here. can add more if needed
        quizModelArrayList.add(new QuizModel("When was Apple founded?", "1985", "1976", "2001", "None of the above", "1976"));
        quizModelArrayList.add(new QuizModel("Which U.S. state is Apple headquarters?", "New York", "Washington", "California", "None of the above", "California"));
        quizModelArrayList.add(new QuizModel("Which person is one of the founders of Apple?", "Steve Jobs", "Mark Zuckerberg", "Larry Page", "Tim Cook", "Steve Jobs"));
        quizModelArrayList.add(new QuizModel("How many logos has Apple used?","4", "6", "3", "1", "4"));
        quizModelArrayList.add(new QuizModel("When was the first iPhone released?","2007", "2009", "2002", "1997", "2007"));
        quizModelArrayList.add(new QuizModel("Who is the CEO of Apple?","Jeff Williams", "Tim Cook", "Luca Maestri", "Mark Zuckerberg", "Tim Cook"));
        quizModelArrayList.add(new QuizModel("Approximately how many retail stores are there worldwide?","500", "1200", "2400", "100", "500"));
        quizModelArrayList.add(new QuizModel("What was Apple's first product?","Macintosh", "iPod", "Apple I", "Apple II", "Apple I"));
        quizModelArrayList.add(new QuizModel("Which year did Steve Jobs die?","2011", "2013", "2010", "2012", "2011"));
        quizModelArrayList.add(new QuizModel("When was the first iPad released?","2008", "2012", "2010", "2011", "2010"));
    }

    private void getQuiz3Question(ArrayList<QuizModel> quizModelArrayList) { //questions, options, and answers stored here. can add more if needed
        quizModelArrayList.add(new QuizModel("Google was founded by Larry Page and who else?","Steve Jobs", "Terry Winograd", "Bill Gates", "Sergey Brin", "Sergey Brin"));
        quizModelArrayList.add(new QuizModel("The name \"Google\" originated from a misspelling of:","Goolink", "Googad", "Googol", "Goosearch", "Googol"));
        quizModelArrayList.add(new QuizModel("In January of 1996, shortly before the launch of Google, a new search engine was brought into existence. What was this search engine called?","BackUp", "BackLinks", "BackRub", "BreakUp", "BackRub"));
        quizModelArrayList.add(new QuizModel("The domain name www.google.com was registered on:","September 7, 1996", "January 12, 1998", "September 15, 1997", "August 7, 1999", "September 15, 1997"));
        quizModelArrayList.add(new QuizModel("In 1998, when Google.com was still in beta, they were answering up to how many search queries a day?","10,000", "80,000", "30,000", "450,000", "10,000"));
        quizModelArrayList.add(new QuizModel("At which university did the Google founders meet?","Oxford University", "MIT", "Stanford University", "Delhi University", "Stanford University"));
        quizModelArrayList.add(new QuizModel("Which search operator does Google enable by default?","The AND operator", "The OR operator", "The NOT operator","Google Operator", "Google Operator"));
        quizModelArrayList.add(new QuizModel("Google's informal corporate motto or slogan is?","\"Always First \"", "\"Don't Be Evil\"", "\"Experience the Difference\"", "\"Turning the page\"", "\"Don't Be Evil\""));
        quizModelArrayList.add(new QuizModel("Google received its first funding from Andy Bechtolscheim, a co-founder of Sun Microsystems. How much was this?","$150,000", "$200,000", "$400,000", "$100,000", "$100,000"));
        quizModelArrayList.add(new QuizModel("What year was Google founded in?","1996", "1998", "2000", "1989", "1998"));
    }
}