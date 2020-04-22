package com.example.orderapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDBHandler(
    context: MainActivity, name: String?,
    factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "ordersDB.db"
        val TABLE_ORDERS = "orders"
        val COLUMN_ID = "_id"
        val COLUMN_CLIENT = "word"
        val COLUMN_DISH = "name"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_ORDERS_TABLE = ("CREATE TABLE $TABLE_ORDERS ($COLUMN_ID INTEGER PRIMARY KEY,$COLUMN_CLIENT  CLIENT,$COLUMN_DISH  DISH )")
        db.execSQL(CREATE_ORDERS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ORDERS")
        onCreate(db)
    }

    fun addOrder(order: Order) {
        val values = ContentValues()
        values.put(COLUMN_CLIENT, order.client)
        values.put(COLUMN_DISH, order.dish)

        val db = this.writableDatabase

        db.insert(TABLE_ORDERS, null, values)
        db.close()
    }

    fun getAllOrders(): MutableList<Order> {
        val query =
            "SELECT * FROM $TABLE_ORDERS"

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null )

        val orders: MutableList<Order> = mutableListOf()

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast) {
                orders.get(index = 1)

            }
        }
        db.close()
        return orders
    }
}
