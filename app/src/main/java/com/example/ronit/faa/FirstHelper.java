package com.example.ronit.faa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RONIT on 11/2/2016.
 */

public class FirstHelper extends SQLiteOpenHelper {
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    private static final String DATABASE_NAME="first";
    private static final String TABLE_NAME="info";
    private static final int DATABASE_VERSION=1;
    private static final String UID="_id";
    private static final String NAME="name";
    private static final String DETAIL="detail";
   // private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME+";";
    //private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+DETAIL+" LONGTEXT);";
    private Context context;
    FirstHelper firstHelper;

    public FirstHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
       // Message.message(context, "constructor called");*/
       // firstHelper=new FirstHelper(context);
    }
    public String getAllData() {
        SQLiteDatabase db= firstHelper.getWritableDatabase();
        String[] columns={FirstHelper.UID, FirstHelper.NAME, FirstHelper.DETAIL};
        Cursor cursor=db.query(FirstHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer=new StringBuffer();
        while(cursor.moveToNext()) {
            //int index1 =cursor.getColumnIndex(FirstHelper.UID);
            //int cid=cursor.getInt(index1);
            int cid=cursor.getInt(0);
            String name=cursor.getString(1);
            String detail=cursor.getString(2);
            buffer.append(cid+" "+name+" "+detail+"\n");

        }
        return buffer.toString();
    }
    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    //@Override
    public void onCreate(SQLiteDatabase db) {

        /*try{
            db.execSQL(CREATE_TABLE);
            Message.message(context, "onCreate called");
        }catch(SQLException e){
            Message.message(context,""+e);
        }*/
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    //@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*try {
            Message.message(context, "onUpgrade called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (SQLException e){

            Message.message(context,""+e);
        }*/

    }
}
