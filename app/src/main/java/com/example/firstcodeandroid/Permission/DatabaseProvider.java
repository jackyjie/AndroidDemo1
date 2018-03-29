package com.example.firstcodeandroid.Permission;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.firstcodeandroid.Data.MyDataBaseHelper;

public class DatabaseProvider extends ContentProvider {

    private static final int BOOK_DIR = 0;
    private static final int BOOK_ITEM = 1;
    private static final int CATEGORY_DIR = 2;
    private static final int CATEGROY_ITEM = 3;
    private static final String AUTHORITY = "com.example.databasetest.provider";
    private static UriMatcher uriMatcher;
    private MyDataBaseHelper databaseHelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "book", BOOK_DIR);
        uriMatcher.addURI(AUTHORITY, "book/#", BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY, "category", CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY, "category/#", CATEGROY_ITEM);
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new MyDataBaseHelper(getContext(), "BookStore.db", null, 5);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        // 查询数据
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                // 查询table1中所有数据
                cursor = db.query("Book",  projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case BOOK_ITEM:
                // 查询table1中单条数据
                String bookId = uri.getPathSegments().get(1);
                cursor = db.query("Book",  projection, "id=?", new String[]{bookId}, null, null, sortOrder);
                break;
            case CATEGORY_DIR:
                // 查询table2中所有数据
                cursor = db.query("Category",  projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CATEGROY_ITEM:
                // 查询table2中单条数据
                String categoryId = uri.getPathSegments().get(1);
                cursor = db.query("Category",  projection, "id=?", new String[]{categoryId}, null, null, sortOrder);
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Uri uriReturn = null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
            case BOOK_ITEM:
                long newBookId = db.insert("Book", null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/book/" + newBookId);
                break;
            case CATEGORY_DIR:
            case CATEGROY_ITEM:
                long newCategoryId = db.insert("Category", null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/category/" + newCategoryId);
                break;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int deleteRow = 0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                deleteRow = db.delete("Book", selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                deleteRow = db.delete("Book", "id=?", new String[]{bookId});
                break;
            case CATEGORY_DIR:
                deleteRow = db.delete("Category", selection, selectionArgs);
                break;
            case CATEGROY_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                deleteRow = db.delete("Category", "id=?", new String[]{categoryId});
                break;
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int updateRow = 0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                updateRow = db.update("Book", values, selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                updateRow = db.update("Book", values, "id=?", new String[]{bookId});
                break;
            case CATEGORY_DIR:
                updateRow = db.update("Category", values, selection, selectionArgs);
                break;
            case CATEGROY_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                updateRow = db.update("Category", values, "id=?", new String[] {categoryId});
                break;
        }
        return 0;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.firstcodeandroid.provider.book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.firstcodeandroid.provider.book";
            case CATEGORY_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.firstcodeandroid.provider.category";
            case CATEGROY_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.firstcodeandroid.provider.category";
            default:
                break;
        }
        return null;
    }
}
