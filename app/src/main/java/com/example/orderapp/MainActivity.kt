package com.example.orderapp
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_person.*

class MainActivity : AppCompatActivity() {

    lateinit var databaseHelper: MyDBHandler
    lateinit var adapter: OrderListAdapter
    private var  orders : List<Order> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseHelper = MyDBHandler(this, null, null, 1)
        initRecyclerView()
    }

    private fun initRecyclerView() {

        wordList.layoutManager = LinearLayoutManager(this)
        val testData = createTestData()

        // Create the PartAdapter
        // 1st parameter: our generated testData
        // 2nd parameter: item click handler function (implemented below) as function parameter
        adapter = OrderListAdapter(orders) { person : String -> partItemClicked(person) }
        wordList.adapter = adapter
    }

    private fun createTestData(): MutableList<Word> = mutableListOf(Word("word1"))

    private fun partItemClicked(word: String) {
        Toast.makeText(this, "Clicked: $word", Toast.LENGTH_LONG).show()
    }

    fun save(view: View) {
        databaseHelper.addPerson(Order(nameTxt.text.toString(), ageTxt.text.toString()))
        wordToAddTxt.setText("")
        Toast.makeText(this@MainActivity, "Stored Successfully!", Toast.LENGTH_SHORT).show()

        orders = databaseHelper.getAllPeople()
       // adapter.updatePeople()
    }
}
