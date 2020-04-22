package com.example.orderapp
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*

class MainActivity : AppCompatActivity() {

    private lateinit var databaseHelper: MyDBHandler
    private lateinit var adapter: OrderListAdapter
     private var  orders : List<Order> = listOf()
    //private var orders: MutableList<Order> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseHelper = MyDBHandler(this, null, null, 1)
        initRecyclerView()
    }

    private fun initRecyclerView() {


       //orders.layoutManager = LinearLayoutManager(this)
        val testData = createTestData()

        // Create the PartAdapter
        // 1st parameter: our generated testData
        // 2nd parameter: item click handler function (implemented below) as function parameter
        adapter = OrderListAdapter(orders) { order : String -> partItemClicked(order) }
        //orders.adapter = adapter
    }

    private fun createTestData():  List<Order> = mutableListOf(Order("pizza", "John Doe"))

    private fun partItemClicked(word: String) {
        Toast.makeText(this, "Clicked: $word", Toast.LENGTH_LONG).show()
    }

    fun save(view: View) {
        databaseHelper.addOrder(Order(clientTxt.text.toString(), dishTxt.text.toString()))
        wordToAddTxt.setText("")
        Toast.makeText(this@MainActivity, "Stored Successfully!", Toast.LENGTH_SHORT).show()

        orders = databaseHelper.getAllOrders() as MutableList<Order>
      adapter.updateOrders(orders)
    }
}
