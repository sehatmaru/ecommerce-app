package com.app.ecommerce.fragment.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.ecommerce.R
import com.app.ecommerce.adapter.ProductAdapter
import com.app.network.model.ProductItem
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(), HomeFragmentContract.View, ProductAdapter.ProductItemAdapterListener {

    @Inject lateinit var presenter: HomeFragmentPresenter
    private var adapter = ProductAdapter(this)
    private var listItem = ArrayList<ProductItem>()
    companion object {

        @JvmStatic fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initData()
    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvList.layoutManager = layoutManager
        rvList.adapter = adapter
    }

    private fun initData(){
        listItem.add(ProductItem(R.drawable.big_banner, "NIKE", "Predator Shoes", 125))
        listItem.add(ProductItem(R.drawable.item1, "Adidas", "NEMEZIZ Shoes", 225))
        listItem.add(ProductItem(R.drawable.item2, "Puma", "T-Shirt Puma", 19))

        adapter.initData(listItem)
    }

    override fun onClickProductItemAdapter(item: ProductItem) {

    }
}
