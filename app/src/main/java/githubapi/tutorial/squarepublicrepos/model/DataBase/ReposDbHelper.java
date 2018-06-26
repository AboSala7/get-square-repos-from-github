package githubapi.tutorial.squarepublicrepos.model.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import githubapi.tutorial.squarepublicrepos.model.RepoData;

public class ReposDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "repos_db";

    public static final String TABLE_NAME = "repos";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_REPO_NAME = "repoName";
    public static final String COLUMN_REPO_OWNER = "repoOwner";
    public static final String COLUMN_REPO_DESC = "repoDesc";
    public static final String COLUMN_REPO_URL = "repoUrl";
    public static final String COLUMN_REPO_OWNER_URL = "ownerUrl";


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_REPO_NAME + " TEXT,"
                    + COLUMN_REPO_OWNER + " TEXT,"
                    + COLUMN_REPO_DESC + " TEXT,"
                    + COLUMN_REPO_URL + " TEXT,"
                    + COLUMN_REPO_OWNER_URL + " TEXT"
                    + ")";



    public ReposDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertRepo(RepoData repo) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_REPO_NAME, repo.getRepoName());
        values.put(COLUMN_REPO_OWNER, repo.getOwner());
        values.put(COLUMN_REPO_DESC, repo.getDescription());
        values.put(COLUMN_REPO_URL, repo.getRepoUrl());
        values.put(COLUMN_REPO_OWNER_URL, repo.getOwnerUrl());

        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        Log.i("DataBaseUpdated ===","true");
        return id;
    }
    public void clearDataBase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }
}