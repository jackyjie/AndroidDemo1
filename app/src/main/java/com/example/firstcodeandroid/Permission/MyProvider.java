package com.example.firstcodeandroid.Permission;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.Nullable;

/**
 * Created by JackR on 2018/3/26.
 */

public class MyProvider extends ContentProvider {

    private static final int TABLE1_DIR = 0;
    private static final int TABLE1_ITEM = 1;
    private static final int TABLE2_DIR = 2;
    private static final int TABLE2_ITEM = 3;
    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.firstcodeandroid.provider", "tabel1", TABLE1_DIR);
        uriMatcher.addURI("com.example.firstcodeandroid.provider", "tabel1/#", TABLE1_ITEM);
        uriMatcher.addURI("com.example.firstcodeandroid.provider", "tabel2", TABLE2_DIR);
        uriMatcher.addURI("com.example.firstcodeandroid.provider", "tabel2/#", TABLE2_ITEM);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                // 查询table1中所有数据
                break;
            case TABLE1_ITEM:
                // 查询table1中单条数据
                break;
            case TABLE2_DIR:
                // 查询table2中所有数据
                break;
            case TABLE2_ITEM:
                // 查询table2中单条数据
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                // 查询table1中所有数据
                break;
            case TABLE1_ITEM:
                // 查询table1中单条数据
                break;
            case TABLE2_DIR:
                // 查询table2中所有数据
                break;
            case TABLE2_ITEM:
                // 查询table2中单条数据
                break;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                // 查询table1中所有数据
                break;
            case TABLE1_ITEM:
                // 查询table1中单条数据
                break;
            case TABLE2_DIR:
                // 查询table2中所有数据
                break;
            case TABLE2_ITEM:
                // 查询table2中单条数据
                break;
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                // 查询table1中所有数据
                break;
            case TABLE1_ITEM:
                // 查询table1中单条数据
                break;
            case TABLE2_DIR:
                // 查询table2中所有数据
                break;
            case TABLE2_ITEM:
                // 查询table2中单条数据
                break;
        }
        return 0;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.firstcodeandroid.provider/table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.firstcodeandroid.provider/table1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.firstcodeandroid.provider/table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.firstcodeandroid.provider/table2";
            default:
                break;
        }
        return null;
    }
}
