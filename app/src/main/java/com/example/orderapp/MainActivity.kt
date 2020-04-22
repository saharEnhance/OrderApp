package com.example.orderapp
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*

class MainActivity : AppCompatActivity() {

    private lateinit var databaseHelper: MyDBHandler
    private lateinit var adapter: OrderListAdapter
    // private var  orders : List<Order> = listOf()
    private var orders: MutableList<Order> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseHelper = MyDBHandler(this, null, null, 1)
        initRecyclerView()
    }

    private fun initRecyclerView() {

        orderList.layoutManager = LinearLayoutManager(this)
        val testData = createTestData()

        // Create the PartAdapter
        // 1st parameter: our generated testData
        // 2nd parameter: item click handler function (implemented below) as function parameter
        adapter = OrderListAdapter(testData as MutableList<Order>) { order : String -> partItemClicked(order) }
        orderList.adapter = adapter
    }

    private fun createTestData():  List<Order> = mutableListOf()

    private fun partItemClicked(order: String) {
        Toast.makeText(this, "Clicked: $order", Toast.LENGTH_LONG).show()
    }

    fun save(view: View) {
        databaseHelper.addOrder(Order(clientToAddTxt.text.toString(), dishToAddTxt.text.toString()))
        //clientToAddTxt.setText("")
        Toast.makeText(this@MainActivity, "Stored Successfully!", Toast.LENGTH_SHORT).show()

        orders = databaseHelper.getAllOrders()
      adapter.updateOrders(orders)
    }
}
