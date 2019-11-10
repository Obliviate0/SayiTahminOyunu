package com.example.sayitahminoyunu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database extends SQLiteOpenHelper {

    private static final ReadWriteLock rwLock = new ReentrantReadWriteLock(true);

    public Database(Context context) {
        super(context, "highScores", null, 1);
    }

    private static void beginReadLock() {
        rwLock.readLock().lock();
    }

    private static void endReadLock() {
        rwLock.readLock().unlock();
    }

    private static void beginWriteLock() {
        rwLock.writeLock().lock();
    }

    private static void endWriteLock() {
        rwLock.writeLock().unlock();
    }


    private static final String DROP_SCORES_TABLE = "DROP TABLE IF EXISTS _scores";
    private static final String CREATE_SCORES_TABLE = "CREATE TABLE IF NOT EXISTS _scores (_id INTEGER PRIMARY KEY, _score INTEGER, _date TEXT)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DROP_SCORES_TABLE);
        db.execSQL(CREATE_SCORES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void addRecord(ExpenseModel model) {
        SQLiteDatabase db = null;
        try {
            beginWriteLock();
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("_score", model.getScore());
            values.put("_date", model.getDate());
            db.insert("_scores", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                try {
                    if (db.isOpen()) {
                        db.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                endWriteLock();
            }
        }
    }

    //Listeleme
    public ArrayList<ExpenseModel> getAllRecords() {
        SQLiteDatabase db = null;
        ArrayList<ExpenseModel> modelList = new ArrayList<>();
        try {
            beginReadLock();
            db = this.getReadableDatabase();
            Cursor cursor = db.query(
                    "_scores",
                    new String[]{"_score", "_date"},
                    null,
                    null,
                    null,
                    null,
                    "_date DESC"
            );
            if (cursor != null && !cursor.isClosed() && cursor.moveToFirst()) {
                do {
                    modelList.add(new ExpenseModel(
                            cursor.getInt(cursor.getColumnIndex("_id")),
                            cursor.getInt(cursor.getColumnIndex("_score")),
                            cursor.getString(cursor.getColumnIndex("_date"))
                    ));
                } while (cursor.moveToNext());
            }
            assert cursor != null;
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                try {
                    if (db.isOpen()) {
                        db.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                endReadLock();
            }
        }

        return modelList;
    }
}
