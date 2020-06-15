package com.rajkumarrajan.mvvm_architecture.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajkumarrajan.mvvm_architecture.R
import com.rajkumarrajan.mvvm_architecture.data.api.ApiHelper
import com.rajkumarrajan.mvvm_architecture.data.api.ApiServiceImpl
import com.rajkumarrajan.mvvm_architecture.data.model.Customer
import com.rajkumarrajan.mvvm_architecture.ui.base.ViewModelFactory
import com.rajkumarrajan.mvvm_architecture.ui.base.ViewModelFactory2
import com.rajkumarrajan.mvvm_architecture.ui.main.adapter.MainAdapter
import com.rajkumarrajan.mvvm_architecture.ui.main.adapter.MainAdapter2
import com.rajkumarrajan.mvvm_architecture.ui.main.viewmodel.MainViewModel
import com.rajkumarrajan.mvvm_architecture.ui.main.viewmodel.MainViewModel2
import com.rajkumarrajan.mvvm_architecture.utils.Status
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main2.*

//then MAIN VIEW MODEL

class MainActivity2 : AppCompatActivity() {
    private lateinit var mainViewModel2: MainViewModel2
    private lateinit var adapter2: MainAdapter2


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setupUI()
        setupViewModel()
        setupAPICall()
    }

    private fun setupUI() {
        recyclerView2.layoutManager = LinearLayoutManager(this)
        adapter2 = MainAdapter2(arrayListOf())
        recyclerView2.addItemDecoration(
            DividerItemDecoration(
                recyclerView2.context,
                (recyclerView2.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView2.adapter = adapter2
    }

    private fun setupAPICall() {
        mainViewModel2.getCustomers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { customersdata -> renderList(customersdata) }
                    recyclerView2.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView2.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
        mainViewModel2.fetchCustomers()
    }

    private fun renderList(customers: List<Customer>) {
        adapter2.addData(customers)
        adapter2.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel2 = ViewModelProviders.of(
            this,
            ViewModelFactory2(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel2::class.java)
    }
}
