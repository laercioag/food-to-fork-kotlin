package com.laercioag.foodtofork.presentation.recipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.laercioag.foodtofork.R
import com.laercioag.foodtofork.domain.entity.Recipe
import com.laercioag.foodtofork.extensions.invisible
import com.laercioag.foodtofork.extensions.setSupportActionBarTitle
import com.laercioag.foodtofork.extensions.visible
import com.laercioag.foodtofork.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.recipes_fragment.*
import javax.inject.Inject

class RecipesFragment : BaseFragment(), RecipesContract.View {
    companion object {
        fun newInstance() = RecipesFragment()
    }

    @Inject
    lateinit var presenter: RecipesContract.Presenter

    private val adapter: RecipesAdapter = RecipesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.recipes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSupportActionBarTitle(R.string.title_recipes_fragment)
        setupRecyclerView()
        presenter.attach(this)
        presenter.searchRecipes()
    }

    override fun onDestroyView() {
        presenter.detach()
        super.onDestroyView()
    }

    private fun setupRecyclerView() {
        recyclerView.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@RecipesFragment.adapter
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    override fun showRecipes(items: List<Recipe>) {
        adapter.setItems(items)
    }

    override fun handleError(throwable: Throwable) {
        Log.e(RecipesFragment::class.java.simpleName, "Error", throwable)
        Toast.makeText(requireContext(), R.string.error_message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        loading.visible()
    }

    override fun hideLoading() {
        loading.invisible()
    }

}
