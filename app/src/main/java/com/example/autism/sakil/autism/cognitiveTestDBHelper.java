package com.example.autism.sakil.autism;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class cognitiveTestDBHelper extends SQLiteOpenHelper {
    private List<cognitiveQuestion> questionArrayList;
    private List<VerbalQuestion> verbalQuestionList;
    private List<ASDTestQuestion> ASDQuestionList;
    private List<CareCenterProfile> careCenterProfileList;

    public static String DATABASE_QUESTION = "autismQuestions.db";
    // Current version of database
    private static final int DATABASE_VERSION = 1;
    // Database table name for Cognitive Test
    private static final String TABLE_QUESTION = "CoginitiveTest";
    // All fields used in database table Cognitive and Verbal Test except questionTmg in verbal test
    private static final String KEY_ID = "id";
    private static final String QUESTION = "question";
    private static final String QUESTION_IMG = "questionImg"; //Only for cognitive Test
    private static final String CHOICE1 = "choice1";
    private static final String CHOICE2 = "choice2";
    private static final String CHOICE3 = "choice3";
    private static final String CHOICE4 = "choice4";
    private static final String ANSWER = "answer";


    //ASD Test Table
    private static final String TABLE_ASD_TEST = "ASDTest";
    private static final String WEIGHT1 = "weight1";
    private static final String WEIGHT2 = "weight2";
    private static final String WEIGHT3 = "weight3";
    private static final String WEIGHT4 = "weight4";




    //Verbal Test Table
    private static final String TABLE_VERBAL_QUESTION = "VerbalTest";

    //Care Center Table
    private static final String TABLE_CARE_CENTER = "CareCenter";
    private static final String NAME = "name";
    private static final String CONTACT = "contact";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String ABOUT = "about";


    // cognitiveQuestion Table Create Query in this string
    private static final String CREATE_TABLE_QUESTION = "CREATE TABLE IF NOT EXISTS "
            + TABLE_QUESTION + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + " TEXT,"
            + QUESTION_IMG + " INTEGER, "
            + CHOICE1 + " INTEGER, " + CHOICE2 + " INTEGER, " + CHOICE3 + " INTEGER, "
            + CHOICE4 + " INTEGER, " + ANSWER + " INTEGER);";

    //VerbalQuestion Table Create Query in this String
    private static final String CREATE_TABLE_VERBAL = "CREATE TABLE IF NOT EXISTS "
            + TABLE_VERBAL_QUESTION + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + " TEXT,"
            + CHOICE1 + " TEXT, " + CHOICE2 + " TEXT, " + CHOICE3 + " TEXT, "
            + CHOICE4 + " TEXT, " + ANSWER + " INTEGER);";

    //ASD Test Table Create Query
    private static final String CREATE_TABLE_ASD = "CREATE TABLE IF NOT EXISTS "
            + TABLE_ASD_TEST + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + " TEXT,"
            + CHOICE1 + " TEXT, " + CHOICE2 + " TEXT, " + CHOICE3 + " TEXT, "
            + CHOICE4 + " TEXT, "
            + WEIGHT1 + " INTEGER, " + WEIGHT2 + " INTEGER, " + WEIGHT3 + " INTEGER, " + WEIGHT4 + " INTEGER);";

    //Care Center Table Create query
    private static final String CREATE_TABLE_CARE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_CARE_CENTER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT,"
            + CONTACT + " TEXT, " + EMAIL + " TEXT, "
            + ADDRESS + " TEXT, " + ABOUT + " TEXT);";


    public cognitiveTestDBHelper(Context context) {
        super(context, DATABASE_QUESTION, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CARE);
        db.execSQL(CREATE_TABLE_ASD);
        db.execSQL(CREATE_TABLE_QUESTION);
        db.execSQL(CREATE_TABLE_VERBAL);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '"+ CREATE_TABLE_QUESTION +"'");
        db.execSQL("DROP TABLE IF EXISTS '"+ CREATE_TABLE_VERBAL +"'");
        db.execSQL("DROP TABLE IF EXISTS '"+ CREATE_TABLE_ASD +"'");
        db.execSQL("DROP TABLE IF EXISTS '"+ CREATE_TABLE_CARE +"'");// drop table if exists
        onCreate(db);
    }
    // Add Cognitive Question
    public long addInitialQuestion (cognitiveQuestion question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(QUESTION, question.getQuestion());
        values.put(QUESTION_IMG, question.getQuestionImg());
        values.put(CHOICE1, question.getChoice(1));
        values.put(CHOICE2, question.getChoice(2));
        values.put(CHOICE3,  question.getChoice(3));
        values.put(CHOICE4,  question.getChoice(4));
        values.put(ANSWER, question.getAnswer());
        // insert row in question table
        long insert = db.insert(TABLE_QUESTION, null, values);
        return insert;
    }
    //Add verbal question
    public long addInitialVerbalQuestion(VerbalQuestion question)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QUESTION, question.getQuestion());
        values.put(CHOICE1, question.getChoice(1));
        values.put(CHOICE2, question.getChoice(2));
        values.put(CHOICE3,  question.getChoice(3));
        values.put(CHOICE4,  question.getChoice(4));
        values.put(ANSWER, question.getAnswer());
        long insert = db.insert(TABLE_VERBAL_QUESTION,null,values);
        return insert;
    }

    //Add ASD Test Question
    public long addInitialASDQuestion(ASDTestQuestion question)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QUESTION, question.getQuestion());
        values.put(CHOICE1, question.getChoice(1));
        values.put(CHOICE2, question.getChoice(2));
        values.put(CHOICE3,  question.getChoice(3));
        values.put(CHOICE4,  question.getChoice(4));
        values.put(WEIGHT1,  question.getWeight(1));
        values.put(WEIGHT2,  question.getWeight(2));
        values.put(WEIGHT3,  question.getWeight(3));
        values.put(WEIGHT4,  question.getWeight(4));

        long insert = db.insert(TABLE_ASD_TEST,null,values);
        return insert;
    }

    //Add Care Center
    public long addInitialCareCenter(CareCenterProfile profile)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, profile.getName());
        values.put(CONTACT, profile.getContact());
        values.put(EMAIL, profile.getEmail());
        values.put(ADDRESS,  profile.getAddress());
        values.put(ABOUT,  profile.getAbout());
        long insert = db.insert(TABLE_CARE_CENTER,null,values);
        return insert;
    }
    // Get Cognitive question
    public List<cognitiveQuestion> getAllQuestionsList(List<cognitiveQuestion> list) {
        questionArrayList = list;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION+" ORDER BY random() LIMIT 10";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all records and adding to the list
        if (c.moveToFirst()) {
            do {
                cognitiveQuestion question = new cognitiveQuestion();

                String questText= c.getString(c.getColumnIndex(QUESTION));
                question.setQuestion(questText);
                Integer questionImg= c.getInt(c.getColumnIndex(QUESTION_IMG));
                question.setQuestionImg(questionImg);

                Integer choice1= c.getInt(c.getColumnIndex(CHOICE1));
                question.setChoice(1,choice1);

                Integer choice2= c.getInt(c.getColumnIndex(CHOICE2));
                question.setChoice(2,choice2);

                Integer choice3= c.getInt(c.getColumnIndex(CHOICE3));
                question.setChoice(3,choice3);

                Integer choice4= c.getInt(c.getColumnIndex(CHOICE4));
                question.setChoice(4,choice4);

                int answerText= c.getInt(c.getColumnIndex(ANSWER));
                question.setAnswer(answerText);

                // adding to Questions list
                questionArrayList.add(question);
            } while (c.moveToNext());
            Collections.shuffle(questionArrayList);
        }
        return questionArrayList;
    }
    // Get verbal Question
    public List<VerbalQuestion> getAllVerbalQuestionsList(List<VerbalQuestion> list) {
        verbalQuestionList = list;
        String selectQuery = "SELECT  * FROM " + TABLE_VERBAL_QUESTION +" ORDER BY random() LIMIT 10";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all records and adding to the list
        if (c.moveToFirst()) {
            do {
                VerbalQuestion question = new VerbalQuestion();

                String questText= c.getString(c.getColumnIndex(QUESTION));
                question.setQuestion(questText);

                String choice1= c.getString(c.getColumnIndex(CHOICE1));
                question.setChoice(1,choice1);

                String choice2= c.getString(c.getColumnIndex(CHOICE2));
                question.setChoice(2,choice2);

                String choice3= c.getString(c.getColumnIndex(CHOICE3));
                question.setChoice(3,choice3);

                String choice4= c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(4,choice4);

                int answerText= c.getInt(c.getColumnIndex(ANSWER));
                question.setAnswer(answerText);

                // adding to Questions list
                verbalQuestionList.add(question);
            } while (c.moveToNext());
            Collections.shuffle(verbalQuestionList);
        }
        return verbalQuestionList;
    }

    public List<ASDTestQuestion> getAllASDQuestionsList(List<ASDTestQuestion> list) {
        ASDQuestionList = list;
        String selectQuery = "SELECT  * FROM " + TABLE_ASD_TEST +" ORDER BY random() LIMIT 8";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all records and adding to the list
        if (c.moveToFirst()) {
            do {
                ASDTestQuestion question = new ASDTestQuestion();

                String questText= c.getString(c.getColumnIndex(QUESTION));
                question.setQuestion(questText);

                String choice1= c.getString(c.getColumnIndex(CHOICE1));
                question.setChoice(1,choice1);

                String choice2= c.getString(c.getColumnIndex(CHOICE2));
                question.setChoice(2,choice2);

                String choice3= c.getString(c.getColumnIndex(CHOICE3));
                question.setChoice(3,choice3);

                String choice4= c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(4,choice4);

                Integer weight1= c.getInt(c.getColumnIndex(WEIGHT1));
                question.setWeight(1,weight1);

                Integer weight2= c.getInt(c.getColumnIndex(WEIGHT2));
                question.setWeight(2,weight2);

                Integer weight3= c.getInt(c.getColumnIndex(WEIGHT3));
                question.setWeight(3,weight3);

                Integer weight4= c.getInt(c.getColumnIndex(WEIGHT4));
                question.setWeight(4,weight4);

                // adding to Questions list
                ASDQuestionList.add(question);
            } while (c.moveToNext());
            Collections.shuffle(ASDQuestionList);
        }
        return ASDQuestionList;
    }


    public List<CareCenterProfile> getAllCareCenterProfile(List<CareCenterProfile> list) {
        careCenterProfileList = list;
        String selectQuery = "SELECT  * FROM " + TABLE_CARE_CENTER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all records and adding to the list
        if (c.moveToFirst()) {
            do {
                CareCenterProfile profile = new CareCenterProfile();

                String name = c.getString(c.getColumnIndex(NAME));
                profile.setName(name);

                String contact= c.getString(c.getColumnIndex(CONTACT));
                profile.setContact(contact);

                String email= c.getString(c.getColumnIndex(EMAIL));
                profile.setEmail(email);
                    String address= c.getString(c.getColumnIndex(ADDRESS));
                profile.setAddress(address);
                String about= c.getString(c.getColumnIndex(ABOUT));
                profile.setAbout(about);

                // adding to Questions list
                careCenterProfileList.add(profile);
            } while (c.moveToNext());

        }
        return careCenterProfileList;
    }

    public boolean isCareCenterEmpty()
    {
        String selectQuery = "SELECT  count(*) FROM " + TABLE_CARE_CENTER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        c.moveToFirst();
        int cnt = c.getInt(0);
        if(cnt>0)
            return false;
        else
            return true;

    }
}
